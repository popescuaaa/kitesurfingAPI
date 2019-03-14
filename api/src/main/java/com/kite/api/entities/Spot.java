package com.kite.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Double latitude;
    private Double longitude;
    private Integer windProbability;
    private String country;
    private String whenToGo;

    public Spot(){

    }

    public Spot(String name, Double latitude, Double longitude, Integer windProbability, String country, String whenToGo) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.windProbability = windProbability;
        this.country = country;
        this.whenToGo = whenToGo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getWindProbability() {
        return windProbability;
    }

    public void setWindProbability(Integer windProbability) {
        this.windProbability = windProbability;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWhenToGo() {
        return whenToGo;
    }

    public void setWhenToGo(String whenToGo) {
        this.whenToGo = whenToGo;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", windProbability=" + windProbability +
                ", country='" + country + '\'' +
                ", whenToGo='" + whenToGo + '\'' +
                '}';
    }
}
