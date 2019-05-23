package tdc.edu.vn.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Admin extends AppCompatActivity {
Button btnadfood,btnaddDrink;
    ArrayList<Drink> datadrink = new ArrayList<>();
    ArrayList<Food> data = new ArrayList<>();
    ListView listView1,listView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        setControl();
        setEvent();

    }
    public void setControl()
    {
        listView1=(ListView) findViewById(R.id.listView1);
        listView2=(ListView)findViewById(R.id.listView2);
        btnadfood = (Button) findViewById(R.id.addfod);
        btnaddDrink = (Button) findViewById(R.id.adddrink);
    }
    public void setEvent()
    {
        loadFood();
        loadDrink();
        FoodAdapter adapter = new FoodAdapter(this, R.layout.listview_food_item, data);
        listView1.setAdapter(adapter);
        DrinkAdapter adapter1 = new DrinkAdapter(this, R.layout.listview_drink_item, datadrink);
        listView2.setAdapter(adapter1);
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
    public void loadFood() {
        DatabaseFood dbfood = new DatabaseFood(this);
        data.clear();
        dbfood.getFood(data);
        // adapterfood.notifyDataSetChanged();
    }
    public void loadDrink() {
        DatabaseDrink db = new DatabaseDrink(this);
        datadrink.clear();
        db.getDrink(datadrink);
        // adapterdrink.notifyDataSetChanged();
    }
}
