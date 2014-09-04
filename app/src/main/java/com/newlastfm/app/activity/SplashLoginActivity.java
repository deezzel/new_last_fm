package com.newlastfm.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    RequestResult<SessionData> result;

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

    @Background
    void login() {
        apiSig = Utils.buildApiSig(Constants.apiKey, "auth.getMobileSession", password.getText().toString(),
                login.getText().toString(), Constants.secret);
        result = ctx.api.login(login.getText().toString(), password.getText().toString(), Constants.apiKey, apiSig,
                "auth.getMobileSession", "json");
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
                userData.getPlaylists()
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
