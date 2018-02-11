package education.skool.nsit.skool.Models;

public class CheckboxModel {

    public CheckboxModel(String name, int value) {
        this.name = name;
        this.value = value;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    int value;




}
