public class Solution {
    /*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public static double myPow(double x, int n) {
        // write your code here

        if(n == 1) {
            return x;
        }

        if(n == 0) {
            return 1;
        }

//        int i = 0;
//        while (i <= n) {
//            i++;
//        }

        double rtn = 1.0;

        for(int i = 0; i < n; i++) {
            rtn *= x ;
        }
        return rtn;
    }

    public static void main(String[] args) {

        System.out.println("\n\nHello World!"); // Display the string.
        System.out.println("1: 9.261 = " + myPow(2.1,3)); // Display the string.
        System.out.println("1: 0 = " + myPow(0,1)); // Display the string.
        System.out.println("1: 1 = " + myPow(1,0)); // Display the string.
    }

}