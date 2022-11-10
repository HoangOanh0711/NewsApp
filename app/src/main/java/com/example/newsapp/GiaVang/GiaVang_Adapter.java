package com.example.newsapp.GiaVang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;
import com.example.newsapp.Thoitiet.Thoitiet1;
import com.example.newsapp.Thoitiet.Thoitiet1_Adapter;

import java.util.List;

public class GiaVang_Adapter extends RecyclerView.Adapter<GiaVang_Adapter.GiaVangViewHolder>{

    private List<GiaVangModel> giaVangModels;
    private Context context;

    public GiaVang_Adapter(Context context) {
        this.context = context;
    }

    public void setMgiavang(List<GiaVangModel> mgiavang) {
        this.giaVangModels = mgiavang;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GiaVang_Adapter.GiaVangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_giavang_loai,parent,false);
        return new GiaVang_Adapter.GiaVangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GiaVang_Adapter.GiaVangViewHolder holder, int position) {
        GiaVangModel giaVangModel = giaVangModels.get(position);
        if (giaVangModel == null) {
            return;
        }

        holder.txtgiatienmua.setText(giaVangModel.getGiatienmua());
        holder.txttangmua.setText(giaVangModel.getTangmua());
        holder.txtphantrammua.setText(giaVangModel.getPhantrammua());
        holder.txtgiatienban.setText(giaVangModel.getGiatienban());
        holder.txttangban.setText(giaVangModel.getTangban());
        holder.txtphantramban.setText(giaVangModel.getPhantramban());
    }

    @Override
    public int getItemCount() {
        if (giaVangModels != null) {
            return giaVangModels.size();
        }
        return 0;
    }

    public class GiaVangViewHolder extends RecyclerView.ViewHolder{

        private TextView txtgiatienmua,txttangmua,txtphantrammua,txtgiatienban,txttangban,txtphantramban;

        public GiaVangViewHolder(@NonNull View itemView) {
            super(itemView);

            txtgiatienmua = itemView.findViewById(R.id.txt_giatienmua_cardgiavang);
            txttangmua = itemView.findViewById(R.id.txt_tangmua_cardgiavang);
            txtphantrammua = itemView.findViewById(R.id.txt_phantrammua_cardgiavang);

            txtgiatienban = itemView.findViewById(R.id.txt_giatienban_cardgiavang);
            txttangban = itemView.findViewById(R.id.txt_tangban_cardgiavang);
            txtphantramban = itemView.findViewById(R.id.txt_phantramban_cardgiavang);
        }
    }
}
