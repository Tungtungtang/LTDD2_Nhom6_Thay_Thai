package vn.edu.myapplication;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainSenor extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    private Sensor accelerometer;
    private float vibrateThreshold = 0;
    ImageView xingau[] = new ImageView[3];
    ImageView hinh1,hinh2,hinh3;
    ArrayList<xingau> CacXiNgau = new ArrayList<xingau>();
    ArrayList<xingau> CacXiNgauRut = new ArrayList<xingau>();
    Button btnChoi;
    float deltaX = 0;
    float deltaY = 0;
    float deltaZ= 0;
    private  float lastX, lastY, lastZ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        //setEvent();

        setSensor();

    }
    public void setControl()
    {
       xingau[0] = (ImageView)findViewById(R.id.images1);
       xingau[1] = (ImageView)findViewById(R.id.images2);
       xingau[2] = (ImageView)findViewById(R.id.images3);
        hinh1 = (ImageView) findViewById(R.id.images1);
        hinh2 = (ImageView) findViewById(R.id.images2);
        hinh3 = (ImageView) findViewById(R.id.images3);

    }
    public void setEvent()
    {
        btnChoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tao();
                Random ran = new Random();//hàm random dùng xuất ngẫu nhiễn các dữ liệu sẵn có
                //Rút lá 1
                int la1 = ran.nextInt(CacXiNgau.size() - 1);
                CacXiNgauRut.add(CacXiNgau.get(la1));

                //Rút lá 2
                int la2 = ran.nextInt(CacXiNgau.size() - 1);
                CacXiNgauRut.add(CacXiNgau.get(la2));

                //Rút lá 3
                int la3 = ran.nextInt(CacXiNgau.size() - 1);
                CacXiNgauRut.add(CacXiNgau.get(la3));

                xingau XiNgau;
                for( int i = 0 ;i < CacXiNgauRut.size();i++)
                {
                    XiNgau = CacXiNgauRut.get(i);
                    xingau[i].setImageResource(XiNgau.Hinh);
                }
                CacXiNgauRut.clear();
            }
        });
    }
    public void tao()
    {
        //them doi tuong vao arraylist
        CacXiNgau.add(new xingau("Bầu",R.drawable.bau));
        CacXiNgau.add(new xingau("Cua",R.drawable.cua));
        CacXiNgau.add(new xingau("Cá",R.drawable.ca));
        CacXiNgau.add(new xingau("Nai",R.drawable.nai));
        CacXiNgau.add(new xingau("Tôm",R.drawable.tom));
        CacXiNgau.add(new xingau("Gà",R.drawable.ga));

    }



    private void setSensor(){
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)!= null){
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
            vibrateThreshold = accelerometer.getMaximumRange() /5;
        }
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            doiHinh(event);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    public void rut()
    {
        Random ran = new Random();//hàm random dùng xuất ngẫu nhiễn các dữ liệu sẵn có
        //Rút lá 1
        int la1 = ran.nextInt(CacXiNgau.size() - 1);
        CacXiNgauRut.add(CacXiNgau.get(la1));
        CacXiNgau.remove(la1);
        //Rút lá 2
        int la2 = ran.nextInt(CacXiNgau.size() - 1);
        CacXiNgauRut.add(CacXiNgau.get(la2));
        CacXiNgau.remove(la2);
        //Rút lá 3
        int la3 = ran.nextInt(CacXiNgau.size() - 1);
        CacXiNgauRut.add(CacXiNgau.get(la3));
        CacXiNgau.remove(la3);
    }
    public void doiHinh(SensorEvent event){
        deltaX = Math.abs(lastX - event.values[0]);
        deltaY = Math.abs(lastY - event.values[1]);
        deltaZ = Math.abs(lastZ - event.values[2]);
        tao();
        rut();
        xingau XN;
        for( int i = 0 ;i < CacXiNgauRut.size();i++) {
            XN = CacXiNgauRut.get(i);
            if (deltaX > vibrateThreshold) {
                    xingau[0].setImageResource(XN.Hinh);
                    CacXiNgauRut.clear();
                }
                if (deltaY > vibrateThreshold) {
                    xingau[1].setImageResource(XN.Hinh);
                    CacXiNgauRut.clear();
                }
                if (deltaZ > vibrateThreshold) {
                    xingau[2].setImageResource(XN.Hinh);
                    CacXiNgauRut.clear();
                }
                CacXiNgauRut.clear();
            }
        lastX = event.values[0];
        lastY = event.values[1];
        lastZ= event.values[2];
    }
}
