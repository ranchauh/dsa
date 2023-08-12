package stack;
import java.util.Stack;

/**
 * Minimum number of reversals required to balance an expression with only parenthesis
 * '[' and ']'
 */
public class CompilerError {
    public static int solve(String A) {
        if(A.length() % 2 != 0) {
            return -1;
        }
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(char ch : A.toCharArray()) {
            if(ch == ']') {
                if(stack.isEmpty()) {
                    count++;
                    stack.push('[');
                } else if(stack.peek() == '[') {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        if(stack.isEmpty()) {
            return count;
        }
        if(stack.size() % 2 == 0) {
            return count + stack.size()/2;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solve("]]][][[][]")); //3
        System.out.println(solve("[[]][")); // -1
    }
}
