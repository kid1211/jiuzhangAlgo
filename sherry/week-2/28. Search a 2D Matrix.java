// 28. Search a 2D Matrix
//
// Write an efficient algorithm that searches for a value in an m x n matrix.
//
// This matrix has the following properties:
//
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
// Example
//
// Consider the following matrix:
//
// [
//     [1, 3, 5, 7],
//     [10, 11, 16, 20],
//     [23, 30, 34, 50]
// ]
// Given target = 3, return true.
//
// Challenge
//
// O(log(n) + log(m)) time
public class Solution {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        int rows  = matrix.length -1 ;
        int columns = matrix[0].length;

        //1. find the target row -> target is smaller than first in row i , row to half
        int[] targetRow = getTargetRow (matrix, target);
        return isExist(targetRow, target);

    }
    private boolean isExist(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) /2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[mid] < target) {
                start = mid;
            }else{
                end = mid;
            }
        }
        return nums[start] == target || nums[end] == target;
    }
    private int[] getTargetRow(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length -1;
        while(start +1 < end) {
            int mid = start + (end - start) / 2;
            if(matrix[mid][0] == target) {
                System.out.println("mid is " + mid);
                return matrix[mid];
            }
            if(matrix[mid][0] < target ){
                if(matrix[mid][matrix[mid].length-1] >= target) {
                    return matrix[mid];
                }
                start = mid;
            }else{
                end = mid;
            }
        }
        if(start != end) {
            if(matrix[end][0] > target) {
                //System.out.println(end);
                return matrix[start];
            }
        }
        return matrix[end];
    }
}
