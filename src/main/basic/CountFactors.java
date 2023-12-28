package basic;
/*
Given an integer A, you need to find the count of it's factors.

Factor of a number is the number which divides it perfectly leaving no remainder.

Example : 1, 2, 3, 6 are factors of 6
 */
public class CountFactors {
    public int solve(int A) {
        int count = 0;
        for(int i=1; (i*i) <= A; i++) {
            if(A%i == 0) {
                // factors of 9
                // 1, 3, 9, so when 9/3 = 3, count 1
                if(A/i == i) count++;
                // else count twice.For 1 and 9
                else count += 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountFactors().solve(10));
    }
}
