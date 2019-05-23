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

public class MainMuaXuan extends AppCompatActivity {
    AnimationDrawable pinAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mua_xuan);


        ImageView image1 = (ImageView) findViewById(R.id.image1);
        image1.setBackgroundResource(R.drawable.animation_muaxuan);
        pinAnimation = (AnimationDrawable) image1.getBackground();

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bayngang);
        image1.startAnimation(animation1);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainMuaXuan.this, MainMuaHa.class);
                startActivity(intent);
            }
        },2500);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        pinAnimation.start();
    }
}
