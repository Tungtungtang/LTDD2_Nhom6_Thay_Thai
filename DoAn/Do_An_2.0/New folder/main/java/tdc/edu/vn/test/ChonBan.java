package tdc.edu.vn.test;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChonBan extends AppCompatActivity {
ImageButton ban1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_ban);
        setControl();
        setEvent();
    }
    public void setControl()
    {
        ban1 =(ImageButton) findViewById(R.id.ban1);
    }
    public void setEvent()
    {
        ban1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChonBan.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Thông Báo");
                //                gắn icon

                builder.setMessage("Hãy lựa chọn bên dưới");
                builder.setIcon(R.drawable.thongbao);
                builder.setPositiveButton("Hủy Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ban1.setImageResource(R.drawable.controngne);
                    }
                });
                builder.setNegativeButton("Chọn Bàn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(ChonBan.this, Listmenu.class);
                        startActivity(intent);
                        ban1.setImageResource(R.drawable.datbane);

                    }
                });
                builder.show();

            }

        });

    }
}
