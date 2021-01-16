package com.example.fleur;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class StaggeredFragment extends Fragment {

    View v;
    private RecyclerView sfrecyclerView;
    private List<Bunga> fslist;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;


    public StaggeredFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fslist = new ArrayList<>();
        fslist.add(new Bunga(getString(R.string.anggrek), getString(R.string.anggrek_detail), getString(R.string.anggrek_latin), R.drawable.anggrek));
        fslist.add(new Bunga(getString(R.string.anyelir_kuning), getString(R.string.anyelir_kuning_detail), getString(R.string.anyelir_kuning_latin), R.drawable.anyelir_kuning));
        fslist.add(new Bunga(getString(R.string.anyelir_merah), getString(R.string.anyelir_merah_detail), getString(R.string.anyelir_merah_latin), R.drawable.anyelir_merah));
        fslist.add(new Bunga(getString(R.string.anyelir_pink), getString(R.string.anyelir_pink_detail), getString(R.string.anyelir_pink_latin), R.drawable.anyelir_pink));
        fslist.add(new Bunga(getString(R.string.anyelir_putih), getString(R.string.anyelir_putih_detail), getString(R.string.anyelir_putih_latin), R.drawable.anyelir_putih));
        fslist.add(new Bunga(getString(R.string.anyelir_ungu), getString(R.string.anyelir_ungu_detail), getString(R.string.anyelir_ungu_latin), R.drawable.anyelir_ungu));
        fslist.add(new Bunga(getString(R.string.daisy_kuning), getString(R.string.daisy_kuning_detail), getString(R.string.daisy_kuning_latin), R.drawable.daisy_kuning));
        fslist.add(new Bunga(getString(R.string.daisy_merah), getString(R.string.daisy_merah_detail), getString(R.string.daisy_merah_latin), R.drawable.daisy_merah));
        fslist.add(new Bunga(getString(R.string.daisy_pink), getString(R.string.daisy_pink_detail), getString(R.string.daisy_pink_latin), R.drawable.daisy_pink));
        fslist.add(new Bunga(getString(R.string.daisy_orange), getString(R.string.daisy_orange_detail), getString(R.string.daisy_orange_latin), R.drawable.daisy_orange));
        fslist.add(new Bunga(getString(R.string.daisy_ungu), getString(R.string.daisy_ungu_detail), getString(R.string.daisy_ungu_latin), R.drawable.daisy_ungu));
        fslist.add(new Bunga(getString(R.string.daisy_putih), getString(R.string.daisy_putih_detail), getString(R.string.daisy_putih_latin), R.drawable.daisy_putih));
        fslist.add(new Bunga(getString(R.string.herbras), getString(R.string.herbras_detail), getString(R.string.herbras_latin), R.drawable.herbras));
        fslist.add(new Bunga(getString(R.string.mawar), getString(R.string.mawar_detail), getString(R.string.mawar_latin), R.drawable.mawar));
        fslist.add(new Bunga(getString(R.string.tulip), getString(R.string.tulip_detail), getString(R.string.tulip_latin), R.drawable.tulip));
        fslist.add(new Bunga(getString(R.string.teratai), getString(R.string.teratai_detail), getString(R.string.teratai_latin), R.drawable.teratai));
        fslist.add(new Bunga(getString(R.string.kembang_sepatu), getString(R.string.kembang_sepatu_detail), getString(R.string.kembang_sepatu_latin), R.drawable.kembang_sepatu));
        fslist.add(new Bunga(getString(R.string.melati), getString(R.string.melati_detail), getString(R.string.melati_latin), R.drawable.melati));
        fslist.add(new Bunga(getString(R.string.aster), getString(R.string.aster_detail), getString(R.string.aster_latin), R.drawable.aster));
        fslist.add(new Bunga(getString(R.string.kateliya), getString(R.string.kateliya_detail), getString(R.string.kateliya_latin), R.drawable.kateliya));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_staggered, container, false);
        sfrecyclerView = (RecyclerView) v.findViewById(R.id.fstaggered);
        StaggeredBungaAdapter staggeredBungaAdapter = new StaggeredBungaAdapter(getContext(), fslist);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        sfrecyclerView.setLayoutManager(staggeredGridLayoutManager);
        sfrecyclerView.setAdapter(staggeredBungaAdapter);
        return v;
    }
}