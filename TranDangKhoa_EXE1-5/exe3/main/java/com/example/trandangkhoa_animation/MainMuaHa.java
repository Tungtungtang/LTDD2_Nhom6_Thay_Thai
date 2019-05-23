package com.example.trandangkhoa_animation;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainMuaHa extends AppCompatActivity {
    AnimationDrawable cucPin;
    ImageView mattroi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mua_ha);

        ImageView sacpin = (ImageView) findViewById(R.id.sacpin);
        sacpin.setBackgroundResource(R.drawable.animation_muaha);
        cucPin = (AnimationDrawable) sacpin.getBackground();

        mattroi = (ImageView) findViewById(R.id.mattroi);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.toanang);
        mattroi.startAnimation(animation);


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainMuaHa.this, MainMuaThu.class);
                startActivity(intent);
            }
        }, 5000);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        cucPin.start();
    }
}
