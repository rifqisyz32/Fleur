package com.example.fleur;

public class Bunga {

    private String Name,Description,Latin;
    private int Photo;

    public Bunga(){}

    public Bunga(String name, String description, String latin, int Photo) {
        Name = name;
        Description = description;
        Latin = latin;
        this.Photo = Photo;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setLatin(String latin) {
        Latin = latin;
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

    public String getLatin() {

        return Latin;
    }

    public int getPhoto() {

        return Photo;
    }

}
