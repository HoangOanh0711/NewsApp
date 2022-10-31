package com.example.newsapp.Card;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;
import com.example.newsapp.TinTuc.fg_bongda;
import com.example.newsapp.TinTuc.fg_moi;
import com.example.newsapp.TinTuc.fg_nhipsong;
import com.example.newsapp.TinTuc.fg_phapluat;
import com.example.newsapp.TinTuc.fg_thegioi;
import com.example.newsapp.TinTuc.fg_thoisu;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CardTrangChu_Adapter extends RecyclerView.Adapter<CardTrangChu_Adapter.ViewHolder> {
    private ArrayList<NoiDungModel> noiDungModelArrayList;
    private fg_moi context_fg_moi;
    private fg_bongda context_fg_bongda;
    private fg_thoisu context_fg_thoisu;
    private fg_thegioi context_fg_thegioi;
    private fg_phapluat context_fg_phapluat;
    private fg_nhipsong context_fg_nhipsong;

    public CardTrangChu_Adapter(ArrayList<NoiDungModel> noiDungModelArrayList, fg_moi context) {
        this.noiDungModelArrayList = noiDungModelArrayList;
        this.context_fg_moi = context;
    }

    public CardTrangChu_Adapter(ArrayList<NoiDungModel> noiDungModelArrayList, fg_bongda context) {
        this.noiDungModelArrayList = noiDungModelArrayList;
        this.context_fg_bongda = context;
    }

    public CardTrangChu_Adapter(ArrayList<NoiDungModel> noiDungModelArrayList, fg_thoisu context) {
        this.noiDungModelArrayList = noiDungModelArrayList;
        this.context_fg_thoisu = context;
    }

    public CardTrangChu_Adapter(ArrayList<NoiDungModel> noiDungModelArrayList, fg_thegioi context) {
        this.noiDungModelArrayList = noiDungModelArrayList;
        this.context_fg_thegioi = context;
    }

    public CardTrangChu_Adapter(ArrayList<NoiDungModel> noiDungModelArrayList, fg_phapluat context) {
        this.noiDungModelArrayList = noiDungModelArrayList;
        this.context_fg_phapluat = context;
    }

    public CardTrangChu_Adapter(ArrayList<NoiDungModel> noiDungModelArrayList, fg_nhipsong context) {
        this.noiDungModelArrayList = noiDungModelArrayList;
        this.context_fg_nhipsong = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_trangchu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NoiDungModel noiDungModel = noiDungModelArrayList.get(position);
        holder.txt_thoigian.setText(noiDungModel.getThoigian());
        holder.txt_tieude.setText(noiDungModel.getTieude());

        String sImage = String.valueOf(Picasso.get().load(noiDungModel.getAnhbao()));
        byte[] bytes = Base64.decode(sImage, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        holder.img_anhbao.setImageBitmap(bitmap);
        Picasso.get().load(noiDungModel.getAnhbao()).into(holder.img_anhbao);

    }

    @Override
    public int getItemCount() {
        return noiDungModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img_anhbao, img_tenbao;
        TextView txt_tieude, txt_thoigian;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_anhbao = itemView.findViewById(R.id.img_anhbao_trangchu);
            txt_tieude = itemView.findViewById(R.id.txt_tieude_trangchu);
            txt_thoigian = itemView.findViewById(R.id.txt_tgiandangbai_trangchu);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
