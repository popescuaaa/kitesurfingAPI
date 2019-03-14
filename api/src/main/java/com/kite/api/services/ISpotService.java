package com.kite.api.services;

import com.kite.api.entities.*;
import java.util.List;

public interface ISpotService {
    List<Spot> findAll();
    List<String> findAllCountries();
    Boolean addNewSpotToFavourites(Spot spot);
    Boolean deleteFromFavourites(Integer id);
    List<Spot> findFavouritesSpots();
}
