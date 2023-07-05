package hashmap;

import java.util.HashMap;
import java.util.Map;

public class WindowString {
    public String minWindow(String A, String B) {
        Map<Character,Integer> mapA = new HashMap<>();
        Map<Character,Integer> mapB = new HashMap<>();
        // populate mapB with the frequency of each character in string B
        for(char ch : B.toCharArray()) {
            mapB.put(ch, mapB.getOrDefault(ch, 0) + 1);
        }
        // Go over the chars in String A, populate mapA and compare with mapB.
        int s = 0, e = 0;
        String result = "";
        char ch = A.charAt(e);
        // populate mapA with the frequency of the char found at jth location.
        mapA.put(ch, 1);
        while(e < A.length()) {
            if(checkEquals(mapB, mapA)) {
                // if the frequencies in mapB matches with mapA, update the result
                result = A.substring(s, e+1);
                ch = A.charAt(s);
                int freq = mapA.getOrDefault(ch, 1);
                if(freq == 1) {
                    mapA.remove(ch);
                } else {
                    mapA.put(ch, freq - 1);
                }
                s = s + 1;
            } else {
                // else, include the next char
                e = e + 1;
                if(e == A.length()) {
                    break;
                }
                ch = A.charAt(e);
                mapA.put(ch, mapA.getOrDefault(ch, 0) + 1);
            }
        }
        return result;
    }

    /**
     * Checks whether:
     * 1. mapTwo contains all the keys from mapOne.
     * 2. If key exists, the value is greater or equal to mapOne.
     */
    private boolean checkEquals(Map<Character, Integer> mapOne, Map<Character, Integer> mapTwo) {
        for(char key : mapOne.keySet()) {
            if(!mapTwo.containsKey(key) || mapTwo.get(key) < mapOne.get(key)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WindowString ob = new WindowString();
        System.out.println(ob.minWindow("ADOBECODEBANC", "ABC"));
    }
}

