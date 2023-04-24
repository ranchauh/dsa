package strings;

/**
 * You are given a character string A having length N, consisting of only lowercase and uppercase latin letters.
 * You have to toggle case of each character of string A. For e.g 'A' is changed to 'a', 'e' is changed to 'E', etc.
 */
public class ToggleCase {
    public String solveWithBitwise(String A) {
        char[] arr = A.toCharArray();
        for(int i=0; i<arr.length; i++) {
            arr[i] ^= (1<<5);
        }
        return new String(arr);
    }

    public String solveByChar(String A) {
        char[] arr = A.toCharArray();
        for(int i=0; i<arr.length; i++) {
            int ch = arr[i];
            if(ch >= 65 && ch <= 90) {
                arr[i] = (char) (ch + 32);
            } else {
                arr[i] = (char) (ch - 32);
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        ToggleCase obj = new ToggleCase();
        System.out.println(obj.solveByChar("tHiSiSaStRiNg" ));
        System.out.println(obj.solveWithBitwise("tHiSiSaStRiNg" ));
    }
}
