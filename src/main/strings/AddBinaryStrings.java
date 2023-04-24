package strings;

/**
 * Given two binary strings A and B. Return their sum (also a binary string).
 */
public class AddBinaryStrings {
    public static String addBinary(String A, String B) {
        char carry = '0';
        int lenA = A.length();
        int lenB = B.length();
        int maxLen = Math.max(lenA, lenB);
        char[] result = new char[maxLen];
        int idx = maxLen - 1;
        int i = lenA-1;
        int j = lenB-1;
        while(i >=0 || j >= 0) {
            char charA = i >= 0 ? A.charAt(i) : '0';
            char charB = j >= 0 ? B.charAt(j) : '0';
            if(carry == '1') {
                if(charA == '1' && charB == '1') {
                    result[idx] = '1';
                } else if(charA == '1' || charB == '1') {
                    result[idx] = '0';
                } else {
                    result[idx] = '1';
                    carry = '0';
                }
            } else {
                if(charA == '1' && charB == '1') {
                    result[idx] = '0';
                    carry = '1';
                } else if(charA == '1' || charB == '1') {
                    result[idx] = '1';
                } else {
                    result[idx] = '0';
                }
            }
            i--;
            j--;
            idx--;
        }
        if(carry == '1') {
            return '1' + new String(result);
        } else {
            return new String(result);
        }
    }

    public static void main(String[] args) {
        System.out.println(addBinary("100", "11")); //"111"
        System.out.println(addBinary("110", "10")); //"1000"
    }
}
