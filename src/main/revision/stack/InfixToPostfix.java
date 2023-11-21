package revision.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixToPostfix {
    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> precedenceMap = new HashMap<>();
        precedenceMap.put('^', 3);
        precedenceMap.put('*', 2);
        precedenceMap.put('/', 2);
        precedenceMap.put('+', 1);
        precedenceMap.put('-', 1);
        StringBuilder postfix = new StringBuilder();
        for(char ch : infix.toCharArray()) {
            if(precedenceMap.containsKey(ch)) {
                if(stack.isEmpty() || stack.peek() == '(' ||
                        precedenceMap.get(ch) > precedenceMap.get(stack.peek())) {
                    stack.push(ch);
                } else {
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        if(precedenceMap.get(stack.peek()) < precedenceMap.get(ch)) {
                            break;
                        }
                        postfix.append(stack.pop());
                    }
                    stack.push(ch);
                }
            } else if(ch == '(') {
                stack.push(ch);
            } else if(ch == ')') {
                // When closing bracket arrives [)], pop everything until opening bracket [(]
                while(stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                // Also, remove opening bracket and discard it.
                stack.pop();
            } else {
                postfix.append(ch);
            }
        }
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
