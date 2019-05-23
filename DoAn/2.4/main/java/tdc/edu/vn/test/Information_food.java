package tdc.edu.vn.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Information_food extends AppCompatActivity {
    TextView name,price,gioithieu;
    Spinner spinner;
    Button btnAddFood;
    int idfood = 0;
    String TenChiTietFood ="";
    int GiaFood =0;
    String motaFood = "";
    int IDsanphamfood=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_food);
        setControl();
        Catchspiner();
        setEvent();
        getSanPhamFood();
    }
    public void setEvent()
    {
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Information_food.this,idfood + "", Toast.LENGTH_SHORT).show();
            }
        });
        btnAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.manggiohang.size()> 0)
                {
                    int sl = Integer.parseInt(spinner.getSelectedItem().toString());
                    boolean exits = false;
                    for(int i= 0;i < MainActivity.manggiohang.size(); i++)
                    {
                        if(MainActivity.manggiohang.get(i).getId_hoadon()== idfood)
                        {
                            MainActivity.manggiohang.get(i).setSoLuong(MainActivity.manggiohang.get(i).getSoLuong() + sl);
                            if(MainActivity.manggiohang.get(i).getSoLuong() >= 10)
                            {
                                MainActivity.manggiohang.get(i).setSoLuong(10);
                            }
                            MainActivity.manggiohang.get(i).setGia(GiaFood* MainActivity.manggiohang.get(i).getSoLuong());
                            exits = true;
                        }
                    }
                    if (exits  == false ){
                        int soluong =Integer.parseInt( spinner.getSelectedItem().toString());
                        int giamoi =soluong * GiaFood;
                        MainActivity.manggiohang.add(new HoaDon(idfood,TenChiTietFood,giamoi,soluong));
                    }
                }
                else
                {
                    int soluong =Integer.parseInt( spinner.getSelectedItem().toString());
                    int giamoi =soluong * GiaFood;
                    MainActivity.manggiohang.add(new HoaDon(idfood,TenChiTietFood,giamoi,soluong));

                }

                Intent intent = new Intent(Information_food.this, DonHang.class);
                startActivity(intent);
            }
        });
    }
    public void setControl()
    {
        spinner = (Spinner)findViewById(R.id.spiner1);
        name = (TextView)findViewById(R.id.nameproductfood);
        price= (TextView)findViewById(R.id.priceproductfood);
        gioithieu= (TextView)findViewById(R.id.introduceproductfood);
        btnAddFood = (Button)findViewById(R.id.btnAddProductFood);
    }
    private void getSanPhamFood()
    {
        Food food = (Food) getIntent().getSerializableExtra("thongtinfood");
        idfood= food.getId();
        TenChiTietFood=food.getTitle();
        GiaFood= food.getPrice();
        motaFood = food.getMota();
        IDsanphamfood = food.getId();
        name.setText(TenChiTietFood);
        DecimalFormat decimalFormat =new DecimalFormat("###,###,###");
        price.setText(decimalFormat.format(GiaFood) + "Đ");
        gioithieu.setText(motaFood);
    }
    private void Catchspiner()
    {
        Integer[] soluong = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,soluong);
        spinner.setAdapter(arrayAdapter);
    }
//    public void saveDB() {
//        Intent intent =new Intent(this,Information_food.class);
//        int id_ban =intent.getIntExtra("ban1",0);
//        DatabaseDonHang dbDH = new DatabaseDonHang(this);
//        HoaDon hd = new HoaDon();
//        hd.setId_ban(id_ban);
//        hd.setTen(name.getText().toString() + "");
//        hd.setGia(price.getText().toString() + "");
//        hd.setSoLuong(spinner + "");
//        dbDH.saveHoaDon(hd);
//    }
}
