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

        showBungaList();

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
                showBungaList();
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

    private void showBungaList() {
        listBungaAdapter = new ListBungaAdapter(this, list, isDark);
        rvFlowers.setAdapter(listBungaAdapter);
        rvFlowers.setLayoutManager(new LinearLayoutManager(this));
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