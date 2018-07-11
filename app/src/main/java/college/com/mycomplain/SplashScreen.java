package college.com.mycomplain;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {


    private static final String USER_IS_LOGIN = "UserIsLogin";
    private static final String UI_ID_FIREBASE = "UiIdFirebase";
    // Duration of wait
//    private final int SPLASH_DISPLAY_LENGTH = 2000;

    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;
//    private SharedPreferences prefs = mApplication.getApplicationPreferences();
//    private SharedPreferences.Editor editor = prefs.edit();
//    private User mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mAuth = FirebaseAuth.getInstance();
//        mUser = User.getInstance();

                mAuthListener = new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        if (user != null) {
                            // User is signed in
//                            mUser.setLoginState(true);
//                            mUser.setUiIdFirebase(user.getUid());
//                            editor.putBoolean(USER_IS_LOGIN, true);
//                            editor.putString(UI_ID_FIREBASE, user.getUid());
//                            editor.commit();
                             StartMainActivity();
                            SplashScreen.this.finish();
                        } else {
                            // User is signed out
//                            mUser.setLoginState(false);
//                            editor.putBoolean(USER_IS_LOGIN, false);
//                            editor.commit();
                            StartSignInActivity();
                            SplashScreen.this.finish();
                        }
                    }
                };
                //add listener
                mAuth.addAuthStateListener(mAuthListener);
            }



    public void StartMainActivity (){
         Intent i = new Intent(SplashScreen.this,DirectActivity.class);
        startActivity(i);
        finish();
    }

    public void StartSignInActivity (){
        Intent i = new Intent(SplashScreen.this,GoogleSignIn.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
