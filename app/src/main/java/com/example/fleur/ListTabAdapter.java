package com.example.fleur;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListTabAdapter extends RecyclerView.Adapter<ListTabAdapter.ListTabViewHolder> {


    Context mContext;
    List<Bunga> list;
    Dialog ldialog;

    public ListTabAdapter(Context mContext, List<Bunga> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ListTabViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.frag_list_bunga, viewGroup,false);
        final ListTabViewHolder listTabViewHolder = new ListTabViewHolder((v));

        ldialog = new Dialog(mContext);
        ldialog.setContentView(R.layout.bunga_info);
        ldialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        listTabViewHolder.item_list_bunga.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                LinearLayout container_dialog = (LinearLayout) ldialog.findViewById(R.id.container_dialog);
                TextView tv_name_dialog = (TextView) ldialog.findViewById(R.id.tv_name_dialog);
                TextView tv_latin_dialog = (TextView) ldialog.findViewById(R.id.tv_latin_dialog);
                TextView tv_desc_dialog = (TextView) ldialog.findViewById(R.id.tv_desc_dialog);
                ImageView img_photo_dialog = (ImageView) ldialog.findViewById(R.id.img_photo_dialog);

                container_dialog.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_scale_animation));
                img_photo_dialog.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));
                tv_name_dialog.setText(list.get(listTabViewHolder.getAdapterPosition()).getName());
                tv_latin_dialog.setText(list.get(listTabViewHolder.getAdapterPosition()).getLatin());
                tv_desc_dialog.setText(list.get(listTabViewHolder.getAdapterPosition()).getDescription());
                img_photo_dialog.setImageResource(list.get(listTabViewHolder.getAdapterPosition()).getPhoto());

                ldialog.show();
            }
            });
        return listTabViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListTabViewHolder listDataViewHolder, int i) {
        listDataViewHolder.img_photo.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));
        listDataViewHolder.container.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_scale_animation));
        listDataViewHolder.tv_name.setText(list.get(i).getName());
        listDataViewHolder.tv_description.setText(list.get(i).getDescription());
        listDataViewHolder.tv_latin.setText(list.get(i).getLatin());
        listDataViewHolder.img_photo.setImageResource(list.get(i).getPhoto());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListTabViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout item_list_bunga;
        private TextView tv_name,tv_description,tv_latin;
        private ImageView img_photo;
        private RelativeLayout container;

        public ListTabViewHolder(@NonNull View itemView){
            super(itemView);
            item_list_bunga = itemView.findViewById(R.id.item_list_bunga);
            container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_latin = itemView.findViewById(R.id.tv_latin);
            img_photo = itemView.findViewById(R.id.img_photo);
        }
    }
}
