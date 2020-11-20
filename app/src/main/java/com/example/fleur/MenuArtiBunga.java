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

public class MenuArtiBunga extends AppCompatActivity {
    private RecyclerView rvFlowers;
        private ArrayList<Bunga> list = new ArrayList<>();
        private String title = "Cari Bunga";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.menu_arti_bunga);

            rvFlowers = findViewById(R.id.rv_flowers);
            rvFlowers.setHasFixedSize(true);

        list.addAll(DataBunga.getListData());
        showRecyclerList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bunga, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                title = "List View";
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Grid View";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "Card View";
                showRecyclerCardView();
                break;
        }
        setActionBarTitle(title);
    }

    private void showRecyclerList(){
        rvFlowers.setLayoutManager(new GridLayoutManager(this, 1));
        ListBungaAdapter listBungaAdapter = new ListBungaAdapter(list);
        rvFlowers.setAdapter(listBungaAdapter);

        listBungaAdapter.setOnItemClickCallback(new ListBungaAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Bunga data) {
                showSelectedBunga(data);
            }
        });
    }

    private void showRecyclerGrid(){
        rvFlowers.setLayoutManager(new GridLayoutManager(this, 2));
        GridBungaAdapter gridBungaAdapter = new GridBungaAdapter(list);
        rvFlowers.setAdapter(gridBungaAdapter);

        gridBungaAdapter.setOnItemClickCallback(new ListBungaAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Bunga data) {
                showSelectedBunga(data);

            }
        });
    }

    private void showRecyclerCardView(){
        rvFlowers.setLayoutManager(new LinearLayoutManager(this));
        CardViewBungaAdapter cardViewBungaAdapter = new CardViewBungaAdapter(list);
        rvFlowers.setAdapter(cardViewBungaAdapter);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showSelectedBunga(Bunga bunga) {
         Toast.makeText(this, "Kamu memilih " + bunga.getName(), Toast.LENGTH_SHORT).show();
    }
}
