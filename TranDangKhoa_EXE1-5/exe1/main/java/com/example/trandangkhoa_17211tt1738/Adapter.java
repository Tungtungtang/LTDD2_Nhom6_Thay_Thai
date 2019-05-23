package com.example.trandangkhoa_17211tt1738;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    Context context;
    ArrayList<HinhAnh> data = null;
    int layoutResource;

    public Adapter(Context context, ArrayList<HinhAnh> data, int layoutResource) {
        this.context = context;
        this.data = data;
        this.layoutResource = layoutResource;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View row = inflater.inflate(layoutResource, viewGroup , false);
        return  new MyViewHolder(row);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.imageView1.setImageResource(data.get(i).getDau());
        myViewHolder.imageView2.setImageResource(data.get(i).getThan());
        myViewHolder.imageView3.setImageResource(data.get(i).getChan());

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView1,imageView2,imageView3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView1 = itemView.findViewById(R.id.lsimage1);
            imageView2 = itemView.findViewById(R.id.lsimage2);
            imageView3 = itemView.findViewById(R.id.lsimage3);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
