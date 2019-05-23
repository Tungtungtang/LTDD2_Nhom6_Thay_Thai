package com.simplephonedialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnStar;
    Button btnZero;
    Button btnHash;
    Button btnDelete;
    Button btnDial;

    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = findViewById(R.id.buttonOne);
        btnTwo = findViewById(R.id.buttonTwo);
        btnThree = findViewById(R.id.buttonThree);
        btnFour = findViewById(R.id.buttonFour);
        btnFive = findViewById(R.id.buttonFive);
        btnSix = findViewById(R.id.buttonSix);
        btnSeven = findViewById(R.id.buttonSeven);
        btnEight = findViewById(R.id.buttonEight);
        btnNine = findViewById(R.id.buttonNine);
        btnStar = findViewById(R.id.buttonStar);
        btnZero = findViewById(R.id.buttonZero);
        btnHash = findViewById(R.id.buttonHash);
        btnDelete = findViewById(R.id.buttonDelete);
        btnDial = findViewById(R.id.buttonDial);

        input = findViewById(R.id.editText);
    }

    public void one(View v) {
        onButtonClick(btnOne, input, "1");
    }

    public void two(View v) {
        onButtonClick(btnTwo, input, "2");
    }

    public void three(View v) {
        onButtonClick(btnThree, input, "3");
    }

    public void four(View v) {
        onButtonClick(btnFour, input, "4");
    }

    public void five(View v) {
        onButtonClick(btnFive, input, "5");
    }

    public void six(View v) {
        onButtonClick(btnSix, input, "6");
    }

    public void seven(View v) {
        onButtonClick(btnSeven, input, "7");
    }

    public void eight(View v) {
        onButtonClick(btnEight, input, "8");
    }

    public void nine(View v) {
        onButtonClick(btnNine, input, "9");
    }

    public void star(View v) {
        onButtonClick(btnStar, input, "*");
    }

    public void zero(View v) {
        onButtonClick(btnZero, input, "0");
    }

    public void hash(View v) {
        onButtonClick(btnHash, input, "#");
    }


    public void onDelete(View v) {
        input.setText("");
    }

    public void onDial(View v) {
        if (input.getText().length() <= 3) {
            Toast.makeText(this, "Please Enter the Valid Number", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);

            String hash = input.getText().toString();
            if (hash.contains("#")) {
                hash.replace("#", "%23");
            }

            intent.setData(Uri.parse("tel:" + hash));

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                return;
            }else{
                startActivity(intent);
            }

        }
    }

    public void onButtonClick(Button button, EditText inputNumber, String number) {
        String cache = input.getText().toString();
        inputNumber.setText(cache + number);
    }
}
