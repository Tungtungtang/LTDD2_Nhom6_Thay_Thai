package com.example.trandangkhoa_17211tt1738;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btndau, btnthan, btnchan, btnkq, btnXoa;
    Button btndaunar, btnthannar, btnchannar;
    ImageView imagedau, imagethan, imagechan;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Adapter adapter;
    ArrayList<HinhAnh> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        setEvent();
        setAdapter();
    }

    public void setControl() {
        imagedau = (ImageView) findViewById(R.id.imagedau);
        imagethan = (ImageView) findViewById(R.id.imagethan);
        imagechan = (ImageView) findViewById(R.id.imagechan);
        btnkq = (Button) findViewById(R.id.btnkq);
        btndau = (Button) findViewById(R.id.btndau);
        btnthan = (Button) findViewById(R.id.btnthan);
        btnchan = (Button) findViewById(R.id.btnchan);
        btnXoa = (Button) findViewById(R.id.btnxoa);
        btndaunar = (Button) findViewById(R.id.btndaunar);
        btnthannar = (Button) findViewById(R.id.btnthannar);
        btnchannar = (Button) findViewById(R.id.btnchannar);
    }


    HinhAnh ha = new HinhAnh();

    public void setEvent() {
        btndau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ha.setDau(R.drawable.sasukeuchiha);
                imagedau.setImageResource(R.drawable.sasukeuchiha);

            }
        });

        btnthan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ha.setThan(R.drawable.thanssk);
                imagethan.setImageResource(R.drawable.thanssk);
            }
        });

        btnchan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ha.setChan(R.drawable.chanssk);
                imagechan.setImageResource(R.drawable.chanssk);
            }
        });

        btndaunar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ha.setDau(R.drawable.daunar);
                imagedau.setImageResource(R.drawable.daunar);
            }
        });

        btnthannar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ha.setThan(R.drawable.thannar);
                imagethan.setImageResource(R.drawable.thannar);
            }
        });

        btnchannar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ha.setChan(R.drawable.channar);
                imagechan.setImageResource(R.drawable.channar);
            }
        });



        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove(ha);//xoa 1
                adapter.notifyDataSetChanged();
            }
        });

        btnkq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imagedau.setImageResource(0);
                imagethan.setImageResource(0);
                imagechan.setImageResource(0);


                data.add(ha);
                adapter.notifyDataSetChanged();

            }
        });

    }

    public void setAdapter() {
        recyclerView = findViewById(R.id.recylerview);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(this, data, R.layout.listview);
        recyclerView.setAdapter(adapter);
    }
}
