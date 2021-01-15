package com.example.fleur;

public class Toko {
    private String Name,Description;
    private int Photo;

    public Toko(){}

    public Toko(String name, String description, int Photo) {
        Name = name;
        Description = description;
        this.Photo = Photo;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setPhoto(int Photo) {
        this.Photo = Photo;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public int getPhoto() {

        return Photo;
    }

}

