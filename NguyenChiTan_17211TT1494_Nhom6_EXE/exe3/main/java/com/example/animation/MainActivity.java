package com.example.animation;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;

public class MainActivity extends AppCompatActivity {
    DayNightSwitch dayNightSwitch;
    LinearLayout mylayout;
    ImageView mattroi,mattrang,nha,cauthu1,cauthu2,banh,sao,sao1,sao2,house;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    public void setControl()
    {
        dayNightSwitch = (DayNightSwitch) findViewById(R.id.day_night_switch);
        mylayout = (LinearLayout) findViewById(R.id.mylayout);
        mattroi = (ImageView) findViewById(R.id.mattroi);
        mattrang = (ImageView) findViewById(R.id.mattrang);
        cauthu1 =(ImageView) findViewById(R.id.cauthu1);
        cauthu2 = (ImageView) findViewById(R.id.cauthu2);
        banh = (ImageView) findViewById(R.id.banh);
        sao = (ImageView) findViewById(R.id.sao);
        sao1= (ImageView) findViewById(R.id.sao1);
        sao2= (ImageView) findViewById(R.id.sao2);
        house =(ImageView) findViewById(R.id.house);
    }
    public void setEvent()
    {
        mylayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                da1();
                da2();
                bong();
            }
        });
        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean isNight) {
                if(isNight )
                {

                    sao.setImageResource(R.drawable.sao);
                    sao1.setImageResource(R.drawable.sao);
                    sao2.setImageResource(R.drawable.sao);
                    sao();
                    sao1();
                    sao2();
                    chuyencanh();
                    quaylai();
                    banh.setImageBitmap(null);
                    house.setImageResource(R.drawable.home );
                    cauthu1.setImageBitmap(null);
                    cauthu2.setImageBitmap(null);
                    mattrang.setImageResource(R.drawable.mattrang1);
                    Toast.makeText(MainActivity.this, "Đây là buổi tối !!!", Toast.LENGTH_LONG).show();
                    mylayout.setBackgroundColor(Color.parseColor("#070707"));
                    blink();
                }
                else
                {
                    house.setImageBitmap(null);
                    sao.setImageBitmap(null);
                    sao1.setImageBitmap(null);
                    sao2.setImageBitmap(null);
                    chuyencanh1();
                    da1();
                    da2();
                    banh.setImageResource(R.drawable.banh);
                    cauthu1.setImageResource(R.drawable.quanghai);
                    cauthu2.setImageResource(R.drawable.vanhau);

                    //mattrang.setImageBitmap(null);
                    bong();
                    mattroi.setImageResource(R.drawable.mattroi);
                    Toast.makeText(MainActivity.this, "Đây là buổi sáng !!!", Toast.LENGTH_LONG).show();
                    mylayout.setBackgroundColor(Color.parseColor("#3CDBEE"));
                    fade1();
                    mattrang.setImageResource(R.drawable.air_plane);
                    move();
                }
            }
        });

    }
    public void fade1() {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
        mattroi.startAnimation(animation1);
    }
    public void bong() {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.moveb);
        banh.startAnimation(animation1);
    }
    public void move() {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        mattrang.startAnimation(animation1);
    }
    public void blink() {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        mattrang.startAnimation(animation1);
    }
    public void quaylai() {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.movec);
        mattroi.startAnimation(animation1);
    }
    public void da1() {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.quay1);
        cauthu1.startAnimation(animation1);
    }
    public void da2() {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.quay2);
        cauthu2.startAnimation(animation1);
    }
    public void chuyencanh() {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.chuyencanh);
        mylayout.startAnimation(animation1);
    }
    public void chuyencanh1() {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.chuyencanh);
        mylayout.startAnimation(animation1);
    }
    public void sao() {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.saonhapnhay);
        sao.startAnimation(animation1);
    }
    public void sao1() {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.saonhapnhay);
        sao1.startAnimation(animation1);
    }
    public void sao2() {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.saonhapnhay);
        sao2.startAnimation(animation1);
    }

}
