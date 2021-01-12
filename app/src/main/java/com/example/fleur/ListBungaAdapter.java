package com.example.fleur;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListBungaAdapter extends RecyclerView.Adapter<ListBungaAdapter.ListViewHolder> implements Filterable {

    Context mContext;
    List<Bunga> list;
    List<Bunga> listFiltered;
    boolean isDark = false;


    public ListBungaAdapter(Context mContext, List<Bunga> list, boolean isDark) {
        this.mContext = mContext;
        this.list = list;
        this.isDark = isDark;
        this.listFiltered = list;
    }

    public ListBungaAdapter(Context mContext, List<Bunga> list) {
        this.mContext = mContext;
        this.list = list;
        this.listFiltered = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.item_list_bunga,viewGroup,false);
        return new ListViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int position) {

        // bind data here

        // we apply animation to views here
        // first lets create an animation for photo photo
        listViewHolder.img_photo.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));

        // lets create the animation for the whole card
        // first lets create a reference to it
        // you ca use the previous same animation like the following

        // but i want to use a different one so lets create it ..
        listViewHolder.container.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_scale_animation));

        listViewHolder.tv_name.setText(listFiltered.get(position).getName());
        listViewHolder.tv_description.setText(listFiltered.get(position).getDescription());
        listViewHolder.tv_latin.setText(listFiltered.get(position).getLatin());
        listViewHolder.img_photo.setImageResource(listFiltered.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return listFiltered.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String Key = constraint.toString();
                if (Key.isEmpty()) {

                    listFiltered = list ;

                }
                else {
                    List<Bunga> lstFiltered = new ArrayList<>();
                    for (Bunga row : list) {

                        if (row.getName().toLowerCase().contains(Key.toLowerCase())){
                            lstFiltered.add(row);
                        }

                    }

                    listFiltered = lstFiltered;

                }

                FilterResults filterResults = new FilterResults();
                filterResults.values= listFiltered;
                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                listFiltered = (List<Bunga>) results.values;
                notifyDataSetChanged();

            }
        };
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name,tv_description,tv_latin;
        ImageView img_photo;
        RelativeLayout container;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_latin = itemView.findViewById(R.id.tv_latin);
            img_photo = itemView.findViewById(R.id.img_photo);

            if (isDark) {
                setDarkTheme();
            }
        }
        private void setDarkTheme() {

            container.setBackgroundResource(R.drawable.card_bg_dark);

        }
    }
}

/*public class ListBungaAdapter extends RecyclerView.Adapter<ListBungaAdapter.ListViewHolder> {

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
                *//**
                 //intent disini
                Intent l = new Intent(holder.itemView.getContext(), DetailBunga.class);
                holder.itemView.getContext().startActivity(l);
                 **//*
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
}*/
