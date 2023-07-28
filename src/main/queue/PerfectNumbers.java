package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Description
 * Given an integer A, you have to find the Ath Perfect Number.
 *
 * A Perfect Number has the following properties:
 *
 * It comprises only 1 and 2.
 * The number of digits in a Perfect number is even.
 * It is a palindrome number.
 * For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 100000
 *
 *
 *
 * Input Format
 * The only argument given is an integer A.
 *
 *
 *
 * Output Format
 * Return a string that denotes the Ath Perfect Number.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 2
 * Input 2:
 *
 *  A = 3
 *
 *
 * Example Output
 * Output 1:
 *
 *  22
 * Output 2:
 *
 *  1111
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * First four perfect numbers are:
 * 1. 11
 * 2. 22
 * 3. 1111
 * 4. 1221
 * Return the 2nd Perfect number.
 * Explanation 2:
 *
 * First four perfect numbers are:
 * 1. 11
 * 2. 22
 * 3. 1111
 * 4. 1221
 * Return the 3rd Perfect number.
 */
public class PerfectNumbers {
    public static String getiThPerfectNumber(int A) {
        Queue<String> queue = new LinkedList<>();
        // We can construct all the 100000 perfect numbers upfront and then return based on query
        // To construct all the perfect numbers mentione
        queue.add("1");
        queue.add("2");
        int i = 1;
        while(true) {
            if(i == A) {
                String str = queue.poll();
                return str + new StringBuilder(str).reverse();
            }
            String x = queue.poll();
            queue.add(x+"1");
            queue.add(x+"2");
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println(getiThPerfectNumber(2)); // 22
        System.out.println(getiThPerfectNumber(3)); // 1111
        System.out.println(getiThPerfectNumber(10)); // 122221
    }
}
