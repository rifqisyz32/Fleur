package com.example.fleur;

import android.widget.Button;

import java.util.ArrayList;

public class DataBunga {
    public static int[][] data = new int[][]{
        {R.string.anggrek, R.string.anggrek_detail, R.drawable.anggrek},
        {R.string.anyelir_putih, R.string.anyelir_putih_detail,R.drawable.anyelir_putih},
        {R.string.anyelir_kuning, R.string.anyelir_kuning_detail,R.drawable.anyelir_kuning},
        {R.string.anyelir_merah, R.string.anyelir_merah_detail,R.drawable.anyelir_merah},
        {R.string.anyelir_pink, R.string.anyelir_pink_detail,R.drawable.anyelir_pink},
        {R.string.anyelir_ungu, R.string.anyelir_ungu_detail,R.drawable.anyelir_ungu},
        {R.string.daisy_putih, R.string.daisy_putih_detail,R.drawable.daisy_putih},
        {R.string.daisy_kuning, R.string.daisy_kuning_detail,R.drawable.daisy_kuning},
        {R.string.daisy_ungu, R.string.daisy_ungu_detail,R.drawable.daisy_ungu},
        {R.string.daisy_merah, R.string.daisy_merah_detail,R.drawable.daisy_merah},
        {R.string.daisy_pink, R.string.daisy_pink_detail,R.drawable.daisy_pink},
        {R.string.daisy_orange, R.string.daisy_orange_detail,R.drawable.daisy_orange},
        {R.string.herbras, R.string.herbras_detail, R.drawable.herbras}
         };

    public static ArrayList<Bunga> getListData(){
        ArrayList<Bunga> list = new ArrayList<>();
        for (int[] aData : data) {
            Bunga bunga = new Bunga();
            bunga.setName(aData[0]);
            bunga.setFrom(aData[1]);
            bunga.setPhoto(aData[2]);
            list.add(bunga);
        }
        return list;
    }
}
