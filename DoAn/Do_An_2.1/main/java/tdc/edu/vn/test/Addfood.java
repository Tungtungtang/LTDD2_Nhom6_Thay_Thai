package tdc.edu.vn.test;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Addfood extends AppCompatActivity {
    Button caccle;
    private ListView listViewFood;
    ArrayList<Food> data = new ArrayList<>();
    FoodAdapter adapter = null;
    Button btnThemFood, capnhatFood, btnthemfile;
    EditText addname, add, addgioithieu, addprice;
    private DatabaseFood dbfood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfood);
        dbfood = new DatabaseFood(this);
        setControl();
        setEvent();
        loadDB();
    }

    public void setControl() {
        caccle = (Button) findViewById(R.id.cance);
        listViewFood = (ListView) findViewById(R.id.listViewFood);
        btnThemFood = (Button) findViewById(R.id.btnAddfood);
        capnhatFood = (Button) findViewById(R.id.btnUpdatefood);
        addname = (EditText) findViewById(R.id.addfoodname);
        addgioithieu = (EditText) findViewById(R.id.addintroduce);
        addprice = (EditText) findViewById(R.id.addprice);
        btnthemfile = (Button) findViewById(R.id.btnAddimg);
    }

    public void setEvent() {



        btnthemfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
                startActivity(intent);

            }
        });
        //capnhatFood.setEnabled(false);
        //click lau
        listViewFood.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Food food = data.get(i);
                addname.setText(food.getTitle());
                addgioithieu.setText(food.getMota());
                addprice.setText(food.getPrice());
                AlertDialog.Builder builder = new AlertDialog.Builder(Addfood.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Thông Báo");
                builder.setMessage("Bạn có muốn xóa không?");
                builder.setIcon(R.drawable.thongbao);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteAccount();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.show();
                return false;
            }
        });

        adapter = new FoodAdapter(this, R.layout.listview_food_item, data);
        listViewFood.setAdapter(adapter);
        btnThemFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDB();
                loadDB();

            }
        });
        listViewFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Food food = data.get(i);
                addname.setText(food.getTitle());
                addgioithieu.setText(food.getMota());
                addprice.setText(food.getPrice());
//                btnThemFood.setEnabled(false);
//                capnhatFood.setEnabled(true);


            }


        });
        capnhatFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Food food = new Food();
                food.setTitle(addname.getText() + "");
                food.setMota(addgioithieu.getText() + "");
                food.setPrice(addprice.getText() + "");
                int result = dbfood.updateFood(food);
                if (result > 0) {
                    data.clear();
                    dbfood.getFood(data);
                    adapter.notifyDataSetChanged();
                }
//                btnThemFood.setEnabled(true);
//                capnhatFood.setEnabled(false);
                addname.setText("");
                addgioithieu.setText("");
                addprice.setText("");


            }
        });

        caccle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Addfood.this, Admin.class);
                startActivity(intent);
            }
        });
    }

    public void saveDB() {
        DatabaseFood dbfood = new DatabaseFood(this);
        Food food = new Food();
        food.setTitle(addname.getText().toString() + "");
        food.setMota(addgioithieu.getText().toString() + "");
        food.setPrice(addprice.getText().toString() + "");
        dbfood.saveFood(food);
    }

    public void loadDB() {
        DatabaseFood db = new DatabaseFood(this);
        data.clear();
        db.getFood(data);
        adapter.notifyDataSetChanged();
    }

    public void deleteAccount() {
        DatabaseFood db = new DatabaseFood(this);
        boolean result = db.deleteFood(addname.getText().toString());
        if (result) {
            data.clear();
            db.getFood(data);
            adapter.notifyDataSetChanged();
            addname.setText("");
            addgioithieu.setText("");
            addprice.setText("");
        } else
            Toast.makeText(this, "Delete fail", Toast.LENGTH_SHORT).show();
    }

}
