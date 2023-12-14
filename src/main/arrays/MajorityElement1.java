package arrays;

public class MajorityElement1 {
    public int majorityElement(final int[] A) {
        int n = A.length;
        int majority = A[0];
        int freq = 1;

        for(int i=1; i<n; i++) {
            if(freq == 0) {
                majority = A[i];
                freq = 1;
            } else if(A[i] != majority) {
                freq--;
            } else {
                freq++;
            }
        }
        freq = 0;
        for (int v : A) {
            if(v == majority) {
                freq++;
            }
        }
        if(freq > n/2) {
            return majority;
        }
        return -1;

    }

    public static void main(String[] args) {
        MajorityElement1 ob = new MajorityElement1();
        System.out.println(ob.majorityElement(new int[]{4,4,3,8,8,4,9,4,4}));// 4
        System.out.println(ob.majorityElement(new int[]{1, 2, 3}));// -1
    }
}
