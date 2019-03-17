package com.api.resources.services;

import com.api.resources.entities.Spot;
import com.api.resources.repositories.SpotRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class SpotService implements ISpotService {

    @Autowired
    SpotRepository spotRepository;


    public SpotService(SpotRepository spotRepository) throws IOException {
        super();
        this.spotRepository = spotRepository;

        /**
         *  If is instantiated, the spot service will load data automatically from CSV file
         *  and if i want to change something at the api, is more simpler to change the CSV
         */

        String csvData = "C:\\Users\\Electron\\Desktop\\kitesurfingAPI\\RestfulAPI\\src\\main\\resources\\data.csv";
        FileReader fileReader = new FileReader(csvData);
        CSVParser parser = new CSVParser(fileReader,
                CSVFormat.DEFAULT);
        List<CSVRecord> records = parser.getRecords();
        for (int i = 0; i < records.size(); i++) {
            String[] details = records.get(i).get(0).split(";");
                        Spot spot = new Spot(details[0], // name
                                Double.parseDouble(details[1]), // longitude
                                Double.parseDouble(details[2]), // latitude
                                Integer.parseInt(details[3]), // windProbability
                                details[4], // country
                                details[5]); // whenToGo
            spotRepository.save(spot);
        }

        parser.close();
    }

    @Override
    public List<Spot> findAll() {
        return (List<Spot>) spotRepository.findAll();
    }

    @Override
    public List<Spot> findAllFavorites() {
        List<Spot> spots = findAll();
        List<Spot> favorites = new ArrayList<>();
        for (Spot spot : spots) {
            if (spot.isFavorite() == true){
                favorites.add(spot);
            }
        }

        return favorites;
    }

    @Override
    public List<String> findAllCountries() {
        List<String> countries = new ArrayList<>();
        List<Spot> spots = findAll();
        for (Spot spot : spots) {
            countries.add(spot.getCountry());
        }

        return countries;
    }

    @Override
    public List<Integer> findAllWindProbability() {
        List<Integer> windProbabilities = new ArrayList<>();
        List<Spot> spots = findAll();
        for (Spot spot : spots) {
            windProbabilities.add(spot.getWindProbability());
        }

        return windProbabilities;
    }

    @Override
    public void addToFavorite(Integer id) {
        List<Spot> spots = findAll();
        Spot newInstance = spots.get(id);
        newInstance.setFavorite(true);
        spotRepository.save(newInstance); // making an update
    }

    @Override
    public void deleteFromFavorites(Integer id) {
        List<Spot> spots = findAll();
        Spot newInstance = spots.get(id);
        newInstance.setFavorite(false);
        spotRepository.save(newInstance); // making an update
    }

    @Override
    public Spot findById(Integer id) {
        return spotRepository.findById(id).get();
    }
}
