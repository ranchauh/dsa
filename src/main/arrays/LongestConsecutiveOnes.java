package arrays;

/**
 * Given a binary string A. It is allowed to do at most one swap between any 0 and 1.
 * Find and return the length of the longest consecutive 1’s that can be achieved.
 */
public class LongestConsecutiveOnes {
    public int solve(String S) {
        char[] A = S.toCharArray();
        int n = A.length;
        int[] prefixConsecutiveOnes = prefixConsecutiveOnes(A);
        int[] suffixConsecutiveOnes = suffixConsecutiveOnes(A);
        int ans = -1;

        // Count number of 1's
        int countOnes = 0;
        for(int a : A) {
            if(a == '1') countOnes++;
        }

        // Handle edge cases
        // Handle 0th index
        if(A[0] == '0') {
            ans = Math.max(ans, suffixConsecutiveOnes[1]);
        }
        // Handle n-1th index
        if(A[n-1] == '0') {
            ans = Math.max(ans, prefixConsecutiveOnes[n-2]);
        }

        for(int i=1; i<n-1; i++) {
            if(A[i] == '0') {
                int a = prefixConsecutiveOnes[i-1] + 1 + suffixConsecutiveOnes[i+1];
                ans = Math.max(ans, a);
            }
        }
        if(ans == -1) {
            // Array has all 1's
            return n;
        } else if((ans-1) < countOnes) {
            // There are extra 1's available for swap. (ans-1) because extra 1 was added for a 0.
            return ans;
        } else {
            // No extra 1's are available for swap.
            return ans - 1;
        }
    }

    private int[] prefixConsecutiveOnes(char[] A) {
        int n = A.length;
        int[] prefix = new int[n];
        // handle edge case
        if(A[0] == '1') {
            prefix[0] = 1;
        }
        for(int i=1; i<n; i++) {
            if(A[i] == '1') {
                prefix[i] = prefix[i-1] + 1;
            }
        }
        return prefix;
    }

    private int[] suffixConsecutiveOnes(char[] A) {
        int n = A.length;
        int[] suffix = new int[n];
        // handle edge case
        if(A[n-1] == '1') {
            suffix[n-1] = 1;
        }
        for(int i=n-2; i>=0; i--) {
            if(A[i] == '1') {
                suffix[i] = suffix[i+1] + 1;
            }
        }
        return suffix;
    }

    public static void main(String[] args) {
        LongestConsecutiveOnes obj = new LongestConsecutiveOnes();
        System.out.println(obj.solve("111011101")); // 7
    }
}
