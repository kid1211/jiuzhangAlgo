import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    /**
     * @param A: An integer array
     * @param queries: The query list
     * @return: The number of element in the array that are smaller that the given integer
     */
    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        // sort the array first and using binary search to get the index of the number
        if(A == null) {
            return null;
        }
        List<Integer> resultSet = new ArrayList<>();
        Arrays.sort(A);

        for(int i : queries) {
            resultSet.add(getFloorIndexOfVal(A, i) + 1);
        }

        return resultSet;
    }

    private Integer getFloorIndexOfVal(int[] nums, int k) {
        if(nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length -1;
        while(start +1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] >= k) {
                end = mid;
            }else {
                start = mid;
            }
        }
        //check the last element
        if(nums[end] >= k) {
            if(nums[start] >= k) {
                return -1;
            }
            return start;
        }
        return end;

    }

}
