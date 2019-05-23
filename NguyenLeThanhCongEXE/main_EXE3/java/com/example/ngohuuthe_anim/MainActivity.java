package com.example.ngohuuthe_anim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ImageView imgXe,imgDiaCau,imgDay,imgAnimeVN,imgTay;
    Button btnRun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    private void setControl(){
        imgXe = (ImageView) findViewById(R.id.imgxe);
        imgDiaCau = (ImageView) findViewById(R.id.imgtraidat);
        imgDay = (ImageView) findViewById(R.id.imgday);
        imgAnimeVN = (ImageView) findViewById(R.id.imganimevn);
        imgTay = (ImageView) findViewById(R.id.icontay);
        btnRun = (Button) findViewById(R.id.btnrun);
    }
    private void setEvent(){

        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation traidat = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.traidatquay);
                imgDiaCau.startAnimation(traidat);
                //xe chay
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Animation xechay = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.xechay);
                        imgXe.startAnimation(xechay);
                    }
                },2500);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Animation tayDay = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.tayday);
                        imgTay.startAnimation(tayDay);
                    }
                },2000);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Animation animeVN = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.xekeo);
                        imgAnimeVN.startAnimation(animeVN);
                    }
                },7500);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Animation Day = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.xekeo);
                        imgDay.startAnimation(Day);
                    }
                },7500);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, main_item.class);
                        startActivity(intent);
                    }
                },11000);
            }
        });
    }
}
