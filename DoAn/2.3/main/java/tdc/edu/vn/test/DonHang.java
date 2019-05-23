package tdc.edu.vn.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DonHang extends AppCompatActivity {
    ListView listViewDH;
    HoaDonAdapter hoaDonAdapter;
    Button btntieptuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_don_hang);
        setControl();
        setEvent();
       // loadDB();
    }
    public void setControl()
    {
        btntieptuc =(Button)findViewById(R.id.tieptucAdd);
        listViewDH= (ListView)findViewById(R.id.listViewDH);
        hoaDonAdapter =new HoaDonAdapter(DonHang.this,MainActivity.manggiohang);
        listViewDH.setAdapter(hoaDonAdapter);
    }
    public void setEvent()
    {
        btntieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DonHang.this, Listmenu.class);
                startActivity(intent);
                Toast.makeText(DonHang.this, "aaa", Toast.LENGTH_SHORT).show();

            }
        });
        long tongtien;
        for(int i = 0;i < MainActivity.manggiohang.size();i++)
        {

        }

    }
//    public void loadDB() {
//        DatabaseDonHang db = new DatabaseDonHang(this);
//        data.clear();
//        db.getHoaDon(data);
//        adapter.notifyDataSetChanged();
//    }
}
