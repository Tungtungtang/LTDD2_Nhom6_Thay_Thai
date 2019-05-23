package tdc.edu.vn.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class List_Item extends AppCompatActivity {
    private ListView listViewFood;
    ArrayList<Food> data = new ArrayList<>();
    private DatabaseFood dbfood;
    FoodAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        setControl();
        setEvent();
    }

    public void setControl() {
        listViewFood = (ListView) findViewById(R.id.listViewFood);
    }

    public void setEvent(){
        listViewFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object o = listViewFood.getItemAtPosition(i);
                Food food1 = (Food) o;
                Toast.makeText(getApplication(), "Selected :" + " " + food1, Toast.LENGTH_LONG).show();
            }
        });
    }

}
