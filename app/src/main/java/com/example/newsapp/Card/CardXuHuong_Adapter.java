package com.example.newsapp.Card;

import android.content.Context;
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
import com.example.newsapp.TrangChu.xuhuong;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CardXuHuong_Adapter extends RecyclerView.Adapter<CardXuHuong_Adapter.ViewHolder> {
    private ArrayList<XuHuongModel> xuHuongModelArrayList;
    private xuhuong context_xuhuong;

    public CardXuHuong_Adapter(ArrayList<XuHuongModel> xuHuongModelArrayList, xuhuong context) {
        this.xuHuongModelArrayList = xuHuongModelArrayList;
        this.context_xuhuong = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_xuhuong, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        XuHuongModel xuHuongModel = xuHuongModelArrayList.get(position);
        holder.txt_tieude.setText(xuHuongModel.getTieude());
        holder.txt_tgiandangbai.setText(xuHuongModel.getTgiandangbai());
        holder.txt_tgianvid.setText(xuHuongModel.getTgianvid());

        String sImage = String.valueOf(Picasso.get().load(xuHuongModel.getAnhbao()));
        byte[] bytes = Base64.decode(sImage, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        holder.img_vid.setImageBitmap(bitmap);
        Picasso.get().load(xuHuongModel.getAnhbao()).into(holder.img_vid);

    }

    @Override
    public int getItemCount() {
        return xuHuongModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img_vid, img_play;
        TextView txt_tieude, txt_tgiandangbai, txt_tgianvid;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_vid = itemView.findViewById(R.id.img_vid_xuhuong);
            txt_tieude = itemView.findViewById(R.id.txt_tieude_xuhuong);
            txt_tgiandangbai = itemView.findViewById(R.id.txt_tgiandangbai_xuhuong);
            txt_tgianvid = itemView.findViewById(R.id.txt_tgianvd_xuhuong);
            img_play = itemView.findViewById(R.id.img_play_xuhuong);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
