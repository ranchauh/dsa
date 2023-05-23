package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Description
 * Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :
 *
 * Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
 * A: For the purpose of this question, YES
 * Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
 * A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 *
 *
 * Problem Constraints
 * 1 <= size of the array <= 1000000
 *
 *
 *
 * Input Format
 * First argument is an array of digits.
 *
 *
 *
 * Output Format
 * Return the array of digits after adding one.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * [1, 2, 3]
 *
 *
 * Example Output
 * Output 1:
 *
 * [1, 2, 4]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Given vector is [1, 2, 3].
 * The returned vector should be [1, 2, 4] as 123 + 1 = 124.
 */
public class AddOneToNumber {
    public static List<Integer> plusOne(List<Integer> A) {
        int carry = 1;
        int n = A.size();
        int num;
        for(int i = n-1; i >= 0; i--) {
            num = A.get(i) + carry;
            carry = 0;
            if(num == 10) {
                num = 0;
                carry = 1;
            }
            A.set(i, num);
        }
        ArrayList<Integer> response = new ArrayList<>();
        if(carry > 0) {
            response.add(carry);
        }
        for (Integer integer : A) {
            if (response.size() == 0 && integer == 0) {
                continue;
            }
            response.add(integer);
        }
        return response;
    }

    public static void main(String[] args) {
        System.out.println(plusOne(Arrays.asList(1,2,3))); // 1,2,4
        System.out.println(plusOne(Arrays.asList(9))); // 1,0
        System.out.println(plusOne(Arrays.asList(0,0,9))); // 1,0
    }
}
