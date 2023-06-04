package bit;

/**
 * Once upon a time, in a land far away, there was a wise old sage who loved exploring the mysteries of numbers. One day, while meditating under a tree, he came up with a problem that challenged his intellect. He wanted to find the longest distance between any two adjacent 1's in the binary representation of a positive integer .
 * . He believed that this distance held a special significance and could unlock hidden secrets of the universe. Can you help the wise old sage solve this problem?
 * If there are less than 2 1's in the binary representation of A, return 0.
 */
public class SageAndBinaryNumber {
    public static int solve(int A) {
        int l = -1, r = -1;
        int max = 0;
        for(int i=31; i>=0; i--) {
            if((A & (1<<i)) != 0) {
                l = r;
                r = i;
            }
            if(l != -1) {
                max = Math.max(max, l - r);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(solve(11)); //2
        System.out.println(solve(1)); //0
        System.out.println(solve(2)); //0
    }
}
