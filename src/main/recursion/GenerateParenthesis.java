package recursion;

import java.util.ArrayList;

/**
 * Problem Description
 * Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 10
 *
 *
 *
 * Input Format
 * First and only argument is integer A.
 *
 *
 *
 * Output Format
 * Return a sorted list of all possible parenthesis.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 3
 * Input 2:
 *
 * A = 1
 *
 *
 * Example Output
 * Output 1:
 *
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * Output 2:
 *
 * [ "()" ]
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  All paranthesis are given in the output list.
 * Explanation 2:
 *
 *  All paranthesis are given in the output list.
 */
public class GenerateParenthesis {
    ArrayList<String> parenthesisList = new ArrayList<>();
    public ArrayList<String> generateParenthesis(int A) {
        generateParenthesis(A, A, "");
        return parenthesisList;
    }

    private void generateParenthesis(int open, int closed, String sequence) {
        if(open == 0 && closed == 0) {
            parenthesisList.add(sequence);
            return;
        }
        if(open > 0) { // handles right part of the tree: "("
            generateParenthesis(open - 1, closed, sequence + "(");
        }
        if(open < closed) { // handles left part of the tree: ")"
            generateParenthesis(open, closed - 1, sequence + ")");
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis ob = new GenerateParenthesis();
        System.out.println(ob.generateParenthesis(3)); // ["((()))", "(()())", "(())()", "()(())", "()()()"]
    }
}
