package csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import model.Item;
import model.Record;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVReader {

    public static Item readFile(String path) {

        Item item = new Item();
        List<Record> records = null;

        try {
            FileReader fileReader = new FileReader(path);
            CSVReader csvReader = new com.opencsv.CSVReader(fileReader);
            String[] line;
            records = new ArrayList<>();
            while ((line = csvReader.readNext()) != null) {
                Record t = new Record(line[0], Integer.valueOf(line[1]));
                records.add(t);
            }
        } catch (IOException | CsvValidationException | NumberFormatException ex) {
            //ex.printStackTrace();
            System.out.println("Check the delivered file! Data recording is invalid!");
        }
        item.setRecords(records);
        return item;
    }
}