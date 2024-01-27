package map.hashmap;

import java.util.HashMap;
import java.util.Map;

public class WindowString {

    public String minWindow(String A, String B) {
        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char ch : B.toCharArray()) {
            targetFreq.put(ch, targetFreq.getOrDefault(ch, 0) + 1);
        }

        int required = targetFreq.size(); // Number of unique characters in B
        int formed = 0; // Number of unique characters formed in the window
        int left = 0; // Left pointer of the window
        int right = 0; // Right pointer of the window
        Map<Character, Integer> windowFreq = new HashMap<>();
        int[] result = {-1, 0, 0}; // Format: {window length, left, right}
        while (right < A.length()) {
            char ch = A.charAt(right);
            windowFreq.put(ch, windowFreq.getOrDefault(ch, 0) + 1);
            if (targetFreq.containsKey(ch) && targetFreq.get(ch).equals(windowFreq.get(ch))) {
                formed++;
            }

            while (left <= right && formed == required) {
                // Update the result if a smaller window is found
                if (result[0] == -1 || right - left + 1 < result[0]) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }

                char leftChar = A.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                if (targetFreq.containsKey(leftChar) && windowFreq.get(leftChar) < targetFreq.get(leftChar)) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return result[0] == -1 ? "" : A.substring(result[1], result[2] + 1);
    }

    public static void main(String[] args) {
        WindowString ob = new WindowString();
        System.out.println(ob.minWindow("ADOBECODEBANC", "ABC"));
    }

}

