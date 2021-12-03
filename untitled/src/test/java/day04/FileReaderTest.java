package day04;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @Test
    void find() {
        FileReader fileReader = new FileReader();
        int minSpread = fileReader.findSmallestTemperatureSpread(Paths.get("src/main/resources/weather.dat"));
        System.out.println(minSpread);
    }

    @Test
    void findTeam() {
        FileReader fileReader = new FileReader();
        String team = fileReader.findSmallestDifference(Paths.get("src/main/resources/football.dat"));
        System.out.println(team);
    }

}