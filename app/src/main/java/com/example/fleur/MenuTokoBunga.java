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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_toko_bunga);

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
            rootLayout.setBackgroundColor(getResources().getColor(R.color.black_temp));

        } else {
            // light theme is on
            searchInput.setBackgroundResource(R.drawable.search_input_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.white_temp));

        }

        list.add(new Toko(getString(R.string.adisty_florist), getString(R.string.adisty_florist_detail), R.drawable.toko_logo));
        list.add(new Toko(getString(R.string.and_florist), getString(R.string.and_florist_detail), R.drawable.toko_logo));
        list.add(new Toko(getString(R.string.adm_florist), getString(R.string.adm_florist_detail), R.drawable.toko_logo));
        list.add(new Toko(getString(R.string.ays_florist), getString(R.string.ays_florist_detail), R.drawable.toko_logo));
        list.add(new Toko(getString(R.string.black_rose_florist), getString(R.string.black_rose_florist_detail), R.drawable.toko_logo));
        list.add(new Toko(getString(R.string.distin_florist), getString(R.string.distin_florist_detail), R.drawable.toko_logo));
        list.add(new Toko(getString(R.string.els_florist), getString(R.string.els_florist_detail), R.drawable.toko_logo));
        list.add(new Toko(getString(R.string.fleur_tales), getString(R.string.fleur_tales_detail), R.drawable.toko_logo));

        showTokoList();

        fabSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDark2 = !isDark2;
                if (isDark2) {

                    rootLayout.setBackgroundColor(getResources().getColor(R.color.black_temp));
                    searchInput.setBackgroundResource(R.drawable.search_input_dark_style);

                } else {
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.white_temp));
                    searchInput.setBackgroundResource(R.drawable.search_input_style);
                }

                listTokoAdapter = new ListTokoAdapter(getApplicationContext(), list, isDark2);
                if (!search.toString().isEmpty()) {
                    listTokoAdapter.getFilter().filter(search);
                }
                rvSellers.setAdapter(listTokoAdapter);
                saveThemeStatePref(isDark2);
                showTokoList();
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

    private void showTokoList() {
        listTokoAdapter = new ListTokoAdapter(this, list, isDark2);
        rvSellers.setAdapter(listTokoAdapter);
        rvSellers.setLayoutManager(new LinearLayoutManager(this));
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