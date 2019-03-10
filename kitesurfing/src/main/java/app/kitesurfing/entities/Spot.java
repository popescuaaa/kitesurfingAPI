package app.kitesurfing.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String spotName;
    private Double latitude;
    private Double longitude;
    private String spotCountry;
    private String spotTime;
    private Double spotWindProb;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
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

    public String getSpotCountry() {
        return spotCountry;
    }

    public void setSpotCountry(String spotCountry) {
        this.spotCountry = spotCountry;
    }

    public String getSpotTime() {
        return spotTime;
    }

    public void setSpotTime(String spotTime) {
        this.spotTime = spotTime;
    }

    public Double getSpotWindProb() {
        return spotWindProb;
    }

    public void setSpotWindProb(Double spotWindProb) {
        this.spotWindProb = spotWindProb;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "id=" + id +
                ", spotName='" + spotName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", spotCountry='" + spotCountry + '\'' +
                ", spotTime='" + spotTime + '\'' +
                ", spotWindProb=" + spotWindProb +
                '}';
    }

    public Spot(String spotName, Double latitude, Double longitude, String spotCountry, String spotTime, Double spotWindProb) {
        this.spotName = spotName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.spotCountry = spotCountry;
        this.spotTime = spotTime;
        this.spotWindProb = spotWindProb;
    }

    public Spot() {

    }
}
