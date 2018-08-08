import java.util.HashSet;
import java.util.Set;

public class TwoPointer {

    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        int maxLength = Integer.MIN_VALUE;
        if (s == null || s.length() == 0) {
            return 0;
        }
        //using two prointer, one is the start, one is the lentgh
        // using a hashMap to save the index
        // abcdrf -> i = 0; put in map, if j ++, if not equal, add to map, and move on
        // if j is exist, i -> i+1, move out ->
        Set<Character> existSet = new HashSet<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && !existSet.contains(s.charAt(j))) {
                existSet.add(s.charAt(j));
                //int temp = j - i + 1;
                //System.out.println("i = " + i + " j = " + j + " diff = " + temp);
                maxLength = Math.max(maxLength, j - i + 1);
                j++;
            }
            existSet.remove(s.charAt(i));
        }
        //System.out.println("*******************");
        return maxLength;
    }
}
