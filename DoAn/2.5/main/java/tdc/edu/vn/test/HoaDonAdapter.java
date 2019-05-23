package tdc.edu.vn.test;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
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

    public View getView(final int position, View convertView, ViewGroup parent) {
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

        final HoaDon item = (HoaDon)getItem(position);
        hoaDonHolder.txtTen.setText(item.getTen());
        DecimalFormat decimalFormat =new DecimalFormat("###,###,###");
        hoaDonHolder.txtGia.setText(decimalFormat.format(item.getGia())+ "Đ");
        hoaDonHolder.btngiatri.setText(item.getSoLuong() + "");






        int soluong  = Integer.parseInt(hoaDonHolder.btngiatri.getText().toString());
        if (soluong >= 10)
        {
            hoaDonHolder.btntang.setVisibility(View.INVISIBLE);
            hoaDonHolder.btngiam.setVisibility(View.VISIBLE);
        }
        else
            if(soluong <= 1)
            {
                hoaDonHolder.btngiam.setVisibility(View.INVISIBLE);
            }
            else
                if (soluong >= 1)
                {
                    hoaDonHolder.btngiam.setVisibility(View.VISIBLE);
                    hoaDonHolder.btntang.setVisibility(View.VISIBLE);
                }
        final HoaDonHolder finalHoaDonHolder = hoaDonHolder;
        final HoaDonHolder finalHoaDonHolder1 = hoaDonHolder;
        final HoaDonHolder finalHoaDonHolder2 = hoaDonHolder;
        hoaDonHolder.btntang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int slmoinhat = Integer.parseInt(finalHoaDonHolder.btngiatri.getText().toString()) + 1;
                int slhientai = MainActivity.manggiohang.get(position).getSoLuong();
                int giahientai = MainActivity.manggiohang.get(position).getGia();
                MainActivity.manggiohang.get(position).setSoLuong(slmoinhat);
                int giamoinhat = (giahientai * slmoinhat) / slhientai;
                MainActivity.manggiohang.get(position).setGia(giamoinhat);
                finalHoaDonHolder1.txtGia.setText(giamoinhat + "D");
                DonHang.TinhTien();
                if (slmoinhat > 9)
                {
                    finalHoaDonHolder2.btntang.setVisibility(View.INVISIBLE);
                    finalHoaDonHolder2.btngiam.setVisibility(View.VISIBLE);
                    finalHoaDonHolder.btngiatri.setText(String.valueOf(slmoinhat));
                }
                else {
                    finalHoaDonHolder2.btngiam.setVisibility(View.VISIBLE);
                    finalHoaDonHolder2.btntang.setVisibility(View.VISIBLE);
                    finalHoaDonHolder.btngiatri.setText(String.valueOf(slmoinhat));
                }
            }
        });
        hoaDonHolder.btngiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int slmoinhat = Integer.parseInt(finalHoaDonHolder.btngiatri.getText().toString()) - 1;
                int slhientai = MainActivity.manggiohang.get(position).getSoLuong();
                int giahientai = MainActivity.manggiohang.get(position).getGia();
                MainActivity.manggiohang.get(position).setSoLuong(slmoinhat);
                int giamoinhat = (giahientai * slmoinhat) / slhientai;
                MainActivity.manggiohang.get(position).setGia(giamoinhat);
                finalHoaDonHolder1.txtGia.setText(giamoinhat + "D");
                DonHang.TinhTien();
                if (slmoinhat < 2 )
                {
                    finalHoaDonHolder2.btngiam.setVisibility(View.INVISIBLE);
                    finalHoaDonHolder2.btntang.setVisibility(View.VISIBLE );
                    finalHoaDonHolder.btngiatri.setText(String.valueOf(slmoinhat));
                }
                else {
                    finalHoaDonHolder2.btngiam.setVisibility(View.VISIBLE);
                    finalHoaDonHolder2.btntang.setVisibility(View.VISIBLE);
                    finalHoaDonHolder.btngiatri.setText(String.valueOf(slmoinhat));
                }
            }
        });
        return convertView;
    }

}

