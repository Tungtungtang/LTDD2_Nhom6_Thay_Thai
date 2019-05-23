package tdc.edu.vn.tuan1_trandangkhoa;

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
    ArrayList<PhepTinh> data = null;
    int layoutResource;

    public Adapter(Context context, ArrayList<PhepTinh> data, int layoutResource) {
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
        myViewHolder.tvSoA.setText(data.get(i).getSoA());
        myViewHolder.tvSoB.setText(data.get(i).getSoB());
        myViewHolder.tvPT.setText(data.get(i).getPT());
        myViewHolder.tvKQ.setText(data.get(i).getKQ());
        myViewHolder.imageView.setImageResource(data.get(i).getImage());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvSoA, tvSoB, tvPT, tvKQ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSoA = itemView.findViewById(R.id.tvSoA);
            tvSoB = itemView.findViewById(R.id.tvSoB);
            tvPT = itemView.findViewById(R.id.tvPT);
            tvKQ = itemView.findViewById(R.id.tvKQ);
            imageView = itemView.findViewById(R.id.image1);
        }
    }
}
