package arrays;

public class MajorityElement2 {
    public int repeatedNumber(int[] A) {
        int n = A.length;
        if(n < 2) {
            return A[0];
        }
        int nBy3 = n/3;
        int majority1 = -1;
        int majority2 = -1;
        int freq1 = 0;
        int freq2 = 0;
        for(int v : A) {
            if(v == majority1) {
                freq1++;
            } else if(v == majority2) {
                freq2++;
            } else if(freq1 == 0) {
                majority1 = v;
                freq1 = 1;
            } else if(freq2 == 0) {
                majority2 = v;
                freq2 = 1;
            } else {
                freq1--;
                freq2--;
            }
        }
        freq1 = 0;
        freq2 = 0;
        for(int v : A) {
            if(v == majority1) {
                freq1++;
            } else if(v == majority2) {
                freq2++;
            }
        }
        if(freq1 > nBy3) {
            return majority1;
        } else if(freq2 > nBy3) {
            return majority2;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        MajorityElement2 ob = new MajorityElement2();
        System.out.println(ob.repeatedNumber(new int[]{1, 2, 3, 1, 1}));// 1
        System.out.println(ob.repeatedNumber(new int[]{1, 2, 3}));// -1
    }
}
