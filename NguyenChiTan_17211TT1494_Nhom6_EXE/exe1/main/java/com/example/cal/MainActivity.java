package com.example.cal;

import android.inputmethodservice.Keyboard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtNumber;
    TextView tvResult;
    Button number1;
    Button number2;
    Button number3;
    Button number4;
    Button number5;
    Button number6;
    Button number7;
    Button number8;
    Button number9;
    Button number0;

    Button btnCong;
    Button btnTru;
    Button btnNhan;
    Button btnChia;

    Button btnPoint;
    Button btnResult;
    Button btnClear;
    Button btnClearAll;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Adapter adapter;
    ArrayList<MayTinh> data = new ArrayList<>();
    public ArrayList<String> arrayOperation;
    public ArrayList<Double> arrNumber;
    LinearLayout line;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        setEvent();
        setAdapter();
        recyclerView.setHasFixedSize(true);

    }

    public void setControl() {
        edtNumber = (EditText) findViewById(R.id.edt_input);
        tvResult = (TextView) findViewById(R.id.tv_resutl);

        number1 = (Button) findViewById(R.id.btnso1);
        number2 = (Button) findViewById(R.id.btnso2);
        number3 = (Button) findViewById(R.id.btnso3);
        number4 = (Button) findViewById(R.id.btnso4);
        number5 = (Button) findViewById(R.id.btnso5);
        number6 = (Button) findViewById(R.id.btnso6);
        number7 = (Button) findViewById(R.id.btnso7);
        number8 = (Button) findViewById(R.id.btnso8);
        number9 = (Button) findViewById(R.id.btnso9);
        number0 = (Button) findViewById(R.id.btnso0);

        btnCong = (Button) findViewById(R.id.btnCong);
        btnTru = (Button) findViewById(R.id.btnTru);
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnChia = (Button) findViewById(R.id.btnChia);

        btnPoint = (Button) findViewById(R.id.btnPoint);
        btnResult = (Button) findViewById(R.id.btnBang);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnClearAll = (Button) findViewById(R.id.btnClearAll);
        recyclerView = (RecyclerView) findViewById(R.id.recylerview);//RecyclerView moi hoc ak cai nay truoc la ListView,uk no la cai tien cua listview, co the no co ham khac, chu k co them class gi ca ListView tu sinh
        final String TAG = getClass().getSimpleName();
    }

    public void setEvent() {

        number1.setOnClickListener(this);
        number2.setOnClickListener(this);
        number3.setOnClickListener(this);
        number4.setOnClickListener(this);
        number5.setOnClickListener(this);
        number6.setOnClickListener(this);
        number7.setOnClickListener(this);
        number8.setOnClickListener(this);
        number9.setOnClickListener(this);
        number0.setOnClickListener(this);

        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);

        btnPoint.setOnClickListener(this);
        //btnResult.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnClearAll.setOnClickListener(this);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MayTinh mt = new MayTinh();
                double result = 0;
                addOperation(edtNumber.getText().toString());
                addNumber(edtNumber.getText().toString());
                if (arrayOperation.size() >= arrNumber.size()) {
                    tvResult.setText("ERRO");
                } else {

                    for (int i = 0; i < (arrNumber.size() - 1); i++) {
                        switch (arrayOperation.get(i)) {
                            case "+":
                                if (i == 0) {
                                    result = arrNumber.get(i) + arrNumber.get(i + 1);
                                } else {
                                    result = result + arrNumber.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    result = arrNumber.get(i) - arrNumber.get(i + 1);
                                } else {
                                    result = result - arrNumber.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0) {
                                    result = arrNumber.get(i) * arrNumber.get(i + 1);
                                } else {
                                    result = result * arrNumber.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0) {
                                    result = arrNumber.get(i) / arrNumber.get(i + 1);
                                } else {
                                    result = result / arrNumber.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }
                tvResult.setText(result + "" );
                mt.setKq(edtNumber.getText().toString() + "=" + result);
                data.add(mt);
                adapter.notifyDataSetChanged();

            }
        });



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnso0:
                edtNumber.append("0");
                break;
            case R.id.btnso1:
                edtNumber.append("1");
                break;
            case R.id.btnso2:
                edtNumber.append("2");
                break;
            case R.id.btnso3:
                edtNumber.append("3");
                break;
            case R.id.btnso4:
                edtNumber.append("4");
                break;
            case R.id.btnso5:
                edtNumber.append("5");
                break;
            case R.id.btnso6:
                edtNumber.append("6");
                break;
            case R.id.btnso7:
                edtNumber.append("7");
                break;
            case R.id.btnso8:
                edtNumber.append("8");
                break;
            case R.id.btnso9:
                edtNumber.append("9");
                break;

            case R.id.btnCong:
                edtNumber.append("+");
                break;
            case R.id.btnTru:
                edtNumber.append("-");
                break;
            case R.id.btnChia:
                edtNumber.append("/");
                break;
            case R.id.btnNhan:
                edtNumber.append("*");
                break;
            case R.id.btnPoint:
                edtNumber.append(".");
                break;
            case R.id.btnClearAll:
                edtNumber.setText("");
                break;
            case R.id.btnClear:
                BaseInputConnection textField = new BaseInputConnection(edtNumber, true);
                textField.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
        }
    }


    public String deleteNumber(String number) {
        int lenght = number.length();
        String tem = number.substring(0, lenght - 1);

        return tem;
    }



    public int addOperation(String input) {
        arrayOperation = new ArrayList<>();
        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    arrayOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrayOperation.add(cArray[i] + "");
                    break;
                case '*':
                    arrayOperation.add(cArray[i] + "");
                    break;
                case '/':
                    arrayOperation.add(cArray[i] + "");
                    break;

                default:

                    break;
            }
        }
        return 0;
    }

    public void addNumber(String stringInput) {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while (matcher.find()) {
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }

    public void setAdapter(){
        recyclerView = findViewById(R.id.recylerview);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(this,data,R.layout.listview_item);
        recyclerView.setAdapter(adapter);
    }


}
