// 62. Search in Rotated Sorted Array
//
// Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
// You are given a target value to search. If found in the array return its index, otherwise return -1.
//
// You may assume no duplicate exists in the array.
//
// Example
//
// For [4, 5, 1, 2, 3] and target=1, return 2.
//
// For [4, 5, 1, 2, 3] and target=0, return -1.
//
// Challenge
//
// O(logN) time

public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0) {
            return -1;
        }

        // get smallest point
        int smallest = getSmallestPoint(A);
        System.out.println("the smallest point " + smallest);
        // no rotated
        if(smallest == 0) {
            return binarySearch(A, 0, A.length -1, target);
        }
        if(A[A.length -1] < target) {
            if(A[smallest -1] < target) {
                return -1;
            }else {
                return binarySearch(A, 0, smallest-1, target);
            }
        }else {
            if(A[smallest] > target) {
                return -1;
            }else{
                return binarySearch(A, smallest, A.length-1, target);
            }
        }
    }

    private int getSmallestPoint(int[] A) {
        //skip edge cases
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            System.out.println("the mid point " + mid);
            if(mid == 0) {
                return mid;
            }
            if(A[mid] < A[mid-1]) {
                return mid;
            }
            if(A[mid] > A[mid-1]) {
                if(A[mid] > A[end]) {
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }

        return start;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        System.out.println("the start point " + start);
        System.out.println("the end point " + end);
        while(start + 1 < end) {
             int mid = start + (end - start) / 2;
             if(nums[mid] == target) {
                 return mid;
             }
             if(nums[mid] > target) {
                 end = mid;
             }else {
                 start = mid;
             }
        }
        if(nums[start] == target) {
            return start;
        }
        if(nums[end] == target) {
            return end;
        }

        return -1;
    }
}
