package com.asrul.tugaspertemuan7.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asrul.tugaspertemuan7.Data.Camera;
import com.asrul.tugaspertemuan7.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListDataAdapter extends RecyclerView.Adapter<ListDataAdapter.ListDataHolder> {
    private ArrayList<Camera> listData;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListDataAdapter(ArrayList<Camera> list) {
        this.listData = list;
    }

    @NonNull
    @Override
    public ListDataAdapter.ListDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListDataAdapter.ListDataHolder holder, int position) {
        Camera data = listData.get(position);
        Glide.with(holder.itemView.getContext())
                .load(data.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.txtName.setText(data.getName());
        holder.txtPrice.setText(data.getPrice());
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

    public static class ListDataHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView txtName, txtPrice;

        public ListDataHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_circle);
            txtName = itemView.findViewById(R.id.txt_name);
            txtPrice = itemView.findViewById(R.id.txt_price);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Camera data);
    }
}
