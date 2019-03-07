package com.kite.kite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer latitude;
  //  private Integer longitude;
   // private Double windProbability;
  //  private String country;
  //  private String whenToGo;

    public Entry(final String name, final Integer latitude, final Integer longitude,
                 final Double windProbability, final String country, final String whenToGo){
       //this.country = country;
        this.latitude = latitude;
        this.name = name;
        //this.longitude = longitude;
      //  this.whenToGo =  whenToGo;
       // this.windProbability = windProbability;
    }
//    public Double getWindProbability() {
//        return windProbability;
//    }

    public Integer getLatitude() {
        return latitude;
    }

//    public Integer getLongitude() {
//        return longitude;
//    }

    public String getName() {
        return name;
    }

//    public String getCountry() {
//        return country;
//    }

}
