package day04;

public class Data {
    private String name;
    private int max;
    private int min;
    private int number;

    public Data(String footballTeamName, int max, int min) {
        this.name = footballTeamName;
        this.max = max;
        this.min = min;
    }

    public Data(int number, int max, int min) {
        this.number = number;
        this.max = max;
        this.min = min;
    }

    public Data() {
    }

    public String getName() {
        return name;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
