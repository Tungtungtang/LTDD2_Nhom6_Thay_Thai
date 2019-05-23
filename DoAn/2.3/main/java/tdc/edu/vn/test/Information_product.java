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

public class Information_product extends AppCompatActivity {
TextView priceprocut,nameproduct,introduceproduct;
Spinner spinner;
Button btnAddDrink;
    int iddrink = 0;
    String TenChiTietDrink ="";
    String GiaDrink ="";
    String motaDrink = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_product);
        setControl();
        getSanPhamDrink();
        Catchspiner();
        setEvent();
    }
    public void setEvent()
    {
        btnAddDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.manggiohang.size()> 0)
                {
                    int sl = Integer.parseInt(spinner.getSelectedItem().toString());
                    boolean exits = false;
                    for(int i= 0;i < MainActivity.manggiohang.size(); i++)
                    {
                        if(MainActivity.manggiohang.get(i).getId_hoadon()== iddrink)
                        {
                            MainActivity.manggiohang.get(i).setSoLuong(MainActivity.manggiohang.get(i).getSoLuong() + sl);
                            if(MainActivity.manggiohang.get(i).getSoLuong() >= 10)
                            {
                                MainActivity.manggiohang.get(i).setSoLuong(10);

                            }
                            exits = true;
                        }
                    }
                    if (exits  == false ){
                        int soluong =Integer.parseInt( spinner.getSelectedItem().toString());
                        MainActivity.manggiohang.add(new HoaDon(iddrink,TenChiTietDrink,GiaDrink,soluong));
                    }
                }
                else
                {
                    int soluong =Integer.parseInt( spinner.getSelectedItem().toString());
                    MainActivity.manggiohang.add(new HoaDon(iddrink,TenChiTietDrink,GiaDrink,soluong));

                }

                Intent intent = new Intent(Information_product.this, DonHang.class);
                startActivity(intent);
            }
        });
    }
    public void setControl()
    {
        priceprocut =(TextView)findViewById(R.id.priceproduct);
        introduceproduct = (TextView)findViewById(R.id.introduceproduct);
        nameproduct = (TextView)findViewById(R.id.nameproduct);
        spinner= (Spinner)findViewById(R.id.spiner);
        btnAddDrink =(Button)findViewById(R.id.btnAddProduct);
    }

   private void getSanPhamDrink()
   {

       Drink drink = (Drink) getIntent().getSerializableExtra("thongtindrink");
       TenChiTietDrink=drink.getTitle1();
       iddrink =drink.getId();
       GiaDrink= drink.getPrice();
       motaDrink = drink.getMota();
       priceprocut.setText(GiaDrink);
       introduceproduct.setText(motaDrink);
       nameproduct.setText(TenChiTietDrink);
   }

   private void Catchspiner()
   {
       Integer[] soluong = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
       ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,soluong);
       spinner.setAdapter(arrayAdapter);
   }
}
