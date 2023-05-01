package recursion;

public class FindFactorial {
    public int solve(int A) {
        return fact(A);
    }
    private int fact(int n) {
        if(n == 0 || n==1){
            return 1;
        }
        return n* fact(n-1);
    }
}
