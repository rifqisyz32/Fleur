package com.example.fleur;

import android.content.Intent;
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

public class ListBungaAdapter extends RecyclerView.Adapter<ListBungaAdapter.ListViewHolder> {
    private ArrayList<Bunga> listBunga;

    public ListBungaAdapter(ArrayList<Bunga> list) {
        this.listBunga = list;
    }

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_bunga, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Bunga bunga = listBunga.get(position);
        Glide.with(holder.itemView.getContext()).load(bunga.getPhoto())
                .apply(new RequestOptions().override(55, 55)).into(holder.imgPhoto);
        holder.tvName.setText(bunga.getName());
        holder.tvFrom.setText(bunga.getFrom());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 //intent disini
                Intent l = new Intent(holder.itemView.getContext(), DetailBunga.class);
                holder.itemView.getContext().startActivity(l);
                 **/
                onItemClickCallback.onItemClicked(listBunga.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBunga.size();
    }

    public interface OnItemClickCallback {
        void onItemClicked(Bunga data);
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvFrom;
        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
        }
    }
}
