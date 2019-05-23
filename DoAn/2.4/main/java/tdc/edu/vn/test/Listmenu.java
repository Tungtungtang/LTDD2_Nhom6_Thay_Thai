package tdc.edu.vn.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Listmenu extends AppCompatActivity {
    private ListView listViewFood;
    private ListView listViewWater;
    ArrayList<Drink> datadrink = new ArrayList<>();
    ArrayList<Food> datafood = new ArrayList<>();
    FoodAdapter adapterfood = null;
    DrinkAdapter adapterdrink = null;
    ImageButton drink,food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listmenu);
        setControl();
        setEvent();


    }
    public void setControl()
    {
        listViewFood = (ListView) findViewById(R.id.listviewchon);
        listViewWater = (ListView) findViewById(R.id.listviewchon);
        drink =(ImageButton) findViewById(R.id.drink);
        food =(ImageButton) findViewById(R.id.food);

    }


    public void setEvent()
    {
       final FoodAdapter adapter = new FoodAdapter(this, R.layout.listview_food_item, datafood);
       final DrinkAdapter adapter1 = new DrinkAdapter(this, R.layout.listview_drink_item, datadrink);



        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadDrink();
                listViewWater.setAdapter(adapter1);
                listViewWater.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(getApplicationContext(),Information_product.class);
                        intent.putExtra("thongtindrink",datadrink.get(i));
                        startActivity(intent);
                    }
                });

            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFood();
                listViewFood.setAdapter(adapter);
                listViewFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(getApplicationContext(),Information_food.class);
                        intent.putExtra("thongtinfood",datafood.get(i));
                        startActivity(intent);
                    }
                });

            }
        });










    }
    public void loadFood() {
        DatabaseFood dbfood = new DatabaseFood(this);
        datafood.clear();
        dbfood.getfood(datafood);
      // adapterfood.notifyDataSetChanged();
    }
    public void loadDrink() {
        DatabaseDrink db = new DatabaseDrink(this);
        datadrink.clear();
        db.getDrink(datadrink);
       // adapterdrink.notifyDataSetChanged();
    }
    public void khoiTao1() {

//        data.add(new Drink("Pesi", R.drawable.pepsi, "nuoc giai khat", "50000"));
//        data.add(new Drink("Coca", R.drawable.coca,"nước giải khát","8000"));
//        data.add(new Drink("Nuoc Cam", R.drawable.nuocam,"nước giải khát","10000"));
//        data.add(new Drink("Aquafina", R.drawable.nuocsuoi,"nước giải khát","9000"));
    }
    public void khoiTao2() {
//        data1.add(new Food("Pho Ha Noi",R.drawable.pho,"pho ha noi","30000"));
//       data1.add(new Food("Bun Bo",R.drawable.bunbo,"Bún bò Hà Nội","25000"));
//       data1.add(new Food("Mi quang",R.drawable.miquang,"Mì quảng Quảng Nam","35000"));
//       data1.add(new Food("Hu Tieu",R.drawable.hutieu,"Hủ tiếu Sa Đéc","350000"));

    }
}
