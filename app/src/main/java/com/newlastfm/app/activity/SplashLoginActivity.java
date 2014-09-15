package com.newlastfm.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.newlastfm.app.AppContext;
import com.newlastfm.app.Constants;
import com.newlastfm.app.MainActivity_;
import com.newlastfm.app.R;
import com.newlastfm.app.Utils;
import com.newlastfm.app.rest.RequestResult;
import com.newlastfm.app.validation.IValidatable;
import com.newlastfm.app.validation.TextValidationListener;
import com.newlastfm.model.SessionData;
import com.newlastfm.model.User;
import com.newlastfm.model.UserData;

import org.androidannotations.annotations.AfterTextChange;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

@EActivity(R.layout.activity_splash_login)
public class SplashLoginActivity extends Activity implements Animation.AnimationListener, IValidatable {

    @Bean
    AppContext ctx;
    @ViewById(R.id.logoText)
    TextView logoText;
    @ViewById(R.id.logoView)
    ImageView logoView;
    @ViewById(R.id.login)
    EditText login;
    @ViewById(R.id.password)
    EditText password;
    @ViewById(R.id.signIn)
    Button signIn;

    Animation splashAnimation;
    Animation loginFormAnimation;
    String apiSig;
    String apiSigRecommendedArtists;
    RequestResult<SessionData> result;
    String sk;
    SessionData sessionData;

    @AfterViews
    void init() {
        splashAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_zoom_out);
        loginFormAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_on);
        loginFormAnimation.setAnimationListener(this);
        splashAnimation.setAnimationListener(this);
        logoText.setAnimation(splashAnimation);
        logoView.setAnimation(splashAnimation);
        login.setAnimation(loginFormAnimation);
        password.setAnimation(loginFormAnimation);
        signIn.setAnimation(loginFormAnimation);
    }

    @Click(R.id.signIn)
    void signInClick() {
        performSignIn();
    }

    void performSignIn() {
        if (validate()) {
            login();
        }
    }

    void doBackground() {
        String jsonResponse = "";
        String urlString = Constants.apiUrl +
                "method=" + "auth.getMobileSession" + "&password=" + password.getText().toString()
                + "&username=" + login.getText().toString() + "&api_key" +
                "=" + Constants.apiKey + "&api_sig=" + apiSig + "&format=json";
        try {
            URL url = new URL(Constants.apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);

            OutputStream dataOutputStream = urlConnection.getOutputStream();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(dataOutputStream));

            String post = urlString.substring(35);
            writer.write(post);
            writer.close();

            int responseCode = urlConnection.getResponseCode();
            if (responseCode == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                jsonResponse = sb.toString();
            }
            Gson gson = new Gson();
            sessionData = gson.fromJson(jsonResponse, SessionData.class);
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(urlConnection.getInputStream());
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("session");
            if (nodeList.getLength() > 0 && nodeList != null) {
                NodeList subList = nodeList.item(0).getChildNodes();
                if (subList.getLength() > 0 && subList != null) {
                    NodeList userNameList = subList.item(1).getChildNodes();//username
                    NodeList keyList = subList.item(3).getChildNodes();//key

                    String username_value = userNameList.item(0).getNodeValue();
                    sk = keyList.item(0).getNodeValue();
                    ;
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Background
    void login() {
        apiSig = Utils.buildApiSig(Constants.apiKey, "auth.getMobileSession", password.getText().toString(),
                login.getText().toString(), Constants.secret);
        String params = "method=" + "auth.getMobileSession" + "&password=" + password.getText().toString()
                + "&username=" + login.getText().toString() + "&api_key" +
                "=" + Constants.apiKey + "&api_sig=" + apiSig + "&format=json";
        sessionData = ctx.api.manualLogin(params);
        apiSigRecommendedArtists = Utils.buildApiSig(Constants.apiKey, "user.getRecommendedArtists",
                sessionData.getSession().getKey(), Constants.secret);
        Log.i(Constants.TAG, apiSigRecommendedArtists);
        storeUser();
    }

    @Background
    void storeUser() {
        UserData.UserInfo userData = ctx.api.getUserInfo(Constants.methodGetUserInfo, login.getText().toString(),
                Constants.apiKey, "json").getData().getUser();
        User user = User.newInstance(
                userData.getName(),
                userData.getRealname(),
                userData.getImage().get(3).getText(),
                userData.getPlaycount(),
                userData.getUrl(),
                userData.getCountry(),
                userData.getAge(),
                userData.getGender(),
                userData.getRegistered().getText(),
                userData.getPlaylists(),
                sessionData.getSession().getKey()
        );
        ctx.storage.update(user);
        afterLogin();
    }

    @UiThread
    void afterLogin() {
        if (ctx.storage.getUser() != null) {
            onSuccessfulLogin();
        } else {
            Toast.makeText(this, "There were errors during the signing in. Try again.", Toast.LENGTH_SHORT).show();
        }
    }

    private void onSuccessfulLogin() {
        Toast.makeText(this, "Signed In successfully", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), MainActivity_.class));
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public boolean validate() {
        boolean isValid = true;
        if (login.getText().toString().isEmpty()) {
            login.setError("Login can't be empty");
            isValid = false;
        } else if (password.getText().toString().isEmpty()) {
            password.setError("Password can't be empty");
            isValid = false;
        }
        if (isValid) {
            final TextValidationListener textValidationListener = new TextValidationListener(this);
            login.addTextChangedListener(textValidationListener);
            password.addTextChangedListener(textValidationListener);
        }
        return isValid;
    }

    @AfterTextChange(R.id.login)
    void afterLoginChanged() {
        if (login.getText().toString().isEmpty()) {
            login.setError("Login can't be empty");
        }
    }

    @AfterTextChange(R.id.password)
    void afterPasswordChanged() {
        if (password.getText().toString().isEmpty()) {
            password.setError("Password can't be empty");
        }
    }
}
