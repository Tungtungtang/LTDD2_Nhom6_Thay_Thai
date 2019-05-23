package tdc.edu.vn.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    Button btnLogin,quaylai;
    EditText edtname,edtpass;
    ArrayList<QuanLy> data = new ArrayList<>();
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
    }
    public void setEvent()
    {
        KhoiTao();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quatrang();
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
    public void quatrang()
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
}
