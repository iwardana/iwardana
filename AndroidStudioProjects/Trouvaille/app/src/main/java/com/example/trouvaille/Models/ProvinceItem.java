package com.example.trouvaille.Models;

public class ProvinceItem {

    private int imageResourse;
    private String title;
    private String key_id;
    private String favStatus;
    private String provincedesc;
    private String capital;
    private String other;

    //constructor
    public ProvinceItem() {
    }

    public ProvinceItem(int imageResourse, String title, String key_id, String favStatus, String provincedesc, String capital, String other) {
        this.imageResourse = imageResourse;
        this.title = title;
        this.key_id = key_id;
        this.favStatus = favStatus;
        this.provincedesc =provincedesc;
        this.capital=capital;
        this.other=other;
    }

    public int getImageResourse() {
        return imageResourse;
    }

    public void setImageResourse(int imageResourse) {
        this.imageResourse = imageResourse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getFavStatus() {
        return favStatus;
    }

    public void setFavStatus(String favStatus) {
        this.favStatus = favStatus;
    }

    public String getProvincedesc() {
        return provincedesc;
    }

    public void setProvincedesc(String provincedesc) {
        this.provincedesc = provincedesc;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
