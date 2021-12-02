package day04;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @Test
    void find() {
        FileReader fileReader = new FileReader();
        int i = fileReader.findSmallestTemperatureSpread(Paths.get("src/main/resources/weather.dat"));
        System.out.println(i);
    }

}