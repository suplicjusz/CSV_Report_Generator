package csv;

import com.opencsv.CSVWriter;
import service.ItemService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OpenCSVWriter {

    public static void saveFile(String path, ItemService itemService) {
        File file = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(file);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            String[] supply = {"supply", itemService.getSumOfSupply().toString()};
            csvWriter.writeNext(supply);
            String[] buy = {"buy", itemService.getSumOfBuy().toString()};
            csvWriter.writeNext(buy);
            String[] result = {"result", itemService.getResult().toString()};
            csvWriter.writeNext(result);
            csvWriter.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println();
        }
    }
}
