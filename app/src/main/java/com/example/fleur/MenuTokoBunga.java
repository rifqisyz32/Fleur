package com.example.fleur;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toko, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        if (searchManager != null) {
            SearchView searchView = (SearchView) (menu.findItem(R.id.search2)).getActionView();
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setQueryHint(getResources().getString(R.string.search_hint2));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                @Override
                public boolean onQueryTextSubmit(String query) {
                    Toast.makeText(MenuTokoBunga.this, query, Toast.LENGTH_SHORT).show();
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

    /*
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
    */

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
        Toast.makeText(this, getResources().getString(R.string.you_choose) + " " + getResources().getString(toko.getName()), Toast.LENGTH_SHORT).show();
    }
}
