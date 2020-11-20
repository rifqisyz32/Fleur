package com.example.fleur;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewTokoAdapter extends RecyclerView.Adapter<CardViewTokoAdapter.CardViewViewHolder>{
    private ArrayList<Toko> listToko;

    public CardViewTokoAdapter(ArrayList<Toko> list) {
            this.listToko = list;
            }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_toko, viewGroup, false);
            return new CardViewViewHolder(view);
            }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {

            Toko toko = listToko.get(position);
            Glide.with(holder.itemView.getContext())
            .load(toko.getPhoto())
            .apply(new RequestOptions().override(350, 550))
            .into(holder.imgPhoto2);
            holder.tvName2.setText(toko.getName());
            holder.tvFrom2.setText(toko.getFrom());

            holder.btnFavorite2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
            Toast.makeText(holder.itemView.getContext(), "Favorite " +
            listToko.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
            });

            holder.btnShare2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
            Toast.makeText(holder.itemView.getContext(), "Share " +
            listToko.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
            });

            holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
            Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + listToko.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
            });

            }

    @Override
    public int getItemCount() {
            return listToko.size();
            }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto2;
        TextView tvName2, tvFrom2;
        Button btnFavorite2, btnShare2;
        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto2 = itemView.findViewById(R.id.img_item_photo2);
            tvName2 = itemView.findViewById(R.id.tv_item_name2);
            tvFrom2 = itemView.findViewById(R.id.tv_item_from2);
            btnFavorite2 = itemView.findViewById(R.id.btn_set_favorite2);
            btnShare2 = itemView.findViewById(R.id.btn_set_share2);
        }
    }
}
