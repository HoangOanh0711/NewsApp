package com.example.newsapp.LichVanNien;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;

public class lichvannienViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public final TextView dayOfMonth;
    private final lichvannienAdapter.OnItemListener onItemListener;
    public lichvannienViewHolder(@NonNull View itemView, lichvannienAdapter.OnItemListener onItemListener)
    {
        super(itemView);
        dayOfMonth = itemView.findViewById(R.id.cellDayText);
        this.onItemListener = onItemListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        onItemListener.onItemClick(getAdapterPosition(), (String) dayOfMonth.getText());
    }
}
