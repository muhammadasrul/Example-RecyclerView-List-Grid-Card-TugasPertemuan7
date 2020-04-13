package com.asrul.tugaspertemuan7.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asrul.tugaspertemuan7.Data.Camera;
import com.asrul.tugaspertemuan7.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GridDataAdapter extends RecyclerView.Adapter<GridDataAdapter.GridViewHolder> {

    private ArrayList<Camera> listData;
    private OnItemClickCallback onItemClickCallback;
    public GridDataAdapter(ArrayList<Camera> list) {
        this.listData = list;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, final int position) {
        final Camera data = listData.get(position);
        Glide.with(holder.itemView.getContext())
                .load(listData.get(position).getPhoto())
                .into(holder.imgItem);
        holder.txtName.setText(data.getName());
        holder.txtPrice.setText(data.getPrice());
        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Favorite " + data.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listData.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgItem, btnFavorite;
        TextView txtName, txtPrice;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.img_item);
            txtName = itemView.findViewById(R.id.txt_name);
            txtPrice = itemView.findViewById(R.id.txt_price);
            btnFavorite = itemView.findViewById(R.id.btn_favorite);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Camera data);
    }
}
