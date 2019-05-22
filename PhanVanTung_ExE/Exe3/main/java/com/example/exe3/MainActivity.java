package com.example.exe3;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = (Button)findViewById(R.id.button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView cat = (ImageView)findViewById(R.id.imageView);
                cat.setImageResource(R.drawable.runningcat);
                AnimationDrawable runningCat = (AnimationDrawable)cat.getDrawable();
                runningCat.start();
            }
        });

    }
}
