package arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
A wire connects N light bulbs.
Each bulb has a switch associated with it; however, due to faulty wiring, a switch also changes the state of all the bulbs to the right of the current bulb.
Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
You can press the same switch multiple times.
Note: 0 represents the bulb is off and 1 represents the bulb is on.
 */
public class MinimumSwitches {
    public int bulbs(ArrayList<Integer> A) {
        int n = A.size();
        int zeros = countZero(A);
        int result = 0;
        int i=0;
        int checkVal = 0;
        while(zeros > 0) {
            if(A.get(i) == checkVal) {
                result++;
                zeros = (n-zeros) - i;
                checkVal = checkVal ^ 1;
            }
            i++;
        }
        return result;
    }

    private int countZero(ArrayList<Integer> A) {
        int count = 0;
        for(int i:A) {
            if(i == 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumSwitches obj = new MinimumSwitches();
        System.out.println(obj.bulbs(new ArrayList<>(Arrays.asList(0, 1, 0, 1)))); // 4
        System.out.println(obj.bulbs(new ArrayList<>(Arrays.asList(1, 1, 1, 1)))); // 0
    }
}
