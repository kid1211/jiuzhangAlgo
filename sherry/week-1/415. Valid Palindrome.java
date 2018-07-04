// 415. Valid Palindrome
// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
// Example
// "A man, a plan, a canal: Panama" is a palindrome.
//
// "race a car" is not a palindrome.
//
// Challenge
// O(n) time without extra memory.
/*
*Solution1: remove the non letter or digit to make a new array
Solution2: using double pointer to skip non letter or digit index
Q: how to fix start over end status?
*/
public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        //double pointer, avoid duplicate code

        //edgeCases
        if(s == null || s.length() ==0) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;
        while(start + 1 < end) {
            while(start < s.length() && !isValid(s.charAt(start))) {
                start++;
            }
            while(end > 0 && !isValid(s.charAt(end))) {
                end--;
            }
            // Q: is here need to validate start != end
            if(start + 1 < end) {
                if(!isTwoCharEqulesIgnoreCases(s.charAt(start), s.charAt(end))) {
                return false;
                }
                start++;
                end--;
            }
        }

        if(start < end ) {
            if(isValid(s.charAt(start)) && isValid(s.charAt(end))) {
                return isTwoCharEqulesIgnoreCases(s.charAt(start), s.charAt(end));
            }
        }

        return true;
    }

    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

    private boolean isTwoCharEqulesIgnoreCases(char c1, char c2) {
        return Character.toLowerCase(c1) == Character.toLowerCase(c2);
    }

    // general method the find palindrome
    private int findLongestPalindromeFrom(String s, int left, int right) {
        int len = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            len += left == right ? 1 : 2;
            left--;
            right++;
        }

        return len;
    }
}
