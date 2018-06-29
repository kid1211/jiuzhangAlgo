// 428. Pow(x, n)
//
// Implement pow(x, n).
//
// Example
//
// Pow(2.1, 3) = 9.261
// Pow(0, 1) = 0
// Pow(1, 0) = 1
// Challenge
//
// O(logn) time
public class Solution {
    /*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        // write your code here
        // recruse
        // x^(n/2)*x^(n/2)
        // end of recruse: n = 1 -> x
        // consider n%2 == 0
        // if n is negertive: result = 1/x
        if (n == 0){
            return 1;
        }else{
            if (n > 0){
                // if the number is to small, stop recruse
                if ( myPow(x,n/2) * Integer.MAX_VALUE == 0){
                    return 0;
                }
                // Chech this part, if n = 3, n/2 = 1.5, then a x is missing
            if (n%2 == 0){
                return myPow(x,n/2) * myPow(x,n/2);
            }else{
                return myPow(x,n/2) * myPow(x,n/2) * x;
                }
            }else{
                x = 1/x;
                if (n == Integer.MIN_VALUE ){
                    n = - (n + 1);
                    return myPow(x,n) / x;
                }else{
                    return myPow(x,-n);
                }
            }
        }
    }
}
