package com.example.fleur;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridTokoAdapter extends RecyclerView.Adapter<GridTokoAdapter.GridViewHolder>{
    private ArrayList<Toko> listToko;

    public GridTokoAdapter(ArrayList<Toko> list) {
        this.listToko = list;
    }
    private ListTokoAdapter.OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(ListTokoAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }
    @NonNull
    @Override
    public GridTokoAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_toko, viewGroup, false);
        return new GridTokoAdapter.GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridTokoAdapter.GridViewHolder holder, int position) {
        Toko toko = listToko.get(position);
        Glide.with(holder.itemView.getContext())
                .load(listToko.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto2);
        holder.tvName2.setText(toko.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listToko.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listToko.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto2;
        TextView tvName2;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto2 = itemView.findViewById(R.id.img_item_photo2);
            tvName2 = itemView.findViewById(R.id.tv_item_name2);
        }
    }
}
