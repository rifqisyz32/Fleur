package com.example.fleur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class StaggeredArtiBunga extends AppCompatActivity {

    private RecyclerView rvStaggered;
    private StaggeredBungaAdapter staggeredBungaAdapter;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staggered_arti_bunga);

        rvStaggered = findViewById(R.id.rv_staggered);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rvStaggered.setLayoutManager(staggeredGridLayoutManager);

        List<Bunga> slist = new ArrayList<>();
        slist.add(new Bunga(getString(R.string.anggrek), getString(R.string.anggrek_detail), getString(R.string.anggrek_latin), R.drawable.anggrek));
        slist.add(new Bunga(getString(R.string.anyelir_kuning), getString(R.string.anyelir_kuning_detail), getString(R.string.anyelir_kuning_latin), R.drawable.anyelir_kuning));
        slist.add(new Bunga(getString(R.string.anyelir_merah), getString(R.string.anyelir_merah_detail), getString(R.string.anyelir_merah_latin), R.drawable.anyelir_merah));
        slist.add(new Bunga(getString(R.string.anyelir_pink), getString(R.string.anyelir_pink_detail), getString(R.string.anyelir_pink_latin), R.drawable.anyelir_pink));
        slist.add(new Bunga(getString(R.string.anyelir_putih), getString(R.string.anyelir_putih_detail), getString(R.string.anyelir_putih_latin), R.drawable.anyelir_putih));
        slist.add(new Bunga(getString(R.string.anyelir_ungu), getString(R.string.anyelir_ungu_detail), getString(R.string.anyelir_ungu_latin), R.drawable.anyelir_ungu));
        slist.add(new Bunga(getString(R.string.daisy_kuning), getString(R.string.daisy_kuning_detail), getString(R.string.daisy_kuning_latin), R.drawable.daisy_kuning));
        slist.add(new Bunga(getString(R.string.daisy_merah), getString(R.string.daisy_merah_detail), getString(R.string.daisy_merah_latin), R.drawable.daisy_merah));
        slist.add(new Bunga(getString(R.string.daisy_pink), getString(R.string.daisy_pink_detail), getString(R.string.daisy_pink_latin), R.drawable.daisy_pink));
        slist.add(new Bunga(getString(R.string.daisy_orange), getString(R.string.daisy_orange_detail), getString(R.string.daisy_orange_latin), R.drawable.daisy_orange));
        slist.add(new Bunga(getString(R.string.daisy_ungu), getString(R.string.daisy_ungu_detail), getString(R.string.daisy_ungu_latin), R.drawable.daisy_ungu));
        slist.add(new Bunga(getString(R.string.daisy_putih), getString(R.string.daisy_putih_detail), getString(R.string.daisy_putih_latin), R.drawable.daisy_putih));
        slist.add(new Bunga(getString(R.string.herbras), getString(R.string.herbras_detail), getString(R.string.herbras_latin), R.drawable.herbras));
        slist.add(new Bunga(getString(R.string.mawar), getString(R.string.mawar_detail), getString(R.string.mawar_latin), R.drawable.mawar));
        slist.add(new Bunga(getString(R.string.tulip), getString(R.string.tulip_detail), getString(R.string.tulip_latin), R.drawable.tulip));
        slist.add(new Bunga(getString(R.string.teratai), getString(R.string.teratai_detail), getString(R.string.teratai_latin), R.drawable.teratai));
        slist.add(new Bunga(getString(R.string.kembang_sepatu), getString(R.string.kembang_sepatu_detail), getString(R.string.kembang_sepatu_latin), R.drawable.kembang_sepatu));
        slist.add(new Bunga(getString(R.string.melati), getString(R.string.melati_detail), getString(R.string.melati_latin), R.drawable.melati));
        slist.add(new Bunga(getString(R.string.aster), getString(R.string.aster_detail), getString(R.string.aster_latin), R.drawable.aster));
        slist.add(new Bunga(getString(R.string.kateliya), getString(R.string.kateliya_detail), getString(R.string.kateliya_latin), R.drawable.kateliya));

        staggeredBungaAdapter = new StaggeredBungaAdapter(this, slist);
        rvStaggered.setAdapter(staggeredBungaAdapter);

    }
}