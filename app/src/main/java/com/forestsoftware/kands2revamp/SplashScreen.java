package com.forestsoftware.kands2revamp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Adeoy3 on 3/29/2017.
 */

//public class SplashScreen extends AppCompatActivity
//{
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//       setContentView(R.layout.splash_screen);
//
//        for (int i=0; i<7000; i++){}
//        startActivity(new Intent(this,MainActivity.class));
//        finish();
//
//
//    }
//    }

public class SplashScreen extends Activity
{
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);

                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}