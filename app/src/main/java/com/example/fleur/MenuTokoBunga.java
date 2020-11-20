package com.example.fleur;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuTokoBunga extends AppCompatActivity {
    private RecyclerView rvSellers;
    private ArrayList<Toko> list = new ArrayList<>();
    private String title = "Cari Toko";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_toko_bunga);

        rvSellers = findViewById(R.id.rv_sellers);
        rvSellers.setHasFixedSize(true);

        list.addAll(DataToko.getListData());
        showRecyclerList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toko, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list2:
                title = "List View";
                showRecyclerList();
                break;

                /**
            case R.id.action_grid2:
                title = "Grid View";
                showRecyclerGrid();
                break;
                 **/

            case R.id.action_cardview2:
                title = "Card View";
                showRecyclerCardView();
                break;
        }
        setActionBarTitle(title);
    }

    private void showRecyclerList(){
        rvSellers.setLayoutManager(new GridLayoutManager(this, 1));
        ListTokoAdapter listTokoAdapter = new ListTokoAdapter(list);
        rvSellers.setAdapter(listTokoAdapter);

        listTokoAdapter.setOnItemClickCallback(new ListTokoAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Toko data) {
                showSelectedToko(data);
            }
        });
    }

    /**
    private void showRecyclerGrid(){
        rvSellers.setLayoutManager(new GridLayoutManager(this, 2));
        GridTokoAdapter gridTokoAdapter = new GridTokoAdapter(list);
        rvSellers.setAdapter(gridTokoAdapter);

        gridTokoAdapter.setOnItemClickCallback(new ListTokoAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Toko data) {
                showSelectedToko(data);
            }
        });
    }
    **/

    private void showRecyclerCardView(){
        rvSellers.setLayoutManager(new LinearLayoutManager(this));
        CardViewTokoAdapter cardViewTokoAdapter = new CardViewTokoAdapter(list);
        rvSellers.setAdapter(cardViewTokoAdapter);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showSelectedToko(Toko toko) {
        Toast.makeText(this, "Kamu memilih " + toko.getName(), Toast.LENGTH_SHORT).show();
    }
}
