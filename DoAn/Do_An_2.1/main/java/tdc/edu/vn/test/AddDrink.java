package tdc.edu.vn.test;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddDrink extends AppCompatActivity {
    Button bntAddDrink, cancle, btnUpdateDrink;
    private ListView listViewDrink;
    EditText edtName, edtintrocude, edtprice;
    DrinkAdapter adapter= null;
    ArrayList<Drink> data = new ArrayList<>();
    private DatabaseDrink dbdrink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drink);
        dbdrink = new DatabaseDrink(this);
        setControl();
        setEvent();
        loadDB();
    }

    public void setControl() {
        bntAddDrink = (Button) findViewById(R.id.btnAddDrink);
        cancle = (Button) findViewById(R.id.cancle);
        listViewDrink = (ListView) findViewById(R.id.listViewDrink);
        btnUpdateDrink = (Button) findViewById(R.id.btnUpdateDrink);
        edtName = (EditText) findViewById(R.id.edtname);
        edtintrocude = (EditText) findViewById(R.id.edtintroduce);
        edtprice = (EditText) findViewById(R.id.edtprice);
    }

    public void setEvent() {
      adapter = new DrinkAdapter(this, R.layout.listview_drink_item, data);
        listViewDrink.setAdapter(adapter);
        listViewDrink.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Drink drink =data.get(i);
                edtName.setText(drink.getTitle1());
                edtintrocude.setText(drink.getMota());
                edtprice.setText(drink.getPrice());
                AlertDialog.Builder builder = new AlertDialog.Builder(AddDrink.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
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
        listViewDrink.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Drink drink =data.get(i);
                edtName.setText(drink.getTitle1());
                edtintrocude.setText(drink.getMota());
                edtprice.setText(drink.getPrice());
//                bntAddDrink.setEnabled(false);
//                btnUpdateDrink.setEnabled(true);
            }
        });
        btnUpdateDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drink drink =new Drink();
                drink.setTitle1(edtName.getText() + "");
                drink.setMota(edtintrocude.getText() + "");
                drink.setPrice(edtprice.getText() + "");
                int result = dbdrink.updateDrink(drink);
                if(result > 0)
                {
                    data.clear();
                    dbdrink.getDrink(data);
                    adapter.notifyDataSetChanged();
                }
//                bntAddDrink.setEnabled(true);
//                btnUpdateDrink.setEnabled(false);
                edtName.setText("");
                edtintrocude.setText("");
                edtprice.setText("");
            }
        });
        bntAddDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDB();
                loadDB();
            }
        });
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddDrink.this, Admin.class);
                startActivity(intent);
            }
        });
    }
    public void saveDB()
    {
        DatabaseDrink dbDrink = new DatabaseDrink(this);
        Drink drink = new Drink();
        drink.setTitle1(edtName.getText().toString() + "");
        drink.setMota(edtintrocude.getText().toString() + "");
        drink.setPrice(edtprice.getText().toString() + "");
        dbDrink.saveDrink(drink);
    }
    public void loadDB() {
        DatabaseDrink db = new DatabaseDrink(this);
        data.clear();
        db.getDrink(data);
        adapter.notifyDataSetChanged();
    }
    public void deleteAccount() {
        DatabaseDrink db= new DatabaseDrink(this);
        boolean result = db.deleteDrink(edtName.getText().toString());
        if (result) {
            data.clear();
            db.getDrink(data);
            adapter.notifyDataSetChanged();
            edtName.setText("");
            edtintrocude.setText("");
            edtprice.setText("");
        } else
            Toast.makeText(this, "Delete fail", Toast.LENGTH_SHORT).show();
    }
}

