package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given a constant array A.

You are required to return another array which is the reversed form of the input array.
 */
public class ReverseTheArray {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> solve(final List<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=A.size()-1; i>=0; i--){
            result.add(A.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseTheArray obj = new ReverseTheArray();
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,2,1));
        System.out.println(obj.solve(arr)); // 1,2,3,2,1

        arr = new ArrayList<>(Arrays.asList(1,1,10));
        System.out.println(obj.solve(arr)); // 10,1,1
    }
}
