package com.example.newsapp.Thoitiet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;

import java.util.List;

public class Thoitiet1_Adapter extends RecyclerView.Adapter<Thoitiet1_Adapter.Thoitiet1ViewHolder>{
    private List<Thoitiet1> mthoitiet1;
    private Context context;

    public Thoitiet1_Adapter(Context context) {
        this.context = context;
    }

    public void setMthoitiet1(List<Thoitiet1> mthoitiet1) {
        this.mthoitiet1 = mthoitiet1;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Thoitiet1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_thoitiet_doc,parent,false);
        return new Thoitiet1ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Thoitiet1ViewHolder holder, int position) {
        Thoitiet1 thoitiet1 = mthoitiet1.get(position);
        if (thoitiet1 == null) {
            return;
        }

        holder.imgAnh1.setImageResource(thoitiet1.getAnh1());
        holder.txtthoigian1.setText(thoitiet1.getGio1());
        holder.txtnhietdo1.setText(thoitiet1.getNhietdo1());
    }

    @Override
    public int getItemCount() {
        if (mthoitiet1 != null) {
            return mthoitiet1.size();
        }
        return 0;
    }

    public class Thoitiet1ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgAnh1;
        private TextView txtthoigian1, txtnhietdo1;

        public Thoitiet1ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAnh1 = itemView.findViewById(R.id.img_thoitiet_card1);
            txtthoigian1 = itemView.findViewById(R.id.txt_thoigian_card1);
            txtnhietdo1 = itemView.findViewById(R.id.txt_nhietdo_card1);

        }
    }
}
