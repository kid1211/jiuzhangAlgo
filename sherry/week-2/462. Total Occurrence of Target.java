public class Solution {
    /**
     * @param A: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int totalOccurrence(int[] A, int target) {
        // write your code here
        //xxxxoooo o -> >=target
        //edgecase
        if(A == null || A.length == 0) {
            return 0;
        }
        int firstTarget = getFirstTarget(A, target);
        int count = 0;
        while(firstTarget < A.length) {
            if(A[firstTarget] != target) {
                return count;
            }
            count++;
            firstTarget++;
        }
        return count;
    }

    private int getFirstTarget(int[] A, int target) {
        int start = 0;
        int end = A.length -1;
        //find first target element
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            //System.out.println(mid);
            if(A[mid] < target) {
                start = mid;
            }else {
                end = mid;
            }
        }
        if(A[start] == target) {
            return start;
        }
        return end;
    }
}
