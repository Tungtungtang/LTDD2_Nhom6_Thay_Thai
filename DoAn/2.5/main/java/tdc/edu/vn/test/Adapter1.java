package tdc.edu.vn.test;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Adapter1 extends ArrayAdapter<HoaDon> {
    Context context;
    int layoutResourceId;
    ArrayList<HoaDon> data = null;

    public Adapter1(Context context, int layoutResourceId, ArrayList<HoaDon> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }
    static class HoaDon1{
        TextView txtTitle;
        TextView txtPrice;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Adapter1.HoaDon1 holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();

            row = inflater.inflate(layoutResourceId,parent,false);

            holder = new Adapter1.HoaDon1();
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTen_HD1);
            holder.txtPrice = (TextView)row.findViewById(R.id.txtGia_HD1);
            row.setTag(holder);
        } else holder = (Adapter1.HoaDon1) row.getTag();

        HoaDon item = data.get(position);
        holder.txtTitle.setText(item.getTen());
        DecimalFormat decimalFormat =new DecimalFormat("###,###,###");
        holder.txtPrice.setText(decimalFormat.format(item.getGia()));
        return row;
    }

}
