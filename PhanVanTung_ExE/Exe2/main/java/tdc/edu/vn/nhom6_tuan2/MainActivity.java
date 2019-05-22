package tdc.edu.vn.nhom6_tuan2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity  implements SensorEventListener {
    SensorManager sensorManager;
    private Sensor accelerometer;
    private float vibrateThreshold = 0;
    Button btnChoi, btnChoiLai;
    ImageView LaBai[] = new ImageView[3];
    TextView kq;
    //danh sách các lá đã rút
    ArrayList<LaBai> CacLaDaRut = new ArrayList<LaBai>();
    //danh sách các lá bài đã thêm vào
    ArrayList<LaBai> CacLaBai = new ArrayList<LaBai>();
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

    public void setControl(){
        LaBai[0] = (ImageView) findViewById(R.id.imageView01);
        LaBai[1] = (ImageView) findViewById(R.id.imageView02);
        LaBai[2] = (ImageView) findViewById(R.id.imageView03);
    }
    public void TaoBai(){
        //Thêm đối tượng LaBai vào arraylist của biến CacLaBai
        CacLaBai.add(new LaBai(1, "Ách", R.drawable.mot));
        CacLaBai.add(new LaBai(2, "Hai", R.drawable.hai));
        CacLaBai.add(new LaBai(3, "Ba", R.drawable.ba));
        CacLaBai.add(new LaBai(4, "Bốn", R.drawable.bon));
        CacLaBai.add(new LaBai(5, "Năm", R.drawable.nam));
        CacLaBai.add(new LaBai(6, "Sáu", R.drawable.sau));
        CacLaBai.add(new LaBai(7, "Bảy", R.drawable.bay));
        CacLaBai.add(new LaBai(8, "Tám", R.drawable.tam));
        CacLaBai.add(new LaBai(9, "Chín", R.drawable.chin));
        CacLaBai.add(new LaBai(10, "Mười", R.drawable.muoi));
        CacLaBai.add(new LaBai(11, "Bồi", R.drawable.boi));
        CacLaBai.add(new LaBai(12, "Đầm", R.drawable.dam));
        CacLaBai.add(new LaBai(13, "Già", R.drawable.gia));
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
        int la1 = ran.nextInt(CacLaBai.size() - 1);
        CacLaDaRut.add(CacLaBai.get(la1));
        CacLaBai.remove(la1);
        //Rút lá 2
        int la2 = ran.nextInt(CacLaBai.size() - 1);
        CacLaDaRut.add(CacLaBai.get(la2));
        CacLaBai.remove(la2);
        //Rút lá 3
        int la3 = ran.nextInt(CacLaBai.size() - 1);
        CacLaDaRut.add(CacLaBai.get(la3));
        CacLaBai.remove(la3);
    }
    public void doiHinh(SensorEvent event)
    {

        deltaX = Math.abs(lastX - event.values[0]);
        deltaY = Math.abs(lastY - event.values[1]);
        deltaZ = Math.abs(lastZ - event.values[2]);
        TaoBai();;
        rut();
        LaBai xetbai;
        for(int i = 0;i < CacLaDaRut.size();i++)
        {
            xetbai = CacLaDaRut.get(i);
            if(deltaX > vibrateThreshold)
            {
                LaBai[0].setImageResource(xetbai.Hinh);
                CacLaDaRut.clear();
            }

            if(deltaY > vibrateThreshold)
            {
                LaBai[1].setImageResource(xetbai.Hinh);
                CacLaDaRut.clear();
            }

            if(deltaZ > vibrateThreshold) {
                LaBai[2].setImageResource(xetbai.Hinh);
                CacLaDaRut.clear();
            }

        }
        lastX = event.values[0];
        lastY = event.values[1];
        lastZ= event.values[2];

    }
}
