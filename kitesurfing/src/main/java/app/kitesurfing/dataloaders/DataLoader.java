package app.kitesurfing.dataloaders;

import app.kitesurfing.repositories.SpotsRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "spots.db", havingValue = "true")
public class DataLoader implements CommandLineRunner {
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private final String csvData = "C:\\Users\\Electron\\Desktop\\kitesurfingAPI\\kitesurfing\\src\\main\\resources\\spots.csv";
    private ArrayList<String> spotDetailsArray = new ArrayList<>(100);
    private SpotsRepository repository;
    private Logger logger = LoggerFactory.getLogger(DataLoader.class);

    public DataLoader(SpotsRepository spotsRepository){
        this.repository = spotsRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("ldakjaskdlkas--------------------------------->");
    }
}
