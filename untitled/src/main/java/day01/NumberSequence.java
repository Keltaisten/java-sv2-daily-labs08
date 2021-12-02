package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NumberSequence {
    private List<Integer> numbers;

    public NumberSequence(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public NumberSequence(int count, int minValue, int maxValue) {
        this.numbers = makeRandomNumbersForConstructor(count,minValue,maxValue);
    }

    private List<Integer> makeRandomNumbersForConstructor(int count, int minValue, int maxValue){
        List<Integer> randomNumberList = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i < count;i++){
            randomNumberList.add(rand.nextInt(minValue,maxValue + 1));
        }
        return randomNumberList;
    }

    public List<Integer> closeToAverage(int value){
        List<Integer> filteredListNumbers = new ArrayList<>();
        double averageNumber = average();
        for(int i: numbers){
            if(Math.abs(i - value) <= averageNumber + 0.000001d){
                filteredListNumbers.add(i);
            }
        }
        return filteredListNumbers;
    }

    private double average() {
        double sum = 0;
        for(Integer i: numbers){
            sum += i;
        }
        return sum/numbers.size();
    }
    
}
