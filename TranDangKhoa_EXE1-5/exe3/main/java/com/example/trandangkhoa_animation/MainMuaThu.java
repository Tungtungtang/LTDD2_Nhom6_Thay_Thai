package com.example.trandangkhoa_animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainMuaThu extends AppCompatActivity {
    ImageView laroi, giothoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mua_thu);

        setControl();
        laroi();
        giothoi();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainMuaThu.this, MainMuaDong.class);
                startActivity(intent);
            }
        }, 3500);

    }

    private void setControl() {
        laroi = (ImageView) findViewById(R.id.lamuathu);
        giothoi = (ImageView) findViewById(R.id.giomuathu);
    }

    private void laroi() {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.roivaxoay);
        laroi.startAnimation(animation1);
    }

    private void giothoi() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bayngang);
                giothoi.startAnimation(animation2);
            }
        }, 2000);
    }
}
