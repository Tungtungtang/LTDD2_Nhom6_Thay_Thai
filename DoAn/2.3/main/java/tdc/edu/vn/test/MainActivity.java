package tdc.edu.vn.test;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
    TextView logintv;
    ArrayList<Drink> data = new ArrayList<>();
    ArrayList<Food> data1 = new ArrayList<>();
    public static  ArrayList<HoaDon> manggiohang;
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
        logintv =  (TextView)findViewById(R.id.login2);
        if(manggiohang!=null)
        {

        }
        else
        {
            manggiohang= new ArrayList<>();
        }

    }
    public void setEvent() {
        khoiTao1();
      //  khoiTao2();
//        FoodAdapter adapter1 = new FoodAdapter(this,R.layout.listview_food_item,data1);
//        listViewFood.setAdapter(adapter1);
//        DrinkAdapter adapter = new DrinkAdapter(this, R.layout.listview_drink_item, data);
//        listViewDrink.setAdapter(adapter);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
        logintv.setOnClickListener(new View.OnClickListener() {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.login:
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                break;

            case R.id.exit:

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Thông Báo");
                //                gắn icon
                builder.setMessage("Bạn Có Muốn Thóat Khỏi Chương Trình Không?");
                builder.setIcon(R.drawable.thongbao);
                builder.setPositiveButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // để trống vì khi chọn nó sẽ k xay ra skien gì cả
                    }
                });
                builder.setNegativeButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent startMain = new Intent(Intent.ACTION_MAIN);
                        startMain.addCategory(Intent.CATEGORY_HOME);
                        startActivity(startMain);
                        finish();
                    }
                });
                builder.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
