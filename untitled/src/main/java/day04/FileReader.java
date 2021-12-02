package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private List<Days> dayList = new ArrayList<>();
    private List<Football> teamlList = new ArrayList<>();

    public int findSmallestTemperatureSpread(Path path){
        List<String> weatherList = new ArrayList<>();
        try {
            weatherList = Files.readAllLines(path);
        }catch (IOException ioe){
            throw new IllegalStateException("File not fount");
        }

        loopOnTheList(weatherList);

        int minimumSpread = checkTheMinimumSpread();
        return minimumSpread;
    }

    private int checkTheMinimumSpread() {
        int minDay = 0;
        int temp = 1_000;
        for(Days d: dayList){
            if(d.getMaxTemp() - d.getMinTemp() < temp){
                temp = d.getMaxTemp() - d.getMinTemp();
                minDay = d.getDay();

            }
        }
        return minDay;
    }

    private void loopOnTheList(List<String> weatherList) {
        for(int i = 2; i < weatherList.size() - 1; i++){
            int day = Integer.parseInt(weatherList.get(i).substring(2,4).trim());
            int maxTemp = Integer.parseInt(weatherList.get(i).substring(6,8));
            int minTemp = Integer.parseInt(weatherList.get(i).substring(12,14));
            Days days = new Days(day,maxTemp,minTemp);
            dayList.add(days);
        }
    }

    public String findSmallestDifference(Path path){
        List<String> footballList = new ArrayList<>();
        try {
            footballList = Files.readAllLines(path);
        }catch (IOException ioe){
            throw new IllegalStateException("File not fount");
        }

        loopOnTheList(footballList);

        String smallestDiff = checkTheMinimumSpreadForFootball();
        return smallestDiff;
    }

    private void loopOnTheFootballList(List<String> footballList) {
        for(int i = 2; i < footballList.size() - 1; i++){
            String teamName = footballList.get(i).substring(8,23).trim();
            int maxTemp = Integer.parseInt(footballList.get(i).substring(6,8));
            int minTemp = Integer.parseInt(footballList.get(i).substring(12,14));
            Football football = new Football(teamName,maxTemp,minTemp);
            teamlList.add(football);
        }
    }

    private String checkTheMinimumSpreadForFootball() {
        String teamName = "";
        int temp = 1_000;
        for(Football f: teamlList){
            if(f.getMax() - f.getMin() < temp){
                temp = f.getMax() - f.getMin();
                teamName = f.getFootballTeamName();
            }
        }
        return teamName;
    }
}
