package com.example.fleur;

import java.util.ArrayList;

public class DataToko {
    public static String[][] data = new String[][]{
            {"Adisty Florist", "Way Kandis, No telp 081278813326","https://www.iconpacks.net/icons/2/free-store-icon-2017-thumb.png"},
            {"And Florist", "Jl. Purnawirawan Raya No.10, Labuhan Ratu, Langkapura, Kota Bandar Lampung, Lampung 35113, No telp 088276634282", "https://www.iconpacks.net/icons/2/free-store-icon-2017-thumb.png"},
            {"Adm Florist", "Jl. Nusantara, Labuhan Ratu, Kec. Kedaton, Kota Bandar Lampung, Lampung 35132, No telp 081271975782","https://www.iconpacks.net/icons/2/free-store-icon-2017-thumb.png"},
            {"Ays Florist", "Jl. Bumi Manti II No.1, Kp. Baru, Kec. Kedaton, Kota Bandar Lampung, Lampung 35141, No telp 081540870565","https://www.iconpacks.net/icons/2/free-store-icon-2017-thumb.png"},
            {"BalckRose Florist", "Jl. Purnawirawan Raya No.97, Gn. Terang, Langkapura, Kota Bandar Lampung, Lampung 35113, No telp 0816342780","https://www.iconpacks.net/icons/2/free-store-icon-2017-thumb.png"},
            {"Distin Florist", "Jl. Purnawirawan II No.21, Gn. Terang, Langkapura, Kota Bandar Lampung, Lampung 35112, No telp 085279183255","https://www.iconpacks.net/icons/2/free-store-icon-2017-thumb.png"},
            {"Els Florist", "Jl Labuhan Ratu, Bandar Lampung, No telp 088706451533","https://www.iconpacks.net/icons/2/free-store-icon-2017-thumb.png"},
            {"Fleur Tales", "Jl. Cendana 4, Kedamaian, Kota Bandar Lampung, Lampung 35122, No telp 085106588185","https://www.iconpacks.net/icons/2/free-store-icon-2017-thumb.png"},

    };

    public static ArrayList<Toko> getListData(){
        ArrayList<Toko> list = new ArrayList<>();
        for (String[] aData : data) {
            Toko toko = new Toko();
            toko.setName(aData[0]);
            toko.setFrom(aData[1]);
            toko.setPhoto(aData[2]);
            list.add(toko);
        }
        return list;
    }
}
