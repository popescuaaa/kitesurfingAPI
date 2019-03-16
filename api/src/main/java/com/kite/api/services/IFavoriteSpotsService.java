package com.kite.api.services;

import com.kite.api.entities.Spot;
import org.json.JSONException;

import java.util.List;

public interface IFavoriteSpotsService {
    List<Spot> findAll();
    String addSpot(Integer id) throws JSONException; // favorites from the local DB
    String deleteSpot(Integer id) throws JSONException;
}
