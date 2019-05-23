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

public class FoodAdapter extends ArrayAdapter<Food> {
    Context context;
    int layoutResourceId;
    ArrayList<Food> data = null;

    public FoodAdapter(Context context, int layoutResourceId, ArrayList<Food> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    static class FoodHolder{
        ImageView imgIcon;
        TextView txtTitle;
        TextView txtMoTa;
        TextView txtPrice;
        TextView txtID;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        FoodHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();

            row = inflater.inflate(layoutResourceId,parent,false);

            holder = new FoodHolder();
            //holder.imgIcon = (ImageView)row.findViewById(R.id.imgFoodIcon);
            holder.txtID = (TextView)row.findViewById(R.id.id_item);
            holder.txtTitle = (TextView)row.findViewById(R.id.txtFoodTitle);
            holder.txtMoTa = (TextView)row.findViewById(R.id.txtFoodMoTa);
            holder.txtPrice = (TextView)row.findViewById(R.id.txtFoodPrice);

            row.setTag(holder);
        }
        else
        {
            holder = (FoodHolder) row.getTag();
        }

        Food item = data.get(position);
        holder.txtID.setText(String.valueOf(item.getId()));
        holder.txtTitle.setText(item.getTitle());
       // holder.imgIcon.setImageResource(item.getIcon());
        holder.txtMoTa.setText(item.getMota());
        holder.txtPrice.setText(item.getPrice());


        return row;
    }
}
