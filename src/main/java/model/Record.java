package model;

public class Record {
    private String type;
    private Integer value;

    public Record(String type, Integer value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public Integer getValue() {
        return value;
    }

}
