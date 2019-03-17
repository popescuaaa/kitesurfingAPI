package com.api.resources.services;

import com.api.resources.entities.Spot;

import java.util.List;

public interface ISpotService {
    List<Spot> findAll();
    List<Spot> findAllFavorites();
    List<String> findAllCountries();
    List<Integer> findAllWindProbability();
    void addToFavorite(Integer id);
    void deleteFromFavorites(Integer id);
    Spot findById(Integer id);


}
