package com.newlastfm.app.activity;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.newlastfm.app.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_splash)
public class SplashActivity extends Activity implements Animation.AnimationListener {

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
}
