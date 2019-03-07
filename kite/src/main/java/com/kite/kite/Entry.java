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

    public Entry(){

    }

    public Integer getId() {
        return id;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public String getName() {
        return name;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
