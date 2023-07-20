package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Problem Description
 * Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
 *
 * Refer to the examples for more clarity.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100
 *
 *
 *
 * Input Format
 * The first and the only argument of input contains the string A having the parenthesis sequence.
 *
 *
 *
 * Output Format
 * Return 0 if the parenthesis sequence is not balanced.
 *
 * Return 1 if the parenthesis sequence is balanced.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = {([])}
 * Input 2:
 *
 *  A = (){
 * Input 3:
 *
 *  A = ()[] 
 *
 *
 * Example Output
 * Output 1:
 *
 *  1 
 * Output 2:
 *
 *  0 
 * Output 3:
 *
 *  1 
 */
public class BalanceParenthesis {
    public static int solve(String A) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairMap = new HashMap<>();
        pairMap.put('}', '{');
        pairMap.put(']', '[');
        pairMap.put(')', '(');
        for(char c : A.toCharArray()) {
            if(!stack.isEmpty()) {
                char topChar = stack.peek();
                if(pairMap.containsKey(c) && pairMap.get(c) == topChar) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(solve("{[()]}")); //1
    }
}
