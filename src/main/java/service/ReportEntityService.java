package service;

import model.ReportEntity;


public class ReportEntityService {

    private final ItemService itemService;
    private ReportEntity reportEntity;


    public ReportEntityService(ItemService itemService) {
        this.itemService = itemService;
        this.reportEntity = new ReportEntity();
    }

    public ReportEntity getReportEntity() {
        return reportEntity;
    }

    private void setNameOfItemToEntity() {
        this.reportEntity.nameOfItem = CustomerService.chooseNameOfItemToEntity();
    }

    private void setSupplyToEntity() {
        this.reportEntity.setSumOfSupply(itemService.getSumOfSupply());
    }

    private void setBuyToEntity() {
        this.reportEntity.setSumOfBuy(itemService.getSumOfBuy());
    }

    private void setResultToEntity() {
        this.reportEntity.setResult(itemService.getResult());
    }

    public void runServiceOfEntity(){
        setNameOfItemToEntity();
        setSupplyToEntity();
        setBuyToEntity();
        setResultToEntity();
    }
}
