package tdc.edu.vn.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class QuanLyNhanVien extends AppCompatActivity {
    Button login,quaylai;
    EditText edtname,edtpass;
    ArrayList<NhanVien> data = new ArrayList<>();
    String user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_nhan_vien);
        setControl();
        setEvent();
    }
    public void setControl()
    {
        edtname= (EditText)findViewById(R.id.edtNVname);
        edtpass =(EditText)findViewById(R.id.edtNVpass) ;
        login =(Button) findViewById(R.id.btnLogin);
        quaylai=(Button) findViewById(R.id.quaylai);
    }
    public void setEvent()
    {
        KhoiTao();
        final NhanVien nv = new NhanVien();
        user = nv.name;
        pass = nv.pass;
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               quatrang();

//                Intent intent = new Intent(QuanLyNhanVien.this, ChonBan.class);
//                startActivity(intent);
            }
        });

        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuanLyNhanVien.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    public void KhoiTao()
    {
     data.add(new NhanVien("aaaa","12345"));
//     data.add(new NhanVien("NguyenvanA","12345"));
    }

    public void quatrang(){
        for (int i = 0; i < data.size(); i++){
            if (edtname.getText().toString().trim().equals(data.get(i).name) && edtpass.getText().toString().trim().equals(data.get(i).pass) )
            {
                Intent intent = new Intent(QuanLyNhanVien.this, ChonBan.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Sai tai khoan hoac mat khau!!", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
