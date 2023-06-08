package gcd;

/**
 * private int gcd(int A, int B) {
 *         while(A > 0 && B > 0) {
 *             if(A > B) {
 *                 A = A%B;
 *             } else {
 *                 B = B%A;
 *             }
 *         }
 *         if(A == 0) {
 *             return B;
 *         }
 *         return A;
 *     }
 */
public class PubG {
    public int solve(int[] A) {
        int ans = 0;
        for(int x : A) {
            ans = gcd(ans, x);
        }
        return ans;
    }

    private int gcd(int A, int B) {
        while(A > 0 && B > 0) {
            if(A > B) {
                A = A%B;
            } else {
                B = B%A;
            }
        }
        if(A == 0) {
            return B;
        }
        return A;
    }

    public static void main(String[] args) {
        PubG ob = new PubG();
        System.out.println(ob.solve(new int[]{6, 4})); // 2
        System.out.println(ob.solve(new int[]{2, 3, 4})); // 1
    }
}
