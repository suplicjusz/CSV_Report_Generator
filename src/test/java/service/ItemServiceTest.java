package service;

import model.Item;
import model.Record;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ItemServiceTest {

    @Test
    void shouldRunBalance() {
        //GIVEN
        Record record1 = new Record("supply", 120);
        Record record2 = new Record("buy", 30);
        Record record3 = new Record("supply", 10);
        List<Record> given = new ArrayList<>();
        given.add(record1);
        given.add(record2);
        given.add(record3);
        Item item = new Item();
        item.setRecords(given);
        ItemService itemService = new ItemService(item);
        //WHEN
        itemService.runBalance();
        //THEN
        int sumOfSupply = itemService.getSumOfSupply();
        Assertions.assertEquals(130, sumOfSupply);
        int sumOfBuy = itemService.getSumOfBuy();
        Assertions.assertEquals(30, sumOfBuy);
        int result = itemService.getResult();
        Assertions.assertEquals(100, result);

    }
}