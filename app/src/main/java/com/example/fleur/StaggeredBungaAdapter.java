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

public class StaggeredBungaAdapter extends RecyclerView.Adapter<StaggeredBungaAdapter.ImageViewHolder> {

    Context mContext;
    List<Bunga> list;
    Dialog sdialog;

    public StaggeredBungaAdapter(Context mContext, List<Bunga> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_staggered_bunga, viewGroup,false);
        final ImageViewHolder viewHolder = new ImageViewHolder((v));
        
        sdialog = new Dialog(mContext);
        sdialog.setContentView(R.layout.bunga_info);
        sdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        viewHolder.item_staggered_bunga.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                LinearLayout container_dialog = (LinearLayout) sdialog.findViewById(R.id.container_dialog);
                TextView tv_name_dialog = (TextView) sdialog.findViewById(R.id.tv_name_dialog);
                TextView tv_latin_dialog = (TextView) sdialog.findViewById(R.id.tv_latin_dialog);
                TextView tv_desc_dialog = (TextView) sdialog.findViewById(R.id.tv_desc_dialog);
                ImageView img_photo_dialog = (ImageView) sdialog.findViewById(R.id.img_photo_dialog);

                container_dialog.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_scale_animation));
                img_photo_dialog.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));
                tv_name_dialog.setText(list.get(viewHolder.getAdapterPosition()).getName());
                tv_latin_dialog.setText(list.get(viewHolder.getAdapterPosition()).getLatin());
                tv_desc_dialog.setText(list.get(viewHolder.getAdapterPosition()).getDescription());
                img_photo_dialog.setImageResource(list.get(viewHolder.getAdapterPosition()).getPhoto());

                sdialog.show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
        imageViewHolder.img_photo.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_animation));
        imageViewHolder.img_photo.setImageResource(list.get(i).getPhoto());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout item_staggered_bunga;
        private ImageView img_photo;
        /*private TextView tv_name,tv_description,tv_latin;
        private RelativeLayout container;*/

        public ImageViewHolder(@NonNull View itemView){
            super(itemView);
            item_staggered_bunga = itemView.findViewById(R.id.item_staggered_bunga);
            /*container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_latin = itemView.findViewById(R.id.tv_latin);*/
            img_photo = itemView.findViewById(R.id.img_staggered);
        }
    }
}
