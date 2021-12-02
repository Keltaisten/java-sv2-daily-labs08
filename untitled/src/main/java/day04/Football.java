package day04;

public class Football {
    private String footballTeamName;
    private int max;
    private int min;

    public Football(String footballTeamName, int max, int min) {
        this.footballTeamName = footballTeamName;
        this.max = max;
        this.min = min;
    }

    public String getFootballTeamName() {
        return footballTeamName;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}
