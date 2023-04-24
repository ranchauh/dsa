package strings;

/**
 * Akash likes playing with strings. One day he thought of applying following operations on the string in the given order:
 * Concatenate the string with itself.
 * Delete all the uppercase letters.
 * Replace each vowel with '#'.
 * You are given a string A of size N consisting of lowercase and uppercase alphabets. Return the resultant string after applying the above operations.
 * NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.
 */
public class HashOperation {
    public static String solve(String A) {
        StringBuilder s = new StringBuilder();
        for(char ch : A.toCharArray()) {
            if(ch >= 'A' && ch <= 'Z') {
                continue;
            }
            switch(ch) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    s.append("#");
                    break;
                default:
                    s.append(ch);
            }
        }
        s.append(s);
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(solve("AbcaZeoB")); //"bc###bc###"
    }
}
