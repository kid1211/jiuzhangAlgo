public class Solution {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public static int fastPower(int a, int b, int n) {
        // write your code here
        // a^n%b
        if (a == 0 || b == 0) {
            return 0;
        }

        if (b == Integer.MAX_VALUE) {
            return a;
        }

        if (n == 0 || a == 1) {
            return 1 % b;
        }

        if (n == 1 || n == -1) {
            return a % b;
        }

        // double pow = a;
        if (n < -1) {
            return 0;
        }

        int rtn = 1;
        for (int i = 0; i < n; i++) {
            rtn = rtn * a % b;
        }
        // 4247343
        return rtn;
    }

    public static void main(String[] args) {

        System.out.println("\n\nHello World!"); // Display the string.

        System.out.println("1: 2 = " + fastPower(2, 31, 3)); // Display the string.
        System.out.println("1: 0 = " + fastPower(100, 1000, 1000)); // Display the string.
        // System.out.println("1: 1 = " + fastPower(1,0)); // Display the string.
        // System.out.println("1: 0.0625 = " + fastPower(4,-2)); // Display the string.
        //
        // System.out.println("1: 0.0000 = " + fastPower(2.00000,-2147483648)); //
        // Display the string.
        // System.out.println("1: 0.0000 = " + fastPower(2.00000,20)); // Display the
        // string.

    }

}