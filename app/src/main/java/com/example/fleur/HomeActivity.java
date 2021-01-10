package com.example.fleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnArtiBunga;
    private Button btnTokoBunga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnArtiBunga = (Button)findViewById(R.id.btn_arti_bunga);
        btnArtiBunga.setOnClickListener(this);

        btnTokoBunga = (Button)findViewById(R.id.btn_toko_bunga);
        btnTokoBunga.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){

            case R.id.btn_arti_bunga:
                Intent moveToMenuBunga = new Intent(HomeActivity.this, MenuArtiBunga.class);
                startActivity (moveToMenuBunga);
                break;

            case R.id.btn_toko_bunga:
                Intent moveToTokoBunga = new Intent(HomeActivity.this, MenuTokoBunga.class);
                startActivity (moveToTokoBunga);
                break;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.language, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_settings) {
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}