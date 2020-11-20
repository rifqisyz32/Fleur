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

public class ListTokoAdapter extends RecyclerView.Adapter<ListTokoAdapter.ListViewHolder> {
    private ArrayList<Toko> listToko;

    public ListTokoAdapter(ArrayList<Toko> list) {
        this.listToko = list;
    }

    private ListTokoAdapter.OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(ListTokoAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListTokoAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_toko, viewGroup, false);
        return new ListTokoAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListTokoAdapter.ListViewHolder holder, int position) {
        Toko toko = listToko.get(position);
        Glide.with(holder.itemView.getContext()).load(toko.getPhoto()).apply(new RequestOptions().override(55, 55)).into(holder.imgPhoto2);
        holder.tvName2.setText(toko.getName());
        holder.tvFrom2.setText(toko.getFrom());
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

    public interface OnItemClickCallback {
        void onItemClicked(Toko data);
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto2;
        TextView tvName2, tvFrom2;
        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto2 = itemView.findViewById(R.id.img_item_photo2);
            tvName2 = itemView.findViewById(R.id.tv_item_name2);
            tvFrom2 = itemView.findViewById(R.id.tv_item_from2);
        }
    }
}
