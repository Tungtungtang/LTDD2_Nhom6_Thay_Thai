package com.example.trandangkhoa_sensor;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    BluetoothAdapter adapter;
    BluetoothSocket socket;
    BluetoothDevice device;
    private Sensor accelerometer;
    private float vibrateThreshold = 0;
    float ax = 0, ay = 0, az = 0;
    String address;
    boolean stage;
    final Context context = this;
    TextView connection, txtv_view;
    ImageView top, left, right, bot;
    private SensorManager sensorManager;
    private Sensor sensor;
    String data;
    private OutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stage = true;
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        setControl();
        setSensor();


    }

    //    @Override
////    protected void onResume() {
////        super.onResume();
////        sensorManager.registerListener(getApplicationContext(),sensor,SensorManager.SENSOR_DELAY_NORMAL);
////    }
////
////    @Override
////    protected void onPause() {
////        //super.onPause();
////        sensorManager.unregisterListener(this,sensor);
////    }
////
////    @Override
////    protected void onStop() {
////        //super.onStop();
////    }
    private void setControl(){
        txtv_view = (TextView) findViewById(R.id.xyz);

        top = (ImageView) findViewById(R.id.top);
        left = (ImageView) findViewById(R.id.imageView3);
        right = (ImageView) findViewById(R.id.imageView4);
        bot = (ImageView) findViewById(R.id.imageView2);
    }
    private void setSensor() {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_FASTEST);
            vibrateThreshold = accelerometer.getMaximumRange() / 5;
        }
    }




    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            ax = Math.round(event.values[0]);//đọc và làm tròn giá trị trục x
            ay = Math.round(event.values[1]);//đọc và làm tròn giá trị trục y
            az = Math.round(event.values[2]);//đọc và làm tròn giá trị trục z
        }
        if (ax <= -2.0) {
            top.setImageResource(R.drawable.top);
            data = "#1";
        } else if (ax >= 2.0) {
            bot.setImageResource(R.drawable.bot);
            data = "#2";
        } else {
            top.setImageResource(R.drawable.none1);
            bot.setImageResource(R.drawable.none1);
            data = "#3";
        }

        if (ay <= -2.0) {
            left.setImageResource(R.drawable.left);
            data = "#4";
        } else if (ay >= 2.0) {
            right.setImageResource(R.drawable.right);
            data = "#5";
        } else {
            left.setImageResource(R.drawable.none1);
            right.setImageResource(R.drawable.none1);
            data = "#6";
        }

        txtv_view.setText("X: " + String.valueOf(ax) + " Y: " + String.valueOf(ay) + " Z: " + String.valueOf(az));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }



}
