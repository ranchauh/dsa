package arrays.subarrays;

/**
 * In a parallel universe, there exist a kingdom that is known for its unique way of cooking. In this kingdom, there is a famous chef who is known for her delicious dishes. One day, the chef decided to create a new dish that consists of a sequence of ingredients. Each ingredient has a distinct weight, and the chef wants to choose a subarray of ingredients that have an increasing weight.
 * The chef wants to know the maximum possible sum of the weights of the ascending subarray she can choose. Can you help the chef by writing a function that returns the maximum possible sum of an ascending subarray in the weights of ingredients?
 * The array of ingredients is represented by the array A
 *
 * Max possible sum in increasing subarray
 */
public class CheckAndCooking {

    public static long solve(int[] A) {
        long maxSum = A[0];
        long sum = A[0];
        for(int i=1; i<A.length; i++) {
            if(A[i] > A[i-1]) {
                sum += A[i];
            } else {
                sum = A[i];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 4, 8 , 12, 11, 10, 16, 18, 17};
        System.out.println(solve(A)); // 44
    }

}
