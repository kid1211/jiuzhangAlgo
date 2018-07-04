// 3Sum
// 57. 3Sum

// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
// Example
//
// For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
//
// (-1, 0, 1)
// (-1, -1, 2)
public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        // edge case
        if (numbers == null || numbers.length < 3) {
            return null;
        }
        List<List<Integer>> resultList = new ArrayList();
        //sort the numbers
        Arrays.sort(numbers);
        // a + b = -c -> loop the target from 2 to len-1
        int targetIndex =2;
        while (targetIndex < numbers.length) {
            targetIndex = getNextTargetIndex(targetIndex, numbers);
            int start  = 0;
            int end = targetIndex - 1;
            //valid the index not IndexOutOfBoundsException
            resultList.addAll(getTwoSumsBeforeTargetIndex(numbers, targetIndex));
            targetIndex++;
        }
        return resultList;
    }

    private List<List<Integer>> getTwoSumsBeforeTargetIndex(int[] nums, int targetIndex) {
        List<List<Integer>> resultList = new ArrayList();
        int start = 0;
        int end = targetIndex - 1;
        while(start < end) {
            if(nums[start] + nums[end] == - nums[targetIndex]) {
                List<Integer> result = new ArrayList();
                result.add(nums[start]);
                result.add( nums[end]);
                result.add(nums[targetIndex]);
                resultList.add(result);
                while(start < targetIndex && nums[start] == nums[start + 1]) {
                    start++;
                }
                while(end > 0 && nums[end] == nums[end - 1]) {
                    end--;
                }
                start++;
                end--;
            }else if(nums[start] + nums[end] < - nums[targetIndex]) {
                start++;
            }else {
                end--;
            }
        }
        return resultList;
    }

    private int getNextTargetIndex(int index, int[] numbers) {
        while(index< numbers.length) {
            if((index < numbers.length - 1) && numbers[index] == numbers[index + 1]) {
                //System.out.println(index);
                index++;
            }else {
                //System.out.println(index);
                return index;
            }
        }
        return index;
    }
}
