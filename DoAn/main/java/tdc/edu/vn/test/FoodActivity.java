package tdc.edu.vn.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodActivity extends Fragment {
    private ListView listViewFood;
    ArrayList<Food> data = new ArrayList<>();
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.food, container, false);
        listViewFood = (ListView)view.findViewById(R.id.listViewFood);
        setEvent();
        return view;
    }


    public void setEvent() {
        khoiTao();
        FoodAdapter adapter = new FoodAdapter(getActivity(), R.layout.listview_food_item, data);
        listViewFood.setAdapter(adapter);

        listViewFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
    }

    public void khoiTao() {
        data.add(new Food("Pho Ha Noi",R.drawable.pho,"pho ha noi","30000"));
//        data.add(new Food("Bun Bo",R.drawable.bunbo));
//        data.add(new Food("Mi quang",R.drawable.miquang));
//        data.add(new Food("Hu Tieu",R.drawable.hutieu));
//        data.add(new Food("E",R.drawable.ic_launcher_background));
    }
}
