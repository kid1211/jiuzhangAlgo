public class Solution {
    /*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public static double myPow(double x, int n) {
        // write your code here

        if(n == 1 || x == 0) {
            return x;
        }


        if(n == 0) {
            return 1;
        }



        double rtn = 1.0;


        if(n < 0) {

            //does it reach interger's maximum?
            if(n == -n) {
                return 0.0;
            }

            x = 1/x;
            n = -n;

        }



        for(int i = 0; i < Math.abs(n); i++) {
            rtn = rtn * x;
        }
        return rtn;
    }

    public static void main(String[] args) {

        System.out.println("\n\nHello World!"); // Display the string.

        System.out.println("1: 9.261 = " + myPow(2.1,3)); // Display the string.
        System.out.println("1: 0 = " + myPow(0,1)); // Display the string.
        System.out.println("1: 1 = " + myPow(1,0)); // Display the string.
        System.out.println("1: 0.0625 = " + myPow(4,-2)); // Display the string.

        System.out.println("1: 0.0000 = " + myPow(2.00000,-2147483648)); // Display the string.
        System.out.println("1: 0.0000 = " + myPow(2.00000,20)); // Display the string.



    }

}