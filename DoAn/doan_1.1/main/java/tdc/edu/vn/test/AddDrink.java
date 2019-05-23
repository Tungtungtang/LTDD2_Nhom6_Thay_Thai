package tdc.edu.vn.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class AddDrink extends AppCompatActivity {
    Button addDrink,cancle;
    private ListView listViewDrink;
    ArrayList<Drink> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drink);
        setControl();
        setEvent();
    }
    public void setControl()
    {
        addDrink =(Button) findViewById(R.id.adddrink);
        cancle = (Button) findViewById(R.id.cancle);
        listViewDrink = (ListView) findViewById(R.id.listViewDrink);
    }
    public void setEvent()
    {
        khoiTao1();
        DrinkAdapter adapter = new DrinkAdapter(this, R.layout.listview_drink_item, data);
        listViewDrink.setAdapter(adapter);
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddDrink.this, Admin.class);
                startActivity(intent);
            }
        });
    }
    public void khoiTao1() {

        data.add(new Drink("Pesi", R.drawable.pepsi, "nuoc giai khat", "50000"));
        data.add(new Drink("Coca", R.drawable.coca,"nước giải khát","8000"));
        data.add(new Drink("Nuoc Cam", R.drawable.nuocam,"nước giải khát","10000"));
        data.add(new Drink("Aquafina", R.drawable.nuocsuoi,"nước giải khát","9000"));
    }
}
