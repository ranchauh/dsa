package bit;

public class CountBits {
    static int  noOfBits(int x) {
        int i = 31;
        while(i >= 0 && (x & (1 << i)) == 0) {
            i--;
        }
        return i+1;
    }
    public static void main(String[] args) {
        System.out.println(noOfBits(3));
        System.out.println(noOfBits(7));
        System.out.println(noOfBits(10));
    }
}
