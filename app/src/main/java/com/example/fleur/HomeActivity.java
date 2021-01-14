package com.example.fleur;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;


public class HomeActivity extends AppCompatActivity {
    private Button btnArtiBunga;
    private Button btnTokoBunga;
    private Button btnTabBunga;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.home_temp)));

        btnArtiBunga = (Button)findViewById(R.id.btn_arti_bunga);

        btnTokoBunga = (Button)findViewById(R.id.btn_toko_bunga);

        btnTabBunga = (Button)findViewById(R.id.btn_tab_bunga);


        btnArtiBunga.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent moveToMenuBunga = new Intent(HomeActivity.this, MenuArtiBunga.class);
                    startActivity (moveToMenuBunga);
                }
        });

        btnTokoBunga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToTokoBunga = new Intent(HomeActivity.this, MenuTokoBunga.class);
                startActivity (moveToTokoBunga);
            }
        });

        btnTabBunga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToTabBunga = new Intent(HomeActivity.this, TabBunga.class);
                startActivity (moveToTabBunga);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_display:
                Intent dIntent = new Intent(Settings.ACTION_DISPLAY_SETTINGS);
                startActivity(dIntent);
                break;

            case R.id.action_language:
                Intent lIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(lIntent);
                break;
        }
    }
}