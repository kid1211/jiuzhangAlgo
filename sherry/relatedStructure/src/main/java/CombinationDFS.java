import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationDFS {
    /**
     * @param candidates: A list of integers
     * @param target:     An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) {
            return result;
        }
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, combination, result);
        return result;
    }

    protected void dfs(int[] candidates, int index, int target, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            // skip all equles value
            if (i != 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], combination, result);
            //remove last element for backtrack
            combination.remove(combination.size() - 1);
        }
    }

    private int[] removeDuplicate(int[] candidates) {
        Arrays.sort(candidates);
        int index = 0;
        // using two pointer
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] != candidates[index]) {
                candidates[++index] = candidates[i];
            }
        }
        int[] nums = new int[index + 1];
        nums = Arrays.copyOf(candidates, index + 1);
        return nums;
    }

    protected void dfsWithNoReuse(int[] nums, int index, int target, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList(combination));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            combination.add(nums[i]);
            dfsWithNoReuse(nums, i + 1, target - nums[i], combination, result);
            combination.remove(combination.size() - 1);
        }
    }

    protected void dfsWithKItems(int[] nums, int startIndex, int leftItems, int target, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0 && leftItems == 0) {
            result.add(new ArrayList(combination));
            return;
        }
        if (leftItems < 0 || target < 0) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            combination.add(nums[i]);
            dfsWithKItems(nums, i + 1, leftItems - 1, target - nums[i], combination, result);
            combination.remove(combination.size() - 1);
        }
    }

    protected void dfsWithPartitionString(String s,
                                          int index,
                                          List<String> combination,
                                          List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList(combination));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String subString = s.substring(index, i + 1);
            if (!isPalindrome(subString)) {
                continue;
            }
            combination.add(subString);
            dfsWithPartitionString(s, i + 1, combination, result);
            combination.remove(combination.size() - 1);

        }
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
// partition with memory search?
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        boolean[][] isPalindromes = new boolean[s.length()][s.length()];
        getIsPalindromes(s, isPalindromes);
        helper(s, 0, new ArrayList<String>(), result, isPalindromes);
        return result;
    }

    private void helper(String s, int startIndex, ArrayList<String> combination, List<List<String>> result, boolean[][] isPalindromes) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<String>(combination));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (!isPalindromes[startIndex][i]) {
                continue;
            }
            combination.add(s.substring(startIndex, i));
            helper(s, i + 1, combination, result, isPalindromes);
            combination.remove(combination.size() - 1);

        }
    }

    private void getIsPalindromes(String s, boolean[][] isPalindromes) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            isPalindromes[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            isPalindromes[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        for (int i = n - 3; i > 0; i--) {
            for (int j = i + 2; j < n; j++) {
                isPalindromes[i][j] = isPalindromes[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
    }

    protected void dfsWithWordSplit(String s, int startIndex, List<String> combination, List<List<String>> result) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList(combination));
            return;
        }
        // the idea here is :
        // there's no for loop, only two combination.
//        if (startIndex + 1 <= s.length()) {
//            combination.add(s.substring(startIndex, startIndex + 1));
//            dfsWithWordSplit(s, startIndex + 1, combination, result);
//            combination.remove(combination.size() - 1);
//        }
//
//        if (startIndex + 2 <= s.length()) {
//            combination.add(s.substring(startIndex, startIndex + 2));
//            dfsWithWordSplit(s, startIndex + 2, combination, result);
//            combination.remove(combination.size() - 1);
//        }
//
        //this part could replace by
        // in this method, each for loop will run twice
        // consider from last element back
        for (int i = startIndex; i < startIndex + 2 && i < s.length(); i++) {
            String subString = s.substring(startIndex, i + 1);
            combination.add(subString);
            dfsWithWordSplit(s, i + 1, combination, result);
            combination.remove(combination.size() - 1);
        }

        return;
    }
}
