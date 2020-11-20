package com.example.fleur;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailBunga extends AppCompatActivity {
    TextView tvName, tvFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bunga_detail);
       // tvName = findViewById(R.id.tv_item_name3);

    }
}
