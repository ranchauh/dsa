package arrays;
/*
You have given a string A having Uppercase English letters.
You have to find the number of pairs (i, j) such that A[i] = 'A', A[j] = 'G' and i < j.
 */
// Without using suffix or prefix
public class SpecialSubsequenceAG {
    public Long solve(String A) {
        int n = A.length();
        long suffixCount = 0;
        long count = 0;

        for(int i=n-1; i>=0; i--) {
            if(A.charAt(i) == 'G') {
                suffixCount += 1;
            }
            if(A.charAt(i) == 'A') {
                count += suffixCount;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new SpecialSubsequenceAG().solve("ABCGAG")); // 3
        System.out.println(new SpecialSubsequenceAG().solve("GAB")); // 3
    }
}

