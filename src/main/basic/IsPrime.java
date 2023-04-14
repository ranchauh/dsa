package basic;
/*
Given an Integer A. Return 1 if A is prime and return 0 if not.
 */
public class IsPrime {
    public int solve(Long A) {
        if(A==1) return 0;
        for(Long i=2L; i*i <= A; i++) {
            if (A%i == 0) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new IsPrime().solve(10L));
    }
}
