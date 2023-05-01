package recursion;

import java.util.Scanner;

/**
 * Write a recursive function that, given a string S, prints the characters of S in reverse order.
 */
public class ReverseString {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        reverseString(input, input.length()-1);
    }

    private static void reverseString(String s, int i) {
        if(i >= 0) {
            System.out.print(s.charAt(i));
            reverseString(s, i-1);
        }
    }
}
