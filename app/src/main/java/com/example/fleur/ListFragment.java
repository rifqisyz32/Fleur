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

public class ListFragment extends Fragment {

    View v;
    private RecyclerView lfrecyclerView;
    private List<Bunga> flist;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        flist = new ArrayList<>();
        flist.add(new Bunga(getString(R.string.anggrek), getString(R.string.anggrek_detail), getString(R.string.anggrek_latin), R.drawable.anggrek));
        flist.add(new Bunga(getString(R.string.anyelir_kuning), getString(R.string.anyelir_kuning_detail), getString(R.string.anyelir_kuning_latin), R.drawable.anyelir_kuning));
        flist.add(new Bunga(getString(R.string.anyelir_merah), getString(R.string.anyelir_merah_detail), getString(R.string.anyelir_merah_latin), R.drawable.anyelir_merah));
        flist.add(new Bunga(getString(R.string.anyelir_pink), getString(R.string.anyelir_pink_detail), getString(R.string.anyelir_pink_latin), R.drawable.anyelir_pink));
        flist.add(new Bunga(getString(R.string.anyelir_putih), getString(R.string.anyelir_putih_detail), getString(R.string.anyelir_putih_latin), R.drawable.anyelir_putih));
        flist.add(new Bunga(getString(R.string.anyelir_ungu), getString(R.string.anyelir_ungu_detail), getString(R.string.anyelir_ungu_latin), R.drawable.anyelir_ungu));
        flist.add(new Bunga(getString(R.string.daisy_kuning), getString(R.string.daisy_kuning_detail), getString(R.string.daisy_kuning_latin), R.drawable.daisy_kuning));
        flist.add(new Bunga(getString(R.string.daisy_merah), getString(R.string.daisy_merah_detail), getString(R.string.daisy_merah_latin), R.drawable.daisy_merah));
        flist.add(new Bunga(getString(R.string.daisy_pink), getString(R.string.daisy_pink_detail), getString(R.string.daisy_pink_latin), R.drawable.daisy_pink));
        flist.add(new Bunga(getString(R.string.daisy_orange), getString(R.string.daisy_orange_detail), getString(R.string.daisy_orange_latin), R.drawable.daisy_orange));
        flist.add(new Bunga(getString(R.string.daisy_ungu), getString(R.string.daisy_ungu_detail), getString(R.string.daisy_ungu_latin), R.drawable.daisy_ungu));
        flist.add(new Bunga(getString(R.string.daisy_putih), getString(R.string.daisy_putih_detail), getString(R.string.daisy_putih_latin), R.drawable.daisy_putih));
        flist.add(new Bunga(getString(R.string.herbras), getString(R.string.herbras_detail), getString(R.string.herbras_latin), R.drawable.herbras));
        flist.add(new Bunga(getString(R.string.mawar), getString(R.string.mawar_detail), getString(R.string.mawar_latin), R.drawable.mawar));
        flist.add(new Bunga(getString(R.string.tulip), getString(R.string.tulip_detail), getString(R.string.tulip_latin), R.drawable.tulip));
        flist.add(new Bunga(getString(R.string.teratai), getString(R.string.teratai_detail), getString(R.string.teratai_latin), R.drawable.teratai));
        flist.add(new Bunga(getString(R.string.kembang_sepatu), getString(R.string.kembang_sepatu_detail), getString(R.string.kembang_sepatu_latin), R.drawable.kembang_sepatu));
        flist.add(new Bunga(getString(R.string.melati), getString(R.string.melati_detail), getString(R.string.melati_latin), R.drawable.melati));
        flist.add(new Bunga(getString(R.string.aster), getString(R.string.aster_detail), getString(R.string.aster_latin), R.drawable.aster));
        flist.add(new Bunga(getString(R.string.kateliya), getString(R.string.kateliya_detail), getString(R.string.kateliya_latin), R.drawable.kateliya));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_list, container, false);
        lfrecyclerView = (RecyclerView) v.findViewById(R.id.flist);
        ListTabAdapter listTabAdapter = new ListTabAdapter(getContext(), flist);
        lfrecyclerView.setLayoutManager((new LinearLayoutManager(getActivity())));
        lfrecyclerView.setAdapter(listTabAdapter);
        return v;
    }
}

    /*View v;
    private RecyclerView lfrecyclerView;
    private List<Bunga> flist;



    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flist = new ArrayList<>();
        flist.add(new Bunga(getString(R.string.anggrek), getString(R.string.anggrek_detail), getString(R.string.anggrek_latin), R.drawable.anggrek));
        flist.add(new Bunga(getString(R.string.anyelir_kuning), getString(R.string.anyelir_kuning_detail), getString(R.string.anggrek_latin), R.drawable.anyelir_kuning));
        flist.add(new Bunga(getString(R.string.anyelir_merah), getString(R.string.anyelir_merah_detail), getString(R.string.anggrek_latin), R.drawable.anyelir_merah));
        flist.add(new Bunga(getString(R.string.anyelir_pink), getString(R.string.anyelir_pink_detail), getString(R.string.anggrek_latin), R.drawable.anyelir_pink));
        flist.add(new Bunga(getString(R.string.anyelir_putih), getString(R.string.anyelir_putih_detail), getString(R.string.anggrek_latin), R.drawable.anyelir_putih));
        flist.add(new Bunga(getString(R.string.anyelir_ungu), getString(R.string.anyelir_ungu_detail), getString(R.string.anggrek_latin), R.drawable.anyelir_ungu));
        flist.add(new Bunga(getString(R.string.daisy_kuning), getString(R.string.daisy_kuning_detail), getString(R.string.anggrek_latin), R.drawable.daisy_kuning));
        flist.add(new Bunga(getString(R.string.daisy_merah), getString(R.string.daisy_merah_detail), getString(R.string.anggrek_latin), R.drawable.daisy_merah));
        flist.add(new Bunga(getString(R.string.daisy_pink), getString(R.string.daisy_pink_detail), getString(R.string.anggrek_latin), R.drawable.daisy_pink));
        flist.add(new Bunga(getString(R.string.daisy_orange), getString(R.string.daisy_orange_detail), getString(R.string.anggrek_latin), R.drawable.daisy_orange));
        flist.add(new Bunga(getString(R.string.daisy_ungu), getString(R.string.daisy_ungu_detail), getString(R.string.anggrek_latin), R.drawable.daisy_ungu));
        flist.add(new Bunga(getString(R.string.daisy_putih), getString(R.string.daisy_putih_detail), getString(R.string.anggrek_latin), R.drawable.daisy_putih));
        flist.add(new Bunga(getString(R.string.herbras), getString(R.string.herbras_detail), getString(R.string.anggrek_latin), R.drawable.herbras));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_staggered, container, false);
        lfrecyclerView = (RecyclerView) v.findViewById(R.id.rv_staggered);
        StaggeredBungaAdapter recyclerViewAdapter = new StaggeredBungaAdapter(getContext(),flist);
        lfrecyclerView.setLayoutManager((new LinearLayoutManager(getActivity())));
        lfrecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }*/
