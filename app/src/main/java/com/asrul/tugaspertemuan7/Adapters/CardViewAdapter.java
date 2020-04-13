package com.asrul.tugaspertemuan7.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.asrul.tugaspertemuan7.Data.Camera;
import com.asrul.tugaspertemuan7.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewViewHolder> {

    private ArrayList<Camera> listData;
    public CardViewAdapter(ArrayList<Camera> list) {
        this.listData = list;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_item, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, final int position) {
        Camera data = listData.get(position);
        Glide.with(holder.itemView.getContext())
                .load(listData.get(position).getPhoto())
                .into(holder.imgItem);
        holder.txtName.setText(data.getName());
        holder.txtPrice.setText(data.getPrice());

        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Favorite " + listData.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + listData.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgItem, btnFavorite;
        TextView txtName, txtPrice;
        CardView cardView;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);

            imgItem = itemView.findViewById(R.id.img_item);
            txtName = itemView.findViewById(R.id.tv_item_name);
            txtPrice = itemView.findViewById(R.id.txt_price);
            btnFavorite = itemView.findViewById(R.id.btn_favorite);
            cardView = itemView.findViewById(R.id.cv_item);
        }
    }
}
