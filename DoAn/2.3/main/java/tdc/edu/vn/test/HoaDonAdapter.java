package tdc.edu.vn.test;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HoaDonAdapter extends BaseAdapter {
    Context context;
    ArrayList<HoaDon> data ;

    public HoaDonAdapter(Context context, ArrayList<HoaDon> data) {
        this.context = context;
        this.data = data;
    }
    static class HoaDonHolder{
       public TextView txtTen;
       public TextView txtGia;
        public  TextView txtSL;
        public  Button btntang,btngiam,btngiatri;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
//        View row = convertView;
//        HoaDonAdapter.HoaDonHolder holder = null;
        HoaDonHolder hoaDonHolder= null;

        if (convertView == null) {
            hoaDonHolder= new HoaDonHolder();
//            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.hoadon_item,null);
//            row = inflater.inflate(layoutResourceId,parent,false);
//            holder = new HoaDonAdapter.HoaDonHolder();
            hoaDonHolder.txtTen = (TextView)convertView.findViewById(R.id.txtTen_HD);
            hoaDonHolder.txtGia = (TextView)convertView.findViewById(R.id.txtGia_HD);
            hoaDonHolder.btntang = (Button) convertView.findViewById(R.id.tang);
            hoaDonHolder.btngiam = (Button)convertView.findViewById(R.id.giam);
            hoaDonHolder.btngiatri = (Button)convertView.findViewById(R.id.stt) ;
            convertView.setTag(hoaDonHolder);
        } else hoaDonHolder = (HoaDonHolder) convertView.getTag();

        HoaDon item = (HoaDon)getItem(position);
        hoaDonHolder.txtTen.setText(item.getTen());
        hoaDonHolder.txtGia.setText(item.getGia());
        hoaDonHolder.btngiatri.setText(item.getSoLuong() + "");
        return convertView;
    }

}

