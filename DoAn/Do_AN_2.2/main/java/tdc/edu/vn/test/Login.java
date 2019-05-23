package tdc.edu.vn.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    Button btnLogin,quaylai;
    EditText edtname,edtpass;
    ArrayList<QuanLy> data = new ArrayList<>();
    ArrayList<NhanVien> data1 = new ArrayList<>();
    RadioButton quanli,nhanvien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        setControl();
        setEvent();
    }
    public void setControl()
    {
        quaylai = (Button) findViewById(R.id.quaylai);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtname= (EditText)findViewById(R.id.edtAccount);
        edtpass=(EditText)findViewById(R.id.mk);
        quanli= (RadioButton) findViewById(R.id.quanli);
        nhanvien =(RadioButton) findViewById(R.id.nhanvien);
    }
    public void setEvent()
    {
        KhoiTao();
        KhoiTao1();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quanli.isChecked())
                {

                    quatrangquanli();
                }
                else
                {
                    quatrangnhanvien();
                }
            }
        });
        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void KhoiTao()
    {
        data.add(new QuanLy("ql1","12345"));
        data.add(new QuanLy("ql2","12345"));
    }
    public void KhoiTao1()
    {
        data1.add(new NhanVien("nv1","12345"));
        data1.add(new NhanVien("nguyenvanb","12345"));
    }
    public void quatrangquanli()
    {

        for (int i = 0; i < data.size(); i++){
            if (edtname.getText().toString().trim().equals(data.get(i).sname) && edtpass.getText().toString().trim().equals(data.get(i).spass) )
            {
                Intent intent = new Intent(Login.this, Admin.class);
                startActivity(intent);
                break;
            }
            else {
                Toast.makeText(this, "Bạn đã nhập sai tài khoản hoặc mật khẩu!!! Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void quatrangnhanvien(){
        for (int i = 0; i < data.size(); i++){
            if (edtname.getText().toString().trim().equals(data1.get(i).name) && edtpass.getText().toString().trim().equals(data1.get(i).pass) )
            {
                Intent intent = new Intent(Login.this, ChonBan.class);
                startActivity(intent);
                break;
            }
            else {
                Toast.makeText(this, "Bạn đã nhập sai tài khoản hoặc mật khẩu!!! Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
