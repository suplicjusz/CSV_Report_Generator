package service;

import csv.OpenCSVReader;
import csv.OpenCSVWriter;

public class ReportGenerator {

    public static ItemService itemService;

    public static void generateReport(String path) {

        itemService = new ItemService(OpenCSVReader.readFile(path));
        itemService.runBalance();
        System.out.println("Supply: " + itemService.getSumOfSupply());
        System.out.println("Buy: " + itemService.getSumOfBuy());
        System.out.println("Result: " + itemService.getResult());
    }

    public static void saveToCsvFile() {
        OpenCSVWriter.saveFile(CustomerService.chooseOutputPath(), itemService);
    }

}
