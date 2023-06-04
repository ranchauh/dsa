package bit;

public class BinaryExponential {
    public static int power(int A, int B) {
        if(B == 0) return 1;

        int result = 1;
        while(B > 0) {
            if((B & 1) == 1) {
                result = result * A;
            }
            A *= A;
            B = B>>1; // B = B>>1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(3, 5)); //27
    }
}
