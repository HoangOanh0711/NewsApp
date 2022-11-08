package com.example.newsapp.Card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;

import java.util.ArrayList;

public class CardXuHuong_Adapter extends RecyclerView.Adapter<CardXuHuong_Adapter.ViewHolder> {
    private ArrayList<XuHuongModel> xuHuongModelArrayList;
    private ClickItem1 clickItem;

    public CardXuHuong_Adapter(ArrayList<XuHuongModel> xuHuongModelArrayList, ClickItem1 clickItem1) {
        this.xuHuongModelArrayList = xuHuongModelArrayList;
        this.clickItem = clickItem1;
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
        Glide.with(holder.img_vid).load(xuHuongModel.getAnhbao()).into(holder.img_vid);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickItem.onClickItem(xuHuongModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return xuHuongModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img_vid, img_play;
        TextView txt_tieude, txt_tgiandangbai, txt_tgianvid;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_vid = itemView.findViewById(R.id.img_vid_xuhuong);
            txt_tieude = itemView.findViewById(R.id.txt_tieude_xuhuong);
            txt_tgiandangbai = itemView.findViewById(R.id.txt_tgiandangbai_xuhuong);
            txt_tgianvid = itemView.findViewById(R.id.txt_tgianvd_xuhuong);
            img_play = itemView.findViewById(R.id.img_play_xuhuong);
            cardView = itemView.findViewById(R.id.layout_card_xuhuong);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
