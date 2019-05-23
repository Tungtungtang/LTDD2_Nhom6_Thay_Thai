package tdc.edu.vn.tuan1_trandangkhoa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        kq = (EditText) findViewById(R.id.kq);
    }

    public void setEvent() {

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhepTinh phepTinh = new PhepTinh();
                phepTinh.setSoA(soA.getText().toString());
                phepTinh.setSoB(soB.getText().toString());
                phepTinh.setPT("+");
                phepTinh.setKQ(kq.getText().toString());
                a = Integer.parseInt(soA.getText() + "");
                b = Integer.parseInt(soB.getText() + "");
                ikq = Integer.parseInt(kq.getText() + "");
                kqcong = a + b;
                if (kqcong == ikq) {
                    phepTinh.setImage(R.drawable.ic_check_black_24dp);
                    //Toast.makeText(MainActivity.this, "Dung", Toast.LENGTH_SHORT).show();
                } else {
                    phepTinh.setImage(R.drawable.ic_close_black_24dp);
                    //Toast.makeText(MainActivity.this, "Sai", Toast.LENGTH_SHORT).show();
                }

                data.add(phepTinh);
                adapter.notifyDataSetChanged();
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhepTinh phepTinh = new PhepTinh();
                phepTinh.setSoA(soA.getText().toString());
                phepTinh.setSoB(soB.getText().toString());
                phepTinh.setPT("-");
                phepTinh.setKQ(kq.getText().toString());
                a = Integer.parseInt(soA.getText() + "");
                b = Integer.parseInt(soB.getText() + "");
                ikq = Integer.parseInt(kq.getText() + "");
                kqtru = a - b;
                if (kqtru == ikq) {
                    phepTinh.setImage(R.drawable.ic_check_black_24dp);
                    //Toast.makeText(MainActivity.this, "Dung", Toast.LENGTH_SHORT).show();
                } else {
                    phepTinh.setImage(R.drawable.ic_close_black_24dp);
                    //Toast.makeText(MainActivity.this, "Sai", Toast.LENGTH_SHORT).show();
                }
                data.add(phepTinh);
                adapter.notifyDataSetChanged();
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhepTinh phepTinh = new PhepTinh();
                phepTinh.setSoA(soA.getText().toString());
                phepTinh.setSoB(soB.getText().toString());
                phepTinh.setPT("*");
                phepTinh.setKQ(kq.getText().toString());
                a = Integer.parseInt(soA.getText() + "");
                b = Integer.parseInt(soB.getText() + "");
                ikq = Integer.parseInt(kq.getText() + "");
                kqnhan = a * b;
                if (kqnhan == ikq) {
                    phepTinh.setImage(R.drawable.ic_check_black_24dp);
                    //Toast.makeText(MainActivity.this, "Dung", Toast.LENGTH_SHORT).show();
                } else {
                    phepTinh.setImage(R.drawable.ic_close_black_24dp);
                    //Toast.makeText(MainActivity.this, "Sai", Toast.LENGTH_SHORT).show();
                }
                data.add(phepTinh);
                adapter.notifyDataSetChanged();
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhepTinh phepTinh = new PhepTinh();
                phepTinh.setSoA(soA.getText().toString());
                phepTinh.setSoB(soB.getText().toString());
                phepTinh.setPT("/");
                phepTinh.setKQ(kq.getText().toString());
                a = Integer.parseInt(soA.getText() + "");
                b = Integer.parseInt(soB.getText() + "");
                ikq = Integer.parseInt(kq.getText() + "");
                kqchia = a / b;
                if (kqchia == ikq) {
                    phepTinh.setImage(R.drawable.ic_check_black_24dp);
                    //Toast.makeText(MainActivity.this,  "Dung", Toast.LENGTH_SHORT).show();
                } else {
                    phepTinh.setImage(R.drawable.ic_close_black_24dp);
                    //Toast.makeText(MainActivity.this, "Sai", Toast.LENGTH_SHORT).show();
                }
                data.add(phepTinh);
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
