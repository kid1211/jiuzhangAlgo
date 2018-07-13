/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/

public class Solution {
    /*
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        
        // if(possibleSmallest == n ) {
        //     return 0;
        // }
        // if (SVNRepo.isBadVersion(possibleSmallest)) {
        //     return possibleSmallest ;
        // } else {
        //     return findFirstBadVersion(possibleSmallest + (n - possibleSmallest) / 2);
        // }
        
        int start = 1;
        int end = n;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
            
        }
        
        if(SVNRepo.isBadVersion(start)) {
            return start;
        }
        
        // if(SVNRepo.isBadVersion(end)) {
        //     return end;
        // }
        
        return end;


    }
}