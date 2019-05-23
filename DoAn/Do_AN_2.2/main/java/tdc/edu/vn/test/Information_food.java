package tdc.edu.vn.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Information_food extends AppCompatActivity {
    TextView name,price,gioithieu;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_food);
        setControl();
        Catchspiner();
    }
    public void setControl()
    {
        spinner = (Spinner)findViewById(R.id.spiner1);
        name = (TextView)findViewById(R.id.nameproductfood);
        price= (TextView)findViewById(R.id.priceproductfood);
        gioithieu= (TextView)findViewById(R.id.introduceproductfood);
    }
    private void getSanPhamFood()
    {
        int idfood = 0;
        String TenChiTietFood ="";
        String GiaFood ="";
        String motaFood = "";
        int IDsanphamfood=0;
        Food food = (Food) getIntent().getSerializableExtra("thongtinfood");
        idfood= food.getId();
        TenChiTietFood=food.getTitle();
        GiaFood= food.getPrice();
        motaFood = food.getMota();
        IDsanphamfood = food.getId();
        name.setText(GiaFood);
        price.setText(motaFood);
        gioithieu.setText(TenChiTietFood);
    }
    private void Catchspiner()
    {
        Integer[] soluong = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,soluong);
        spinner.setAdapter(arrayAdapter);
    }
}
