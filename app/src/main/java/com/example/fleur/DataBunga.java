package com.example.fleur;

import android.widget.Button;

import java.util.ArrayList;

public class DataBunga {
    public static String[][] data = new String[][]{
            {"Anggrek", "Bunga anggrek dianggap romantis karena bunga ini melambangkan kecantikan, cinta, dan dapat menarik hati.","https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Orchid_high_resolution.jpg/1024px-Orchid_high_resolution.jpg"},
            {"Anyelir Putih", "Bunga anyelir putih menyimbolkan rasa syukur, cinta yang murni, kesetiaan, dan cinta yang menggebu dan mendalam.","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Dianthus_caryophyllus_%27Jeanne_Dionis%27%2C_Elfenau.jpg/800px-Dianthus_caryophyllus_%27Jeanne_Dionis%27%2C_Elfenau.jpg"},
            {"Anyelir Kuning", "Bunga anyelir kuning merupakan lambang penolakan, emosi, benci, sekaligus kecewa terhadap seseorang.","https://upload.wikimedia.org/wikipedia/commons/thumb/9/97/Dianthus_caryophullus_kz1.JPG/1024px-Dianthus_caryophullus_kz1.JPG"},
            {"Anyelir Merah", "Bunga anyelir merah diartikan sebagai bentuk kekagumana dan persahabatan.","https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/W_carnation4051.jpg/330px-W_carnation4051.jpg"},
            {"Anyelir Pink", "Bunga anyelir pink dikaitkan dengan cinta abadi seorang ibu dan kaum wanita.","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/Dianthus_caryophyllus_var_schabaud.jpg/135px-Dianthus_caryophyllus_var_schabaud.jpg"},
            {"Anyelir Ungu", "Bunga anyelir ungu dikaitkan dengan duka cita dan kreativitas, tetapi selain itu bunga ini melambangkan ketidakteraturan yang dimaksudkan kamu memiliki kemampuan untuk berubah sesuai dengan keinginannya.","https://upload.wikimedia.org/wikipedia/commons/thumb/6/6d/Moondust-carnation.JPG/1024px-Moondust-carnation.JPG"},
            {"Daisy Putih", "Bunga daisy putih melambangkan sebuah kesetiaan dan kepolosan bisa kamu pilih jika orang yang akan kamu beri rangkaian bunga ini adalah orang yang lemah lembut dan kalem.","https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Leucanthemum_vulgare_%27Filigran%27_Flower_2200px.jpg/330px-Leucanthemum_vulgare_%27Filigran%27_Flower_2200px.jpg"},
            {"Daisy Kuning", "Bunga daisy kuning mungkin akan mewakilkan perasaan kamu yang sedang senang dan bahagia. Jadi, jika kamu dan orang terkasih sedang merasa senang bisa memberikan bunga daisy dengan warna ini.","https://upload.wikimedia.org/wikipedia/commons/thumb/b/be/Yellow_Daisy.JPG/1053px-Yellow_Daisy.JPG"},
            {"Daisy Ungu", "Bunga daisy ungu memiliki makna kelembutan dan misterius.","https://upload.wikimedia.org/wikipedia/commons/e/e4/Asteraceae_-_Aster_amellus.JPG"},
    {"Daisy Merah", "Bunga daisy merah memiliki makna gairah cinta dengan gairah yang sangat besar. ","https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/Gerber_Daisy3.jpg/800px-Gerber_Daisy3.jpg"},
    {"Daisy Merah Muda", "Bunga daisy merah muda memancarkan aura yang manis karena warna merah muda memang terlihat lembut.","https://upload.wikimedia.org/wikipedia/commons/f/f8/Gerbera_pink.jpg"},
    {"Daisy Orange", "Bunga daisy orange memiliki arti bahagia dan suka cita.","https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/BarbertonDaisy.jpg/1280px-BarbertonDaisy.jpg"},
    {"Herbras", "Bunga herbras melambangkan suatu kecantikan dan bentuk syukur yang Anda sampaikan atas hadirnya seseorang yag Anda anggap penting.", "https://upload.wikimedia.org/wikipedia/commons/4/46/Arctotis.jpg"}
             };

    public static ArrayList<Bunga> getListData(){
        ArrayList<Bunga> list = new ArrayList<>();
        for (String[] aData : data) {
            Bunga bunga = new Bunga();
            bunga.setName(aData[0]);
            bunga.setFrom(aData[1]);
            bunga.setPhoto(aData[2]);
            list.add(bunga);
        }
        return list;
    }
}
