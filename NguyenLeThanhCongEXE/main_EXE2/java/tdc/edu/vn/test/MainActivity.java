package tdc.edu.vn.test;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    private Sensor accelerometer;
    private float vibrateThreshold=0;
    LinearLayout view;
    ImageView imgHinh;
    private float lastX,lastY,lastZ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void setSensor(){
        sensorManager =(SensorManager) getSystemService(SENSOR_SERVICE);
        if(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)!=null){
            accelerometer=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
            vibrateThreshold=accelerometer.getMaximumRange()/2;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            doiHinh(event);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void doiHinh(SensorEvent event){
        float deltaX=Math.abs(lastX-event.values[0]);
        float deltaY=Math.abs(lastY-event.values[1]);
        float deltaZ=Math.abs(lastZ-event.values[2]);
        if(deltaX>vibrateThreshold){
            imgHinh.setImageResource(R.drawable.ic_panorama_fish_eye_black_24dp);
            view.setBackgroundColor(Color.RED);
        }
        if(deltaY>vibrateThreshold){
            imgHinh.setImageResource(R.drawable.ic_panorama_horizontal_black_24dp);
            view.setBackgroundColor(Color.YELLOW);
        }
        if(deltaZ>vibrateThreshold){
            imgHinh.setImageResource(R.drawable.ic_panorama_vertical_black_24dp);
            view.setBackgroundColor(Color.BLUE);
        }
        lastX=event.values[0];
        lastY=event.values[1];
        lastZ=event.values[2];
    }
}
