// 414. Divide Two Integers
// Divide two integers without using multiplication, division and mod operator.
//
// If it is overflow, return 2147483647
//
// Example
// Given dividend = 100 and divisor = 9, return 11.

public class Solution {
    /**
     * @param dividend: the dividend
     * @param divisor: the divisor
     * @return: the result
     */
    public int divide(int dividend, int divisor) {
        // write your code here
        // devidend a number means keep minuse the number. using *2 to make the code more efficient
        //special cases -> divisor != 0, dividend==0. return 1;
        if(divisor == 0) {
            return 0;
        }
        if(dividend == 0) {
            return 0;
        }
        long  absDivident = Math.abs((long)dividend);
        long  absDivisor = Math.abs((long)divisor);
        long ret = 0;
        while(absDivident >= absDivisor) {
            for(long base = absDivisor, count = 1;absDivident >= base; base<<= 1, count <<= 1){
                absDivident -= base;
                ret += count;
            }
        }
       ret = ((((dividend ^ divisor) >> 31) & 1) == 1) ? -ret: ret;

        if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int)ret;
        }
    }

}
