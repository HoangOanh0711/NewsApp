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

public class Thoitiet2_Adapter extends RecyclerView.Adapter<Thoitiet2_Adapter.Thoitiet2ViewHolder>{
    private List<Thoitiet2> mthoitiet2;
    private Context context;

    public Thoitiet2_Adapter(Context context) {
        this.context = context;
    }

    public void setMthoitiet2(List<Thoitiet2> mthoitiet2) {
        this.mthoitiet2 = mthoitiet2;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Thoitiet2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_thoitiet_ngang,parent,false);
        return new Thoitiet2ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Thoitiet2ViewHolder holder, int position) {
        Thoitiet2 thoitiet2 = mthoitiet2.get(position);
        if (thoitiet2 == null) {
            return;
        }

        holder.imgAnh2.setImageResource(thoitiet2.getAnh2());
        holder.txtthoigian2.setText(thoitiet2.getThoigian2());
        holder.txtnhietdo2.setText(thoitiet2.getNhietdo2());
        holder.txttinhtrang2.setText(thoitiet2.getTinhtrang2());
    }

    @Override
    public int getItemCount() {
        if (mthoitiet2 != null) {
            return mthoitiet2.size();
        }
        return 0;
    }

    public class Thoitiet2ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgAnh2;
        private TextView txtthoigian2, txtnhietdo2, txttinhtrang2;

        public Thoitiet2ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAnh2 = itemView.findViewById(R.id.img_thoitiet_card2);
            txtthoigian2 = itemView.findViewById(R.id.txt_thoigian_card2);
            txtnhietdo2 = itemView.findViewById(R.id.txt_nhietdo_card2);
            txttinhtrang2 = itemView.findViewById(R.id.txt_tinhtrang_card2);

        }
    }
}
