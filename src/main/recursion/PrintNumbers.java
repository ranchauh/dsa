package recursion;

public class PrintNumbers {
    public void nTo1(int n) {
        if(n > 0) {
            System.out.print(n + " ");
            nTo1(n-1);
        } else {
            System.out.println();
        }
    }

    public void _1ToN(int n) {
        print(n);
        System.out.println();
    }

    private void print(int n) {
        if(n > 0) {
            print(n-1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        PrintNumbers ob = new PrintNumbers();
        ob.nTo1(9);
        ob._1ToN(9);
    }
}
