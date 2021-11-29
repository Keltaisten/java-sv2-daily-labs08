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

    public NumberSequence(int i1, int i2, int i3) {
        this.numbers = makeRandomNumbersForConstructor(i1,i2,i3);
    }

    private List<Integer> makeRandomNumbersForConstructor(int i1, int i2, int i3){
        List<Integer> randomNumberList = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i < i1;i++){
            randomNumberList.add(rand.nextInt(i2,i3));
        }
        return randomNumberList;
    }

    public List<Integer> closeToAverage(int value){
        List<Integer> filteredListNumbers = new ArrayList<>();
        int averageNumber = average();
        for(Integer i: numbers){
            if(i - value < averageNumber){
                filteredListNumbers.add(i);
            }
        }
        return filteredListNumbers;
    }
    
    private int average() {
        int sum = 0;
        for(Integer i: numbers){
            sum += i;
        }
        return sum;
    }
}
