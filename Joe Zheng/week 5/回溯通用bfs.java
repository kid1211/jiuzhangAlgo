public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums == null) {
            return results;
        }

        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), results);
    }

    private void dfs(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results) {
        // 之前宣和不选我们要判断是不是走到了最后一层
        // 这里不用，因为每一个节点都是我们想要的内容

        result.add(new ArrayList<Integer>(subset));

        // 第几个数开始 start startIndex
        for (int i = startIndex; i < nums.length; i++) {
            // 加判断， 有序性
            // if (subset.size() >0 && subset.get(subset.size() - 1) >= nums[i]) {
            // continue;
            // }

            // [1]=>[1,2]
            // 去寻找以 [1,2]开头的所有子集
            // 思维方式不要往下深入，我找完了所有1，2开头的我要做啥？
            subset.add(nums[i]);
            dfs(nums, i + 1, subset, results);
            // [1,2] => [1]
            // 底下这一部分就是回溯 backtracking
            subset.remove(subset.size() - 1);
        }

    }
}

// 第二种方式是在dfs前面做deep copy然后在继续做 每次进来function就不需要创建一个新的了