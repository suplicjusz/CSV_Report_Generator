package model;

import javax.persistence.*;

@Entity
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    public Long id;

    @Column(name = "NAME_OF_ITEM")
    public String nameOfItem;

    @Column(name = "SUM_OF_SUPPLY")
    private Integer sumOfSupply;

    @Column(name = "SUM_OF_BUY")
    private Integer sumOfBuy;

    @Column(name = "RESULT")
    private Integer result;

    public String getNameOfItem() {
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public Integer getSumOfSupply() {
        return sumOfSupply;
    }

    public void setSumOfSupply(Integer sumOfSupply) {
        this.sumOfSupply = sumOfSupply;
    }

    public Integer getSumOfBuy() {
        return sumOfBuy;
    }

    public void setSumOfBuy(Integer sumOfBuy) {
        this.sumOfBuy = sumOfBuy;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
