package basic;

import gcd.Gcd;

public class Lcm {
    // TC: O(min(a,b)), SC: O(1)
    public static int lcm(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        for(int i = max;; i += max) {
            if(i%min == 0) {
                return i;
            }
        }
    }

    // lcm(a,b) = (a/gcd(a,b)) * b
    // TC: O(log(min(a,b)), SC: O(1)
    public static int lcmByGcd(int a, int b) {
        int gcd = Gcd.gcdSwap(a, b);
        return (a/gcd) * b;
    }

    public static void main(String[] args) {
        System.out.println(lcm(12, 11)); // 132
        System.out.println(lcmByGcd(12, 11)); // 132
    }
}
