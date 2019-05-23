package tdc.edu.vn.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin extends AppCompatActivity {
Button btnadfood,btnaddDrink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        setControl();
        setEvent();

    }
    public void setControl()
    {
        btnadfood = (Button) findViewById(R.id.addfod);
        btnaddDrink = (Button) findViewById(R.id.adddrink);
    }
    public void setEvent()
    {
        btnadfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin.this, Addfood.class);
                startActivity(intent);
            }
        });
        btnaddDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin.this, AddDrink.class);
                startActivity(intent);
            }
        });
    }
}
