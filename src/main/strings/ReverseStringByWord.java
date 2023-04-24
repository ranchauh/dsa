package strings;

/**
 * You are given a string A of size N.
 * Return the string A after reversing the string word by word.
 * NOTE:
 * A sequence of non-space characters constitutes a word.
 * Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
 * If there are multiple spaces between words, reduce them to a single space in the reversed string.
 */
public class ReverseStringByWord {
    public String solve(String A) {
        StringBuilder sBuilder = new StringBuilder();
        int i = A.length()-1;
        int j;
        String sub = "";
        while (i>=0) {
            j = i;
            // find the next word start
            while(i>=0 && A.charAt(i) != ' ') {
                i--;
            }
            // if there was a word previously, append a space
            if(sub.length() != 0) {
                sBuilder.append(" ");
            }
            // do substring from i+1 to j+1 to get the word
            // and append it to sBuilder
            sub = A.substring(i+1, j+1);
            sBuilder.append(sub);
            // skip all extra spaces
            while(i>=0 && A.charAt(i) == ' ') {
                i--;
            }
        }
        return sBuilder.toString();
    }

    public static void main(String[] args) {
        ReverseStringByWord obj = new ReverseStringByWord();
        System.out.println(obj.solve("the sky is blue"));
        System.out.println(obj.solve("crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv     "));
        System.out.println(obj.solve("   a ci f ved pu vkfzbu bnbvlvgkua imjd hrrnx nopp p kso iejgcd wyalgcxie yfslfzzw lygatpbv wr budfobxsm "));
    }
}
