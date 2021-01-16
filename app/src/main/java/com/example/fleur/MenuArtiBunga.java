package com.example.fleur;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MenuArtiBunga extends AppCompatActivity {

    RecyclerView rvFlowers;
    ListBungaAdapter listBungaAdapter;
    List<Bunga> list;
    FloatingActionButton fabSwitcher;
    boolean isDark = false;
    EditText searchInput ;
    CharSequence search="";
    ConstraintLayout rootLayout;
    //private String title = "Cari Bunga";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_arti_bunga);
/*
        // let's make this activity on full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // hide the action bar

        getSupportActionBar().hide();*/

        rvFlowers = findViewById(R.id.rv_flowers);
        list = new ArrayList<>();

        fabSwitcher = findViewById(R.id.fab_switcher);
        rootLayout = findViewById(R.id.menu_arti_bunga);
        searchInput = findViewById(R.id.search_input);

        // load theme state

        isDark = getThemeStatePref();
        if (isDark) {
            // dark theme is on
            searchInput.setBackgroundResource(R.drawable.search_input_dark_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.black_temp));

        } else {
            // light theme is on
            searchInput.setBackgroundResource(R.drawable.search_input_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.white_temp));

        }
        // fill list news with data
        // just for testing purpose i will fill the news list with random data
        // you may get your data from an api / firebase or sqlite database ...

        list.add(new Bunga(getString(R.string.anggrek), getString(R.string.anggrek_detail), getString(R.string.anggrek_latin), R.drawable.anggrek));
        list.add(new Bunga(getString(R.string.anyelir_kuning), getString(R.string.anyelir_kuning_detail), getString(R.string.anyelir_kuning_latin), R.drawable.anyelir_kuning));
        list.add(new Bunga(getString(R.string.anyelir_merah), getString(R.string.anyelir_merah_detail), getString(R.string.anyelir_merah_latin), R.drawable.anyelir_merah));
        list.add(new Bunga(getString(R.string.anyelir_pink), getString(R.string.anyelir_pink_detail), getString(R.string.anyelir_pink_latin), R.drawable.anyelir_pink));
        list.add(new Bunga(getString(R.string.anyelir_putih), getString(R.string.anyelir_putih_detail), getString(R.string.anyelir_putih_latin), R.drawable.anyelir_putih));
        list.add(new Bunga(getString(R.string.anyelir_ungu), getString(R.string.anyelir_ungu_detail), getString(R.string.anyelir_ungu_latin), R.drawable.anyelir_ungu));
        list.add(new Bunga(getString(R.string.daisy_kuning), getString(R.string.daisy_kuning_detail), getString(R.string.daisy_kuning_latin), R.drawable.daisy_kuning));
        list.add(new Bunga(getString(R.string.daisy_merah), getString(R.string.daisy_merah_detail), getString(R.string.daisy_merah_latin), R.drawable.daisy_merah));
        list.add(new Bunga(getString(R.string.daisy_pink), getString(R.string.daisy_pink_detail), getString(R.string.daisy_pink_latin), R.drawable.daisy_pink));
        list.add(new Bunga(getString(R.string.daisy_orange), getString(R.string.daisy_orange_detail), getString(R.string.daisy_orange_latin), R.drawable.daisy_orange));
        list.add(new Bunga(getString(R.string.daisy_ungu), getString(R.string.daisy_ungu_detail), getString(R.string.daisy_ungu_latin), R.drawable.daisy_ungu));
        list.add(new Bunga(getString(R.string.daisy_putih), getString(R.string.daisy_putih_detail), getString(R.string.daisy_putih_latin), R.drawable.daisy_putih));
        list.add(new Bunga(getString(R.string.herbras), getString(R.string.herbras_detail), getString(R.string.herbras_latin), R.drawable.herbras));
        list.add(new Bunga(getString(R.string.mawar), getString(R.string.mawar_detail), getString(R.string.mawar_latin), R.drawable.mawar));
        list.add(new Bunga(getString(R.string.tulip), getString(R.string.tulip_detail), getString(R.string.tulip_latin), R.drawable.tulip));
        list.add(new Bunga(getString(R.string.teratai), getString(R.string.teratai_detail), getString(R.string.teratai_latin), R.drawable.teratai));
        list.add(new Bunga(getString(R.string.kembang_sepatu), getString(R.string.kembang_sepatu_detail), getString(R.string.kembang_sepatu_latin), R.drawable.kembang_sepatu));
        list.add(new Bunga(getString(R.string.melati), getString(R.string.melati_detail), getString(R.string.melati_latin), R.drawable.melati));
        list.add(new Bunga(getString(R.string.aster), getString(R.string.aster_detail), getString(R.string.aster_latin), R.drawable.aster));
        list.add(new Bunga(getString(R.string.kateliya), getString(R.string.kateliya_detail), getString(R.string.kateliya_latin), R.drawable.kateliya));

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

        listBungaAdapter = new ListBungaAdapter(this, list, isDark);
        rvFlowers.setAdapter(listBungaAdapter);
        rvFlowers.setLayoutManager(new LinearLayoutManager(this));


        fabSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDark = !isDark;
                if (isDark) {

                    rootLayout.setBackgroundColor(getResources().getColor(R.color.black_temp));
                    searchInput.setBackgroundResource(R.drawable.search_input_dark_style);

                } else {
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.white_temp));
                    searchInput.setBackgroundResource(R.drawable.search_input_style);
                }

                listBungaAdapter = new ListBungaAdapter(getApplicationContext(), list, isDark);
                if (!search.toString().isEmpty()){
                    listBungaAdapter.getFilter().filter(search);
                }
                rvFlowers.setAdapter(listBungaAdapter);
                sortArrayList();
                saveThemeStatePref(isDark);
            }
        });

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                listBungaAdapter.getFilter().filter(s);
                search = s;
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void sortArrayList(){
        Collections.sort(list, new Comparator<Bunga>() {
            @Override
            public int compare(Bunga o1, Bunga o2) {
                return o1.getName().compareTo(o2.getName());
            }

        });
        listBungaAdapter.notifyDataSetChanged();
    }

    private void saveThemeStatePref(boolean isDark) {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isDark",isDark);
        editor.commit();
    }

    private boolean getThemeStatePref () {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        boolean isDark = pref.getBoolean("isDark",false) ;
        return isDark;

    }
}
/*
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
}*/
