package service;

import model.Item;
import model.Record;

import java.util.List;

public class ItemService {

    private final Item item;

    private Integer sumOfSupply = 0;
    private Integer sumOfBuy = 0;
    private Integer result;

    public ItemService(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public Integer getSumOfSupply() {
        return sumOfSupply;
    }

    private void setSumOfSupply(Item item) {
        try {
            List<Record> listOfRecords = item.getRecords();
            int sum = 0;
            for (Record t : listOfRecords) {
                if (t.getType().equals("supply")) {
                    sum += t.getValue();
                }
            }
            this.sumOfSupply = sum;
        } catch (NullPointerException ex) {
            System.out.println("List of records is null!");
        }

    }

    public Integer getSumOfBuy() {
        return sumOfBuy;
    }

    private void setSumOfBuy(Item item) {
        try {
            List<Record> listOfRecords = item.getRecords();
            int sum = 0;
            for (Record t : listOfRecords) {
                if (t.getType().equals("buy")) {
                    sum += t.getValue();
                }
            }
            this.sumOfBuy = sum;
        } catch (NullPointerException ex) {
            System.out.println("List of records is null!");
        }
    }

    public Integer getResult() {
        return result;
    }

    private void setResult() {
        int x = sumOfSupply;
        int y = sumOfBuy;
        this.result = x - y;
    }

    public void runBalance() {
        setSumOfSupply(item);
        setSumOfBuy(item);
        setResult();
    }


}
