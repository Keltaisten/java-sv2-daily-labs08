package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private List<Days> dayList = new ArrayList<>();
    private List<Football> teamlList = new ArrayList<>();
    private List<Data> dataList = new ArrayList<>();

    private List<String> readTheFiles(Path path){
        List<String> readList;
        try {
            readList = Files.readAllLines(path);
        }catch (IOException ioe){
            throw new IllegalStateException("File not fount");
        }
        return readList;
    }

    public int findSmallestTemperatureSpread(Path path){
        loopOnTheList(readTheFiles(path));
        return checkTheMinimumSpread();
    }

    private int checkTheMinimumSpread() {
        int minDay = 0;
        int temp = 1_000;
        for(Days d: dayList){
            if(checkTheMinimumDiff(d.getMaxTemp(),d.getMinTemp(),temp)){
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
        loopOnTheFootballList(readTheFiles(path));
        return checkTheMinimumSpreadForFootball();
    }

    private void loopOnTheFootballList(List<String> footballList) {
        for(int i = 1; i < footballList.size(); i++){
            if(!footballList.get(i).substring(8,9).equals("-")){
            String teamName = footballList.get(i).substring(7,23).trim();
            int maxTemp = Integer.parseInt(footballList.get(i).substring(43,45));
            int minTemp = Integer.parseInt(footballList.get(i).substring(50,52));
            Football football = new Football(teamName,maxTemp,minTemp);
            teamlList.add(football);
            }
        }
    }

    private boolean checkTheMinimumDiff(int max, int min, int diff){
        return (Math.abs(max - min) < diff);
    }

    private String checkTheMinimumSpreadForFootball() {
        String teamName = "";
        int diff = 1_000;
        for(Football f: teamlList){
            if(checkTheMinimumDiff(f.getMax(),f.getMin(),diff)){
                diff = Math.abs(f.getMax() - f.getMin());
                teamName = f.getFootballTeamName();
            }
        }
        return teamName;
    }
}
