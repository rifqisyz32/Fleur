package com.example.fleur;

import android.app.SearchManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MenuTokoBunga extends AppCompatActivity {

    RecyclerView rvSellers;
    ListTokoAdapter listTokoAdapter;
    List<Toko> list;
    FloatingActionButton fabSwitcher;
    boolean isDark2 = false;
    EditText searchInput;
    CharSequence search = "";
    ConstraintLayout rootLayout;
    //private String title = "Cari Toko";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_toko_bunga);
/*
        // let's make this activity on full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // hide the action bar

        getSupportActionBar().hide();*/

        rvSellers = findViewById(R.id.rv_sellers);
        list = new ArrayList<>();

        fabSwitcher = findViewById(R.id.fab_switcher2);
        rootLayout = findViewById(R.id.menu_toko_bunga);
        searchInput = findViewById(R.id.search_input2);

        // load theme state

        isDark2 = getThemeStatePref();
        if (isDark2) {
            // dark theme is on
            searchInput.setBackgroundResource(R.drawable.search_input_dark_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.black));

        } else {
            // light theme is on
            searchInput.setBackgroundResource(R.drawable.search_input_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.white));

        }
        // fill list news with data
        // just for testing purpose i will fill the news list with random data
        // you may get your data from an api / firebase or sqlite database ...

        list.add(new Toko(getString(R.string.adisty_florist), getString(R.string.adisty_florist_detail), R.drawable.toko_logo));
        list.add(new Toko(getString(R.string.and_florist), getString(R.string.and_florist_detail), R.drawable.toko_logo));
        list.add(new Toko(getString(R.string.adm_florist), getString(R.string.adm_florist_detail), R.drawable.toko_logo));
        list.add(new Toko(getString(R.string.ays_florist), getString(R.string.ays_florist_detail), R.drawable.toko_logo));
        list.add(new Toko(getString(R.string.black_rose_florist), getString(R.string.black_rose_florist_detail), R.drawable.toko_logo));
        list.add(new Toko(getString(R.string.distin_florist), getString(R.string.distin_florist_detail), R.drawable.toko_logo));
        list.add(new Toko(getString(R.string.els_florist), getString(R.string.els_florist_detail), R.drawable.toko_logo));
        list.add(new Toko(getString(R.string.fleur_tales), getString(R.string.fleur_tales_detail), R.drawable.toko_logo));

        /*
        list.add(new Bunga("I love Programming And Design", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,", "6 july 1994", R.drawable.anyelir_pink));
        list.add(new Bunga("My first trip to Thailand story ", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "6 july 1994", R.drawable.anyelir_putih));
        list.add(new Bunga("After Facebook Messenger, Viber now gets...", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,", "6 july 1994", R.drawable.anyelir_ungu));
        list.add(new Bunga("Isometric Design Grid Concept", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit", "6 july 1994", R.drawable.daisy_putih));
        list.add(new Bunga("Android R Design Concept 4K", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit ", "6 july 1994", R.drawable.daisy_kuning));
        list.add(new Bunga("OnePlus 6T Camera Review:", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "6 july 1994", R.drawable.anyelir_kuning));
        list.add(new Bunga("I love Programming And Design", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,", "6 july 1994", R.drawable.daisy_merah));
        list.add(new Bunga("My first trip to Thailand story ", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "6 july 1994", R.drawable.anyelir_merah));
        list.add(new Bunga("After Facebook Messenger, Viber now gets...", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,", "6 july 1994", R.drawable.daisy_orange));
        list.add(new Bunga("Isometric Design Grid Concept", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit", "6 july 1994", R.drawable.daisy_pink));
        list.add(new Bunga("Android R Design Concept 4K", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit ", "6 july 1994", R.drawable.daisy_ungu));
        list.add(new Bunga("OnePlus 6T Camera Review:", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "6 july 1994", R.drawable.herbras));
*/

        // adapter ini and setup

        listTokoAdapter = new ListTokoAdapter(this, list, isDark2);
        rvSellers.setAdapter(listTokoAdapter);
        rvSellers.setLayoutManager(new LinearLayoutManager(this));


        fabSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDark2 = !isDark2;
                if (isDark2) {

                    rootLayout.setBackgroundColor(getResources().getColor(R.color.black));
                    searchInput.setBackgroundResource(R.drawable.search_input_dark_style);

                } else {
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.white));
                    searchInput.setBackgroundResource(R.drawable.search_input_style);
                }

                listTokoAdapter = new ListTokoAdapter(getApplicationContext(), list, isDark2);
                if (!search.toString().isEmpty()) {
                    listTokoAdapter.getFilter().filter(search);
                }
                rvSellers.setAdapter(listTokoAdapter);
                saveThemeStatePref(isDark2);
            }
        });

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                listTokoAdapter.getFilter().filter(s);
                search = s;
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void saveThemeStatePref(boolean isDark2) {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isDark2", isDark2);
        editor.commit();
    }

    private boolean getThemeStatePref() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref", MODE_PRIVATE);
        boolean isDark2 = pref.getBoolean("isDark2", false);
        return isDark2;

    }
}

   /* private RecyclerView rvSellers;
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

                *//**
            case R.id.action_grid2:
                title = "Grid View";
                showRecyclerGrid();
                break;
                 **//*

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

    *//*
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
    *//*

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
}*/
