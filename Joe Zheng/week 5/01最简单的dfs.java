public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }

        // because we only want 123, don't want 321
        Arrays.sort(nums);

        df(nums, 0, new ArrayList<Integer>(), results);
        return results;

    }

    // 1. 递归的定义
    private void dfs(int[] nums,
                    int index,
                    List<Integer> subset,
                    List<List<Integer>> results){      
        // 3.递归的出口
        if(index == nums.length){
            // deep copy
            results.add(new ArrayList<Integer>(subset));
            return;
        }
        // 2.递归的拆解
        //选 nums[index]
        subset.add(nums[index]);
        dfs(nums, index + 1, subset, results);
        
        //不选 nums[index]删掉一个最后的书
        subset.remove(subset.size() - 1);
        dfs(nums, index + 1, subset, results)
    }
}