package com.example.fleur;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailBunga extends AppCompatActivity {

    ImageView img_photo_detail;
    TextView tv_name_detail;
    TextView tv_name_latin;
    TextView tv_desc_detail;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bunga_detail);

        img_photo_detail = findViewById(R.id.img_photo_detail);
        tv_name_detail = findViewById(R.id.tv_name_detail);
        tv_name_latin = findViewById(R.id.tv_name_latin);
        tv_desc_detail = findViewById(R.id.tv_desc_detail);

        Bunga item = (Bunga) getIntent().getExtras().getSerializable("bungaObject");

        loadBungaData(item);
    }

    private void loadBungaData(Bunga item) {
        Glide.with(this).load(item.getPhoto()).into(img_photo_detail);

    }
}
