package com.project_sajal.bojmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;


public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        TextView textView=findViewById(R.id.appname);
        textView.animate().setDuration(2000).translationX(0);
        textView.animate().setDuration(2000).translationY(0);
        textView.animate().setDuration(2000).rotationX(360);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent SplashIntent = new Intent(Splashscreen.this, Login.class);
                startActivity(SplashIntent);
                finish();
            }
        },5000);
    }
}
