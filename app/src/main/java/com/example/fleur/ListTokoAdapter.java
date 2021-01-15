package com.example.fleur;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;


public class ListTokoAdapter extends RecyclerView.Adapter<ListTokoAdapter.ListViewHolder> implements Filterable {

    Context mContext;
    List<Toko> list;
    List<Toko> listFiltered;
    boolean isDark = false;
    Dialog ldialog;


    public ListTokoAdapter(Context mContext, List<Toko> list, boolean isDark) {
        this.mContext = mContext;
        this.list = list;
        this.isDark = isDark;
        this.listFiltered = list;
    }

    public ListTokoAdapter(Context mContext, List<Toko> list) {
        this.mContext = mContext;
        this.list = list;
        this.listFiltered = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_list_toko, viewGroup,false);
        final ListViewHolder viewHolder = new ListViewHolder((v));
        ldialog = new Dialog(mContext);
        ldialog.setContentView(R.layout.toko_info);
        ldialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        viewHolder.item_list_toko.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                LinearLayout container_dialog = (LinearLayout) ldialog.findViewById(R.id.container_dialog2);
                TextView tv_name_dialog = (TextView) ldialog.findViewById(R.id.tv_name_dialog2);
                TextView tv_desc_dialog = (TextView) ldialog.findViewById(R.id.tv_desc_dialog2);
                ImageView img_photo_dialog = (ImageView) ldialog.findViewById(R.id.img_photo_dialog2);

                container_dialog.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_scale_animation));
                img_photo_dialog.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));
                tv_name_dialog.setText(listFiltered.get(viewHolder.getAdapterPosition()).getName());
                tv_desc_dialog.setText(listFiltered.get(viewHolder.getAdapterPosition()).getDescription());
                img_photo_dialog.setImageResource(listFiltered.get(viewHolder.getAdapterPosition()).getPhoto());

                ldialog.show();
            }
        });
        return viewHolder;
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
                    List<Toko> lstFiltered = new ArrayList<>();
                    for (Toko row : list) {

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

                listFiltered = (List<Toko>) results.values;
                notifyDataSetChanged();

            }
        };
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout item_list_toko;
        TextView tv_name,tv_description;
        ImageView img_photo;
        RelativeLayout container;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            item_list_toko = itemView.findViewById(R.id.item_list_toko);
            container = itemView.findViewById(R.id.container2);
            tv_name = itemView.findViewById(R.id.tv_name2);
            tv_description = itemView.findViewById(R.id.tv_description2);
            img_photo = itemView.findViewById(R.id.img_photo2);

            if (isDark) {
                setDarkTheme();
            }
        }
        private void setDarkTheme() {

            container.setBackgroundResource(R.drawable.card_bg_dark);

        }
    }
}

/*
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
}*/
