package combinatorics;

/**
 * Problem Description
 * Given a positive integer A, return its corresponding column title as it appears in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *
 *
 * Problem Constraints
 * 1 <= A <= 109
 *
 * Input Format
 * First and only argument of input contains single integer A
 *
 * Output Format
 * Return a string denoting the corresponding title.
 *
 * Example Input
 * Input 1:
 *
 * A = 3
 * Input 2:
 *
 * A = 27
 *
 * Example Output
 * Output 1:
 *
 * "C"
 * Output 2:
 *
 * "AA"
 *
 * Example Explanation
 * Explanation 1:
 *
 * 3 corrseponds to C.
 * Explanation 2:
 *
 *     1 -> A,
 *     2 -> B,
 *     3 -> C,
 *     ...
 *     26 -> Z,
 *     27 -> AA,
 *     28 -> AB
 */
public class ExcelColumnTitle {
    /**
     * Instead of mapping 1->A...26->Z, we map 0->A...25->Z so that the remainder can be mapped easily with the Alphabet.
     * Also, every time instead of taking the original number A, take A-1 for the iteration procedure so that
     * the above mapping change works fine.
     */
    public static String convertToTitle(int A) {
        StringBuilder result = new StringBuilder();
        while(A > 0 ) {
            A = A - 1;
            int r = A % 26;
            result.append((char) (65+r));
            A = A / 26;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(943566)); //BAQTZ
    }
}
