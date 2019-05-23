package tdc.edu.vn.test;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class XuatHoaDon extends AppCompatActivity {
    static TextView tongtienhd;
    ListView listViewHoaDon;
    HoaDonAdapter hoaDonAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuat_hoa_don);
        setControl();
        setEvent();
       // catchOnItemListView();
    }


    //xoa sp
//    private void catchOnItemListView() {
//        listViewHoaDon.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(XuatHoaDon.this);
//                builder.setTitle("Xac nhan xoa san pham");
//                 builder.setMessage("Ban co chac muon xoa san pham nay");
//                return false;
//            }
//        });
//    }

    public void setControl()
    {
        listViewHoaDon = (ListView)findViewById(R.id.listViewHoaDon);
        tongtienhd =(TextView)findViewById(R.id.tongtienhd);
        hoaDonAdapter =new HoaDonAdapter(XuatHoaDon.this,MainActivity.manggiohang);
        listViewHoaDon.setAdapter(hoaDonAdapter);
    }
    public void setEvent()
    {
        int tongtien=0;
        for(int i = 0;i < MainActivity.manggiohang.size();i++)
        {
            tongtien += MainActivity.manggiohang.get(i).getGia();
        }
        DecimalFormat decimalFormat =new DecimalFormat("###,###,###");
        tongtienhd.setText(decimalFormat.format(tongtien) + "Đ");
    }


}
