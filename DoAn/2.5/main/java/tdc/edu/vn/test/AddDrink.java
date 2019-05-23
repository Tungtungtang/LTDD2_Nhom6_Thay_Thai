package tdc.edu.vn.test;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.content.res.AppCompatResources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class AddDrink extends AppCompatActivity {

    Button bntAddDrink, cancle, btnUpdateDrink;
    private ListView listViewDrink;
    EditText edtName, edtintrocude, edtprice;
    DrinkAdapter adapter= null;
    ArrayList<Drink> data = new ArrayList<>();
    private DatabaseDrink dbdrink;
    TextView txtiddrink;
    ImageButton imgCamera,imgFolder;
    ImageView imgImageDrink,imagedrink;
    private static final int RQUEST_CODE_CAMERA = 123;
    private static final int RQUEST_CODE_FOLDER = 456;


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
        txtiddrink = (TextView) findViewById(R.id.id_add_drink);
        bntAddDrink = (Button) findViewById(R.id.btnAddDrink);
        cancle = (Button) findViewById(R.id.cancle);
        listViewDrink = (ListView) findViewById(R.id.listViewDrink);
        btnUpdateDrink = (Button) findViewById(R.id.btnUpdateDrink);
        edtName = (EditText) findViewById(R.id.edtname);
        edtintrocude = (EditText) findViewById(R.id.edtintroduce);
        edtprice = (EditText) findViewById(R.id.edtprice);
        imgCamera = (ImageButton) findViewById(R.id.camera);
        imgFolder = (ImageButton) findViewById(R.id.folder);
        imgImageDrink = (ImageView) findViewById(R.id.imagedrink);
        imagedrink = (ImageView) findViewById(R.id.imagedrink);
    }

    public void setEvent() {
      adapter = new DrinkAdapter(this, R.layout.listview_drink_item, data);
        listViewDrink.setAdapter(adapter);
        listViewDrink.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Drink drink =data.get(i);
                txtiddrink.setText(String.valueOf(drink.getId()));
                edtName.setText(drink.getTitle1());
                edtintrocude.setText(drink.getMota());
                edtprice.setText(String.valueOf(drink.getPrice()));
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
                txtiddrink.setText(String.valueOf(drink.getId()));
                edtName.setText(drink.getTitle1());
                edtintrocude.setText(drink.getMota());
                edtprice.setText(String.valueOf(drink.getPrice()));
//                bntAddDrink.setEnabled(false);
//                btnUpdateDrink.setEnabled(true);
            }
        });
        btnUpdateDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drink drink =new Drink();
                drink.setId(Integer.parseInt(String.valueOf(txtiddrink.getText())));
                drink.setTitle1(edtName.getText() + "");
                drink.setMota(edtintrocude.getText() + "");
                drink.setPrice(Integer.parseInt(edtprice.getText() + ""));
                int result = dbdrink.updateDrink(drink);
                if(result > 0)
                {
                    data.clear();
                    dbdrink.getDrink(data);
                    adapter.notifyDataSetChanged();
                }
//                bntAddDrink.setEnabled(true);
//                btnUpdateDrink.setEnabled(false);
                txtiddrink.setText("");
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
        imgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        Intent intentcamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intentcamera,RQUEST_CODE_CAMERA);

            }
        });
        imgFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentfolder = new Intent(Intent.ACTION_PICK);
                intentfolder.setType("image/*");
                startActivityForResult(intentfolder,RQUEST_CODE_FOLDER);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==RQUEST_CODE_CAMERA && resultCode ==RESULT_OK&&data!=null)
        {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgImageDrink.setImageBitmap(bitmap);

        }
        if(requestCode==RQUEST_CODE_FOLDER&&resultCode==RESULT_OK&&data!=null)
        {
            Uri uri = data.getData();
            try{
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imgFolder.setImageBitmap(bitmap);
            }catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }


        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    private void showImagedrink() {

    }
    public void saveDB()
    {
        DatabaseDrink dbDrink = new DatabaseDrink(this);
        Drink drink = new Drink();
        drink.setTitle1(edtName.getText().toString() + "");
        drink.setMota(edtintrocude.getText().toString() + "");
        drink.setPrice(Integer.parseInt(edtprice.getText()+ "" ));
        dbDrink.saveDrink(drink);
        edtName.setText("");
        edtintrocude.setText("");
        edtprice.setText("");
        txtiddrink.setText("");


    }
    public void loadDB() {
        DatabaseDrink db = new DatabaseDrink(this);
        data.clear();
        db.getDrink(data);
        adapter.notifyDataSetChanged();
    }
    public void deleteAccount() {
        DatabaseDrink db= new DatabaseDrink(this);
        boolean result = db.deleteDrink(txtiddrink.getText().toString());
        if (result) {
            data.clear();
            db.getDrink(data);
            adapter.notifyDataSetChanged();
            txtiddrink.setText("");
            edtName.setText("");
            edtintrocude.setText("");
            edtprice.setText("");
            Toast.makeText(this, "Delete drink thành công ^_^ ", Toast.LENGTH_SHORT).show();
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
                Intent intent = new Intent(AddDrink.this, Login.class);
                startActivity(intent);
                break;

            case R.id.back:

                AlertDialog.Builder builder = new AlertDialog.Builder(AddDrink.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
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
                        Intent intent = new Intent(AddDrink.this, Admin.class);
                        startActivity(intent);
                    }
                });
                builder.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}

