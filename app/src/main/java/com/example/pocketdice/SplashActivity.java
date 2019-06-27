package com.example.pocketdice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    ImageView ivName,ivDice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ivDice=(ImageView)findViewById(R.id.ivDice);
        Animation myanim = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.mytransation);
        ivDice.startAnimation(myanim);
        final Intent intent=new Intent(SplashActivity.this,MainActivity.class);
        Thread timer =new Thread()
        {
          public void run()
          {
              try {
                  sleep(3000);
              }catch (InterruptedException e)
              {
                  e.printStackTrace();
              }finally {
                startActivity(intent);
                finish();
              }
          }
        };
        timer.start();
    }
}
