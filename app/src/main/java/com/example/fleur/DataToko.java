package com.example.fleur;

import java.util.ArrayList;

public class DataToko {
    public static int[][] data = new int[][]{
            {R.string.adisty_florist, R.string.adisty_florist_detail,R.drawable.toko_logo},
            {R.string.and_florist, R.string.and_florist_detail, R.drawable.toko_logo},
            {R.string.adm_florist, R.string.adm_florist_detail,R.drawable.toko_logo},
            {R.string.ays_florist, R.string.ays_florist_detail,R.drawable.toko_logo},
            {R.string.black_rose_florist, R.string.black_rose_florist_detail,R.drawable.toko_logo},
            {R.string.distin_florist, R.string.distin_florist_detail,R.drawable.toko_logo},
            {R.string.els_florist, R.string.els_florist_detail,R.drawable.toko_logo},
            {R.string.fleur_tales, R.string.fleur_tales_detail,R.drawable.toko_logo},

    };

    public static ArrayList<Toko> getListData(){
        ArrayList<Toko> list = new ArrayList<>();
        for (int[] aData : data) {
            Toko toko = new Toko();
            toko.setName(aData[0]);
            toko.setFrom(aData[1]);
            toko.setPhoto(aData[2]);
            list.add(toko);
        }
        return list;
    }
}
