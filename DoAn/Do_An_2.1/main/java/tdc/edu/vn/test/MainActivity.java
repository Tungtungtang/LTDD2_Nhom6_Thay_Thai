package tdc.edu.vn.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static String drink = "";
    public static String food = "";
    private Button btnLogin;
    ImageButton login,login1;
    ArrayList<Drink> data = new ArrayList<>();
    ArrayList<Food> data1 = new ArrayList<>();
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
       setEvent();
    }
    public void setControl()
    {
        login = (ImageButton) findViewById(R.id.login);
        login1 = (ImageButton) findViewById(R.id.login1);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void setEvent() {
        khoiTao1();
      //  khoiTao2();
//        FoodAdapter adapter1 = new FoodAdapter(this,R.layout.listview_food_item,data1);
//        listViewFood.setAdapter(adapter1);
//        DrinkAdapter adapter = new DrinkAdapter(this, R.layout.listview_drink_item, data);
//        listViewDrink.setAdapter(adapter);
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuanLyNhanVien.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
    }
    public void khoiTao1() {

//        data1.add(new Food("Pesi", R.drawable.pepsi, "nuoc giai khat", "50000"));
//        data1.add(new Food("Coca", R.drawable.coca,"nước giải khát","8000"));
//        data1.add(new Food("Nuoc Cam", R.drawable.nuocam,"nước giải khát","10000"));
//        data1.add(new Food("Aquafina", R.drawable.nuocsuoi,"nước giải khát","9000"));
//        data1.add(new Food("Pho Ha Noi",R.drawable.pho,"pho ha noi","30000"));
//        data1.add(new Food("Bun Bo",R.drawable.bunbo,"Bún bò Hà Nội","25000"));
//        data1.add(new Food("Mi quang",R.drawable.miquang,"Mì quảng Quảng Nam","35000"));
//        data1.add(new Food("Hu Tieu",R.drawable.hutieu,"Hủ tiếu Sa Đéc","350000"));
    }
//    public void khoiTao2() {
//        data1.add(new Food("Pho Ha Noi",R.drawable.pho,"pho ha noi","30000"));
//       data1.add(new Food("Bun Bo",R.drawable.bunbo,"Bún bò Hà Nội","25000"));
//       data1.add(new Food("Mi quang",R.drawable.miquang,"Mì quảng Quảng Nam","35000"));
//       data1.add(new Food("Hu Tieu",R.drawable.hutieu,"Hủ tiếu Sa Đéc","350000"));
//        //data1.add(new Food("E",R.drawable.ic_launcher_background));
//    }




//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.menuSetting:
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
