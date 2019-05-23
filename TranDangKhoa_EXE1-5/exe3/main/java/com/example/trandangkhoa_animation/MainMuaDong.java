package com.example.trandangkhoa_animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainMuaDong extends AppCompatActivity {
    ImageView tuyet1, tuyet2,tuyet3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mua_dong);

        setControl();
        tuyetroi();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainMuaDong.this, MainMuaXuan.class);
                startActivity(intent);
            }
        },4000);
    }

    private void setControl(){
        tuyet1 = (ImageView) findViewById(R.id.tuyet1);
        tuyet2 = (ImageView) findViewById(R.id.tuyet2);
        tuyet3 = (ImageView) findViewById(R.id.tuyet3);
    }

    private void tuyetroi(){
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.tuyetroi2);
        tuyet3.startAnimation(animation1);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.tuyetroi);
                tuyet1.startAnimation(animation1);
            }
        },1000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.tuyetroi2);
                tuyet2.startAnimation(animation1);
            }
        },2000);
    }




}
