package tdc.edu.vn.test;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DrinkAdapter extends ArrayAdapter<Drink> {
    Context context;
    int layoutResourceId;
    ArrayList<Drink> data = null;

    public DrinkAdapter(Context context, int layoutResourceId, ArrayList<Drink> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    static class DrinkHolder{
        ImageView imgIcon;
        TextView txtTitle;
        TextView txtMoTa;
        TextView txtPrice;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        DrinkHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();

            row = inflater.inflate(layoutResourceId,parent,false);

            holder = new DrinkHolder();
            holder.txtTitle = (TextView)row.findViewById(R.id.txtDrinkTitle);
            holder.txtMoTa = (TextView)row.findViewById(R.id.txtDrinkMoTa);
            holder.txtPrice = (TextView)row.findViewById(R.id.txtDrinkPrice);

            row.setTag(holder);
        } else holder = (DrinkHolder) row.getTag();

        Drink item = data.get(position);
        holder.txtTitle.setText(item.getTitle1());
        holder.txtMoTa.setText(item.getMota());
        holder.txtPrice.setText(item.getPrice());

        return row;
    }
}
