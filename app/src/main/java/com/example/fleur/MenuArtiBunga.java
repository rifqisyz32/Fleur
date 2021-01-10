package com.example.fleur;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

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
        showRecyclerList(); }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bunga, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        if (searchManager != null) {
            SearchView searchView = (SearchView) (menu.findItem(R.id.search)).getActionView();
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setQueryHint(getResources().getString(R.string.search_hint));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    Toast.makeText(MenuArtiBunga.this, query, Toast.LENGTH_SHORT).show();
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
        }
        return true;
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
         Toast.makeText(this,getResources().getString(R.string.you_choose) + " " + getResources().getString(bunga.getName()), Toast.LENGTH_SHORT).show();
    }
}
