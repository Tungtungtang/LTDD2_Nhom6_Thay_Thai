package com.example.ngohuuthe_anim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class main_item extends AppCompatActivity {
    ImageView imgDay1,imgAnimeVN1,imgsxe1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        setControl();
        animechay();
        daychay();
        xechay();
//        setEvent();
    }
    private void setControl(){
        imgDay1 = (ImageView) findViewById(R.id.imgday1);
        imgAnimeVN1 = (ImageView) findViewById(R.id.imganimevn1);
        imgsxe1 = (ImageView) findViewById(R.id.imgxe1);
    }
    public void animechay(){
        Animation animeVN1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.xekeo1);
        imgAnimeVN1.startAnimation(animeVN1);
    }
    public void daychay(){
        Animation Day1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.xekeo1);
        imgDay1.startAnimation(Day1);
    }
    public void xechay(){
        Animation imxe1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.xekeo1);
        imgsxe1.startAnimation(imxe1);
    }
}
