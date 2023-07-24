package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Problem Description
 * Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
 *
 * Check whether A has redundant braces or not.
 *
 * NOTE: A will be always a valid expression and will not contain any white spaces.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 105
 *
 *
 *
 * Input Format
 * The only argument given is string A.
 *
 *
 *
 * Output Format
 * Return 1 if A has redundant braces else, return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "((a+b))"
 * Input 2:
 *
 *  A = "(a+(a+b))"
 *
 *
 * Example Output
 * Output 1:
 *
 *  1
 * Output 2:
 *
 *  0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  ((a+b)) has redundant braces so answer will be 1.
 * Explanation 2:
 *
 *  (a+(a+b)) doesn't have have any redundant braces so answer will be 0.
 */
public class RedundantBraces {
    public static int braces(String A) {
        Stack<Character> stack = new Stack<>();
        List<Character> operators = Arrays.asList('+','-','*','/');
        for(char ch : A.toCharArray()) {
            if(ch == ')') {
                if(!stack.isEmpty()) {
                    char topChar = stack.peek();
                    if(topChar == '(') {
                        return 1;
                    }
                    stack.pop();
                    stack.pop();
                }
            } else if(ch == '(' || operators.contains(ch)) {
                stack.push(ch);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(braces("(a+b)")); // 0
        System.out.println(braces("(a)")); // 1
        System.out.println(braces("(a*(a+b))")); // 0
        System.out.println(braces("(((a+b)*(c*d)))")); // 1
    }
}
