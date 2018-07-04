// 627. Longest Palindrome
// Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
//
// This is case sensitive, for example "Aa" is not considered a palindrome here.
//
// Example
// Given s = "abccccdd" return 7
//
// One longest palindrome that can be built is "dccaccd", whose length is 7
public class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        //count each letter for if it's number is Odd
        // check un-usual state
        if(s == null) {
            return 0;
        }
        // convert string to charArray
        char[] chars = s.toCharArray();
        int strLength = chars.length;
        if(strLength <=1) {
            return strLength;
        }
        int maxValue = 0;
        // loop over the String and count
        //TODO: not use int, maybe byte
        int[] times = new int[52];
        for(char c : chars) {
            if(isLowerCase(c)) {
                if(times[c-'a'] == 1 ){
                    maxValue = maxValue + 2;
                    times[c-'a'] = 0;
                }else{
                    times[c-'a'] = 1;
                }
            }else {
                if(times[c-'A'+25] == 1 ){
                    maxValue = maxValue + 2;
                    times[c-'A'+25] = 0;
                }else{
                    times[c-'A'+25] = 1;
                }
            }
        }
        //check if need to add another 1 to the max lenght
        for(int t : times){
            if(t == 1){
                maxValue = maxValue + 1;
                break;
            }
        }
        return maxValue;

    }


    private boolean isLowerCase(char c) {
        return c>='a'&&c<='z';
    }
}


public class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        // check edge cases
        if(s == null || s.length() == 0) {
            return 0;
        }

        //create a hashtable to save the letters
        HashMap countingMap = new HashMap<Character, Boolean>();
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            if(countingMap.get(s.charAt(i)) != null && countingMap.get(s.charAt(i)).equals(true)) {
                countingMap.put(s.charAt(i), false);
                result += 2;
            }else {
                countingMap.put(s.charAt(i), true);
            }
        }
        // check if ther's unit char in countingMap
        if(countingMap.values().contains(true)) {
            result += 1;
        }

        return result;
    }
}
