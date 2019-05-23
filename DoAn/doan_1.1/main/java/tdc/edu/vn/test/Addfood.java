package tdc.edu.vn.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Addfood extends AppCompatActivity {
Button caccle;
    private ListView listViewFood;
    ArrayList<Food> data1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfood);
        setControl();
        setEvent();
    }
    public void setControl(){
        caccle = (Button) findViewById(R.id.cance);
        listViewFood =(ListView) findViewById(R.id.listViewFood);
    }
    public void setEvent(){
        khoiTao2();
        FoodAdapter adapter = new FoodAdapter(this,R.layout.listview_food_item,data1);
        listViewFood.setAdapter(adapter);
        caccle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Addfood.this, Admin.class);
                startActivity(intent);
            }
        });
    }
    public void khoiTao2() {
        data1.add(new Food("Pho Ha Noi",R.drawable.pho,"pho ha noi","30000"));
        data1.add(new Food("Bun Bo",R.drawable.bunbo,"Bún bò Hà Nội","25000"));
        data1.add(new Food("Mi quang",R.drawable.miquang,"Mì quảng Quảng Nam","35000"));
        data1.add(new Food("Hu Tieu",R.drawable.hutieu,"Hủ tiếu Sa Đéc","350000"));
        //data1.add(new Food("E",R.drawable.ic_launcher_background));
    }
}
