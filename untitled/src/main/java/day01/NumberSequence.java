package day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberSequence {
    private List<Integer> numbers;

    public NumberSequence(List<Integer> numbers) {
        this.numbers = Arrays.asList(1,2,3,4,5);
        this.numbers = Arrays.asList(6,7,8,9,10);
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
