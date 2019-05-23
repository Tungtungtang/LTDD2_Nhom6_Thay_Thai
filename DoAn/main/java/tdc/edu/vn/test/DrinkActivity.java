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

public class DrinkActivity extends Fragment {
    private ListView listViewDrink;
    ArrayList<Drink> data = new ArrayList<>();
    View view;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.drink, container, false);
        listViewDrink = (ListView) view.findViewById(R.id.listViewDrink);
        setEvent();
        return view;
    }



    public void setEvent() {
        khoiTao();
        DrinkAdapter adapter = new DrinkAdapter(getActivity(), R.layout.listview_drink_item, data);
        listViewDrink.setAdapter(adapter);

        listViewDrink.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass( getActivity(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);

            }
        });
    }

    public void khoiTao() {

          data.add(new Drink("Pesi",R.drawable.pepsi,"nuoc giai khat","50000" ));
//        data.add(new Drink("Coca",R.drawable.coca));
//        data.add(new Drink("Nuoc Cam",R.drawable.nuocam));
//        data.add(new Drink("Aquafina",R.drawable.nuocsuoi));
//        data.add(new Drink("E",R.drawable.ic_launcher_background));
    }
}
