package com.example.trouvaille.Models;

public class CityItem {

    private int imageResourse1;
    private String title1;
    private String provincename;
    private String key_id1;
    private String population;
    private String citydesc;
    private String airport;

    //constructor
    public CityItem() {
    }



    public CityItem(int imageResourse1, String title1, String provincename, String key_id1, String population, String citydesc, String airport) {
        this.imageResourse1 = imageResourse1;
        this.title1 = title1;
        this.provincename = provincename;
        this.key_id1 = key_id1;
        this.population = population;
        this.citydesc = citydesc;
        this.airport = airport;
    }

    public int getImageResourse1() {
        return imageResourse1;
    }

    public void setImageResourse1(int imageResourse1) {
        this.imageResourse1 = imageResourse1;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

    public String getKey_id1() {
        return key_id1;
    }

    public void setKey_id1(String key_id1) {
        this.key_id1 = key_id1;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getCitydesc() {
        return citydesc;
    }

    public void setCitydesc(String citydesc) {
        this.citydesc = citydesc;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

}

