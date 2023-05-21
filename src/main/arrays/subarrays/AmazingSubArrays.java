package arrays.subarrays;
/*
You are given a string S, and you have to find all the amazing substrings of S.
An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
Input
    Only argument given is string S.
Output
    Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.
Constraints
    1 <= length(S) <= 1e6
    S can have special characters
Example
Input
    ABEC
Output
    6
Explanation
    Amazing substrings of given string are :
    1. A
    2. AB
    3. ABE
    4. ABEC
    5. E
    6. EC
    here number of substrings are 6 and 6 % 10003 = 6.
 */
public class AmazingSubArrays {
    public int solve(String A) {
        long count = 0;
        int n = A.length();
        for(int i=0; i<n; i++) {
            switch(A.charAt(i)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    count += (n-i);
            }
        }
        return (int) (count % 10003);
    }

    public static void main(String[] args) {
        System.out.println(new AmazingSubArrays().solve("ABEC")); // 6
    }
}
