//package tdc.edu.vn.test;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v7.app.AppCompatActivity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//
//public class DrinkActivity extends AppCompatActivity {
//    private ListView listViewDrink;
//    ArrayList<Drink> data = new ArrayList<>();
//    View view;
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setControl();
//        setEvent();
//    }
//
//    public void setControl() {
//        listViewDrink = (ListView) findViewById(R.id.listView2);
//    }
//
//
//    public void setEvent() {
//        khoiTao();
//        DrinkAdapter adapter = new DrinkAdapter(this, R.layout.listview_drink_item, data);
//        listViewDrink.setAdapter(adapter);
//
//    }
//
//    public void khoiTao() {
//
//        data.add(new Drink("Pesi", R.drawable.pepsi, "nuoc giai khat", "50000"));
//        data.add(new Drink("Coca", R.drawable.coca,"nước giải khát","8000"));
//        data.add(new Drink("Nuoc Cam", R.drawable.nuocam,"nước giải khát","10000"));
//        data.add(new Drink("Aquafina", R.drawable.nuocsuoi,"nước giải khát","9000"));
//    }
//}
