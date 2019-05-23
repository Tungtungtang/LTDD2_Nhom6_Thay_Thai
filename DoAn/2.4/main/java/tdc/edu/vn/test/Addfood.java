package tdc.edu.vn.test;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
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
    TextView txtid;
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
        txtid = (TextView)findViewById(R.id.id_add);
        btnthemfile = (Button) findViewById(R.id.btnAddimg);
    }

    public void setEvent() {
        //click lau
        listViewFood.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Food food = data.get(i);
                txtid.setText(String.valueOf(food.getId()));
                addname.setText(food.getTitle());
                addgioithieu.setText(food.getMota());
                addprice.setText(String.valueOf(food.getPrice()));
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
                txtid.setText(String.valueOf(food.getId()));
                addname.setText(food.getTitle());
                addgioithieu.setText(food.getMota());
                addprice.setText(String.valueOf(food.getPrice()));


            }


        });
        capnhatFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Food food = new Food();
                food.setId(Integer.parseInt(String.valueOf(txtid.getText())));
                food.setTitle(addname.getText() + "");
                food.setMota(addgioithieu.getText() + "");
                food.setPrice(Integer.parseInt(addprice.getText() + ""));
                int result = dbfood.updateFood(food);
                if (result > 0) {

                    data.clear();
                    dbfood.getfood(data);
                    adapter.notifyDataSetChanged();
                }
                txtid.setText("");
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
        food.setPrice(Integer.parseInt(addprice.getText().toString() + ""));
        dbfood.saveFood(food);
    }

    public void loadDB() {
        DatabaseFood db = new DatabaseFood(this);
        data.clear();
        db.getfood(data);
        adapter.notifyDataSetChanged();
    }

    public void deleteAccount() {
        DatabaseFood db = new DatabaseFood(this);
        boolean result = db.deleteFood(txtid.getText().toString());
        if (result) {

            data.clear();
            db.getfood(data);
            adapter.notifyDataSetChanged();
            txtid.setText("");
            addname.setText("");
            addgioithieu.setText("");
            addprice.setText("");
            Toast.makeText(this, "Delete food thành công ^_^ ", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "Delete fail", Toast.LENGTH_SHORT).show();
    }



    // hàm hiển thị menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menumenumenu, menu);
        return true;
    }
    // chọn case id
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                Intent intent = new Intent(Addfood.this, Login.class);
                startActivity(intent);
                break;

            case R.id.back:

                AlertDialog.Builder builder = new AlertDialog.Builder(Addfood.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Thông Báo");
                //                gắn icon
                builder.setMessage("Bạn Có Muốn Quay lại không");
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
                        Intent intent = new Intent(Addfood.this, Admin.class);
                        startActivity(intent);
                    }
                });
                builder.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
