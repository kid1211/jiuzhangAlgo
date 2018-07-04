// 254. Drop Eggs
//
// There is a building of n floors. If an egg drops from the k th floor or above, it will break. If it's dropped from any floor below, it will not break.
//
// You're given two eggs, Find k while minimize the number of drops for the worst case. Return the number of drops in the worst case.
//
// Example
//
// Given n = 10, return 4.
// Given n = 100, return 14.
//
//
//K is the worst case, assuming using first egg throw from K and broken, the other egg need to test from first flow
//so x+x-1+x-2+...+2+1 = n-1 -> number of x is the k.
public class Solution {
    /**
     * @param n: An integer
     * @return: The sum of a and b
     */
    public int dropEggs(int n) {
        // write your code here
        long ans = 0;
        for (int i = 1; ; ++i) {
            ans += (long)i;
            if (ans >= (long)n)
                return i;
        }
    }
}
