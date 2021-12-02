package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    List<Days> dayList = new ArrayList<>();

    public int findSmallestTemperatureSpread(Path path){
        List<String> strings = new ArrayList<>();
        try {
            strings = Files.readAllLines(path);
        }catch (IOException ioe){
            throw new IllegalStateException("File not fount");
        }

        loopOnTheList(strings);
        int i = checkTheMinimumSpread();
        return i;
    }

    private int checkTheMinimumSpread() {
        int minDay = 1_000;
        int temp = 1_000;
        for(Days d: dayList){
            if(d.getMaxTemp() - d.getMinTemp() < temp){
                temp = d.getMaxTemp() - d.getMinTemp();
                minDay = d.getDay();

            }
        }
        return minDay;
    }

    private void loopOnTheList(List<String> strings) {
        for(int i = 2; i < strings.size() - 2; i++){
            int day = Integer.parseInt(strings.get(i).substring(2,4).trim());
            int maxTemp = Integer.parseInt(strings.get(i).substring(6,8));
            int minTemp = Integer.parseInt(strings.get(i).substring(12,14));
            Days days = new Days(day,maxTemp,minTemp);
            addToTheList(days);
        }
    }

    private void addToTheList(Days days) {
        dayList.add(days);
    }
}
