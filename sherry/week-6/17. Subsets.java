// 递归：实现方式，一种实现DFS算法的一种方式
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums == null) {
            return results;
        }

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        Arrays.sort(nums);
        helper(new ArrayList<Integer>(), nums, 0, results);
        return results;
    }


    // 递归三要素
    // 1. 递归的定义：在 Nums 中找到所有以 subset 开头的的集合，并放到 results
    private void helper(ArrayList<Integer> subset,
                        int[] nums,
                        int startIndex,
                        List<List<Integer>> results) {
        // 2. 递归的拆解
        // deep copy
        // results.add(subset);
        results.add(new ArrayList<Integer>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            // [1] -> [1,2]
            subset.add(nums[i]);
            // 寻找所有以 [1,2] 开头的集合，并扔到 results
            helper(subset, nums, i + 1, results);
            // [1,2] -> [1]  回溯
            subset.remove(subset.size() - 1);
        }

        // 3. 递归的出口
        // return;
    }
}

public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList();
        if(nums==null) {
            return null;
        }
       // List<Integer> l = new ArrayList();
        result.add(new ArrayList());
        Arrays.sort(nums);
        helper(nums, 0, result);
        return result;
    }

    private void helper(int[] nums, int end, List<List<Integer>> result) {
        if(end == nums.length) {
            return;
        }
        int size = result.size();
//        System.out.println(size);
//        System.out.println(result);
        for(int i = 0; i < size; i++) {
            //TODO: need to create new array first!
            List temp = new ArrayList(result.get(i));
            temp.add(new Integer(nums[end]));
            result.add(temp);
        }

        helper(nums, end+1, result);

    }
}

public List<List<Integer>> subset(int[] nums) {
  List<List<Integer>> results = new ArrayList();
  if(nums == null) {
    return null;
  }
  if(nums.lentgh == 0) {
    return results.add(new ArrayList());
  }
  //start statge
  dfs(nums, 0, new ArrayList<Integer>(), results);
  return results;
}
//defination of recrution
private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> results) {
  //return
  if(index == nums.length) {
      //deep copy
      results.add(new ArrayList<Integer>(subset));
    return;
  }
  //decompese
//pich num
//HGere is a loop for 0,1
  subset.add(num[index]);
  dfs(nums, index+1, subset, resutls );
  //don' t pick nums
  subset.remove(sebset.size()-1);
  dfs(nums, index+1, subset, results);
}


public List<List<Integer>> Solution {
  List<List<Integer>> results = new ArrayList();
  if(nums == null){
    return results ;
    arrays.sort(nums);
    dfs(nums, 0, new ArrayList<Integer, resutls);
  }
  return results;
}
private void dfs(int[] nums, int startIndex, list<Integer>> subset, List<List<Integer>> resutls ) {

  //every mote is a sulition
  resutls.add(new ArrayList(IntegeR<(subset)));
 for(int i = startIndex; i < nums.length; i++) {
   //[1] => [1,2]
   //start find all the subset with 1,2
    subset.add(nums[i]);
    dfs(nums, i+1, subset, results);
   //this liem alreadu finish all the possible sulution from 1,22

   //[1,2] -> [1]
   subset.remove(subset.esize() -1 );//backtracking
   }
}
