package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Problem Description
 * Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
 *
 * String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.
 *
 * Find and return the postfix expression of A.
 *
 * NOTE:
 *
 * ^ has the highest precedence.
 * / and * have equal precedence but greater than + and -.
 * + and - have equal precedence and lowest precedence among given operators.
 *
 *
 * Problem Constraints
 * 1 <= length of the string <= 500000
 *
 *
 *
 * Input Format
 * The only argument given is string A.
 *
 *
 *
 * Output Format
 * Return a string denoting the postfix conversion of A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "x^y/(a*z)+b"
 * Input 2:
 *
 *  A = "a+b*(c^d-e)^(f+g*h)-i"
 *
 *
 * Example Output
 * Output 1:
 *
 *  "xy ^ az * /b+"
*Output 2:
*
*"abcd^e-fgh*+^*+i-"
*
*
*Example Explanation
*Explanation 1:
*
*Ouput dentotes the postfix expression of the given input.
 */
public class InfixToPostfix {
    public static String infixToPostfix(String A) {
        Map<Character, Integer> operatorPrecedence = new HashMap<>();
        operatorPrecedence.put('^',3);
        operatorPrecedence.put('*',2);
        operatorPrecedence.put('/',2);
        operatorPrecedence.put('+',1);
        operatorPrecedence.put('-',1);

        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for(char ch : A.toCharArray()) {
            if(operatorPrecedence.containsKey(ch)) {
                //  If the precedence of the scanned operator is greater than that of the operator in the stack
                //  or the stack is empty
                //  or the stack contains a '('
                //  push it.
                if(stack.isEmpty() || stack.peek() == '(' || operatorPrecedence.get(ch) > operatorPrecedence.get(stack.peek())) {
                    stack.push(ch);
                } else {
                    // Pop all the operators from the stack which are greater than or equal to in precedence than that of the scanned operator
                    // and append them to postfix.
                    // After doing that, Push the scanned operator to the stack.
                    // If you encounter parenthesis while popping, stop there and push the scanned operator in the stack.
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        if(operatorPrecedence.get(stack.peek()) < operatorPrecedence.get(ch)) {
                            break;
                        }
                        postfix.append(stack.pop());
                    }
                    stack.push(ch);
                }
            } else if(ch == '(') {
                // If the scanned character is an '(', push it to the stack.
                stack.push(ch);
            } else if(ch == ')') {
                // If the scanned character is an ')'',
                // pop the stack and output it until a '('' is encountered, and discard both the parenthesis.
                while(stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                postfix.append(ch);
            }
        }
        // Pop and append from the stack until it is not empty.
        while(!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    public static void main(String[] args) {
        System.out.println(infixToPostfix("x^y/(a*z)+b")); // "xy^az*/b+"
        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i")); //  "abcd^e-fgh*+^*+i-"
    }
}
