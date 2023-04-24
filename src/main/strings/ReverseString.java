package strings;

public class ReverseString {
    public static String solve(String A) {
        char[] arr = A.toCharArray();
        int i=0;
        int j=arr.length-1;
        while(i<j) {
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;

            i++;
            j--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(solve("RandomString"));
    }
}
