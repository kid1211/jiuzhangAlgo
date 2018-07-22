18. Subsets II
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Example
Input: [1,2,2]
Output:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
Challenge
Can you do it in both recursively and iteratively?
public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList();
        if(nums == null) {
            return results;
        }

        Arrays.sort(nums);
        dfsHelper(nums, 0, new ArrayList(), results);

        return results;
    }

    private void dfsHelper(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results) {
        results.add(new ArrayList(subset));

        for(int i = startIndex; i < nums.length; i++) {
            //check duplicate
            if(i != 0 && nums[i] == nums[i -1 ]&& i > startIndex) {
                continue;
            }
            subset.add(nums[i]);
            dfsHelper(nums, i+1, subset, results);
            // the subset do not changes, it's always deep copy
            subset.remove(subset.size() - 1);
        }
    }
}
