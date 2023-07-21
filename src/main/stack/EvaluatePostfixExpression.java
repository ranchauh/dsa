package stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Problem Description
 * An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each string may be an integer or an operator.
 *
 * Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 *
 *
 * Input Format
 * The only argument given is string array A.
 *
 *
 *
 * Output Format
 * Return the value of arithmetic expression formed using reverse Polish Notation.
 *
 *
 *
 * Example Input
 * Input 1:
 * A =   ["2", "1", "+", "3", "*"]
 * Input 2:
 * A = ["4", "13", "5", "/", "+"]
 *
 *
 * Example Output
 * Output 1:
 * 9
 * Output 2:
 * 6
 *
 *
 * Example Explanation
 * Explaination 1:
 * starting from backside:
 *     * : () * ()
 *     3 : () * (3)
 *     + : (() + ()) * (3)
 *     1 : (() + (1)) * (3)
 *     2 : ((2) + (1)) * (3)
 *     ((2) + (1)) * (3) = 9
 * Explaination 2:
 * starting from backside:
 *     + : () + ()
 *     / : () + (() / ())
 *     5 : () + (() / (5))
 *     13 : () + ((13) / (5))
 *     4 : (4) + ((13) / (5))
 *     (4) + ((13) / (5)) = 6
 */
public class EvaluatePostfixExpression {
    private static final List<String> operatorList = Arrays.asList("+","-","*","/");
    public int evalRPN(String[] A) {
        Stack<Integer> stack = new Stack<>();
        for(String s : A) {
            if(isOperator(s)) {
                int y = stack.pop();
                int x = stack.pop();
                int result = perform(x, y, s);
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.isEmpty() ? 0 : stack.peek();
    }

    private int perform(int x, int y, String operator) {
        if("+".equals(operator)) {
            return x + y;
        } else if("-".equals(operator)) {
            return x - y;
        } else if("*".equals(operator)) {
            return x * y;
        } else if("/".equals(operator)) {
            return y == 0 ? 0 : x / y;
        } else {
            return 0;
        }
    }

    private boolean isOperator(String op) {
        return operatorList.contains(op);
    }

    public static void main(String[] args) {
        EvaluatePostfixExpression ob = new EvaluatePostfixExpression();
        System.out.println(ob.evalRPN(new String[]{"2", "1", "+", "3", "*"})); // 9
        System.out.println(ob.evalRPN(new String[]{"4", "13", "5", "/", "+"})); // 6
    }
}
