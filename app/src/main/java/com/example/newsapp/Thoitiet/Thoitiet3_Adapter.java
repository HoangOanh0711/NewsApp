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

public class Thoitiet3_Adapter extends RecyclerView.Adapter<Thoitiet3_Adapter.Thoitiet3ViewHolder>{
    private List<Thoitiet3> mthoitiet3;
    private Context context;

    public Thoitiet3_Adapter(Context context) {
        this.context = context;
    }

    public void setMthoitiet3(List<Thoitiet3> mthoitiet3) {
        this.mthoitiet3 = mthoitiet3;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Thoitiet3ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_thoitiet_thanhpho,parent,false);
        return new Thoitiet3ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Thoitiet3ViewHolder holder, int position) {
        Thoitiet3 thoitiet3 = mthoitiet3.get(position);
        if (thoitiet3 == null) {
            return;
        }

        holder.imgThoitiet3.setImageResource(thoitiet3.getThoitiet3());
        holder.imgghim.setImageResource(thoitiet3.getGhim());
        holder.txt_tp.setText(thoitiet3.getThanhpho());
        holder.txt_tinhtrang3.setText(thoitiet3.getTinhtrang3());
        holder.txt_nhietdo3.setText(thoitiet3.getNhietdo3());
    }

    @Override
    public int getItemCount() {
        if (mthoitiet3 != null) {
            return mthoitiet3.size();
        }
        return 0;
    }

    public class Thoitiet3ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgThoitiet3, imgghim;
        private TextView txt_tp, txt_tinhtrang3, txt_nhietdo3;

        public Thoitiet3ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgThoitiet3 = itemView.findViewById(R.id.img_thoitiet_thoitiettp);
            imgghim = itemView.findViewById(R.id.img_ghim_thoitiettp);
            txt_tp = itemView.findViewById(R.id.txt_thanhpho_thoitiettp);
            txt_tinhtrang3 = itemView.findViewById(R.id.txt_tinhtrang_thoitiettp);
            txt_nhietdo3 = itemView.findViewById(R.id.txt_nhietdo_thoitiettp);

        }
    }
}
