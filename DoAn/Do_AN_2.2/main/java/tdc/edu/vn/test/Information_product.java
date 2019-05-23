package tdc.edu.vn.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Information_product extends AppCompatActivity {
TextView priceprocut,nameproduct,introduceproduct;
Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_product);
        setControl();
        getSanPhamDrink();
        Catchspiner();
       // getSanPhamFood();
    }
    public void setControl()
    {
        priceprocut =(TextView)findViewById(R.id.priceproduct);
        introduceproduct = (TextView)findViewById(R.id.introduceproduct);
        nameproduct = (TextView)findViewById(R.id.nameproduct);
        spinner= (Spinner)findViewById(R.id.spiner);
    }
   private void getSanPhamDrink()
   {
       int iddrink = 0;
       String TenChiTietDrink ="";
       String GiaDrink ="";
       String motaDrink = "";
       Drink drink = (Drink) getIntent().getSerializableExtra("thongtindrink");
//       iddrink = drink.getId();
       TenChiTietDrink=drink.getTitle1();
       GiaDrink= drink.getPrice();
       motaDrink = drink.getMota();
       priceprocut.setText(GiaDrink);
       introduceproduct.setText(motaDrink);
       nameproduct.setText(TenChiTietDrink);

   }
//    private void getSanPhamFood()
//    {
//        int idfood = 0;
//        String TenChiTietFood ="";
//        String GiaFood ="";
//        String motaFood = "";
//        int IDsanphamfood=0;
//        Food food = (Food) getIntent().getSerializableExtra("thongtinfood");
//        idfood= food.getId();
//        TenChiTietFood=food.getTitle();
//        GiaFood= food.getPrice();
//        motaFood = food.getMota();
//        IDsanphamfood = food.getId();
//        priceprocut.setText(GiaFood);
//        introduceproduct.setText(motaFood);
//        nameproduct.setText(TenChiTietFood);
//    }
   private void Catchspiner()
   {
       Integer[] soluong = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
       ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,soluong);
       spinner.setAdapter(arrayAdapter);
   }
}
