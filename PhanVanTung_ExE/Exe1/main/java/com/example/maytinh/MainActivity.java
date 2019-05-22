package com.example.maytinh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnCong;
    Button btnTru;
    Button btnNhan;
    Button btnChia;
    EditText soA;
    EditText soB;
    EditText kq;
    int a;
    int b;
    int ikq;
    int kqcong;
    int kqtru;
    int kqnhan;
    int kqchia;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Adapter adapter;
    ArrayList<PhepTinh> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        setEvent();
        setAdapter();
    }

    public void setControl() {
        btnCong = (Button) findViewById(R.id.btnCong);
        btnTru = (Button) findViewById(R.id.btnTru);
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnChia = (Button) findViewById(R.id.btnChia);
        soA = (EditText) findViewById(R.id.soA);
        soB = (EditText) findViewById(R.id.soB);
    }

    public void setEvent() {

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhepTinh pt = new PhepTinh();
                a = Integer.parseInt(soA.getText().toString());
                b = Integer.parseInt(soB.getText().toString());

                pt.setKq("Số " + a + " cộng số " + b + " = "  + (a + b) + "");

                data.add(pt);
                adapter.notifyDataSetChanged();
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhepTinh pt = new PhepTinh();
                a = Integer.parseInt(soA.getText().toString());
                b = Integer.parseInt(soB.getText().toString());

                pt.setKq("Số " + a + " trừ số " + b + " = " + (a - b) + "");

                data.add(pt);
                adapter.notifyDataSetChanged();
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhepTinh pt = new PhepTinh();
                a = Integer.parseInt(soA.getText().toString());
                b = Integer.parseInt(soB.getText().toString());

                pt.setKq("Số " + a + " nhân số " + b + " = " + (a * b) + "");

                data.add(pt);
                adapter.notifyDataSetChanged();
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhepTinh pt = new PhepTinh();
                double aa = Double.parseDouble(soA.getText().toString());
                double bb = Double.parseDouble(soB.getText().toString());

                pt.setKq("Số " + a + " chia số " + b + " = " + (aa / bb) + "");

                data.add(pt);
                adapter.notifyDataSetChanged();
            }
        });

    }

    public void setAdapter(){
        recyclerView = findViewById(R.id.recylerview);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(this,data,R.layout.listview_item);
        recyclerView.setAdapter(adapter);
    }
}
