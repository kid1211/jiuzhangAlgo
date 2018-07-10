// 433. Number of Islands
//
// Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.
//
// Find the number of islands.
//
// Example
//
// Given graph:
//
// [
//   [1, 1, 0, 0, 0],
//   [0, 1, 0, 0, 1],
//   [0, 0, 0, 1, 1],
//   [0, 0, 0, 0, 0],
//   [0, 0, 0, 0, 1]
// ]
// return 3.

public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        // to find all islands, we need search all area to get the number
        // implements matrix
        // question: how to translate it to an graph? find first unzero point
        // for [i][j]-> set to save flowing line's j i -> neighbors, j-> in neighbers neighbers if not add to new

        // chanledge how to make set for 2d array using index -> n*i.length + j
        //edge case need to validate length == 0
        if(grid == null || grid.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet();
        Queue<Integer> queue = new LinkedList();
        int count = 0;
        int length = grid[0].length;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]) {
                    int temp = i*grid[i].length + j;
                    if(!set.contains(temp)){
                        queue.offer(temp);
                        set.add(temp);
                        count++;
                        //add all to set
                        while(!queue.isEmpty()){
                            Integer head = queue.poll();
                            //System.out.println(head);
                            if(head % length > 0){
                                if(grid[head/length][head%length-1]) {
                                    if(!set.contains( head-1)) {
                                        set.add( head-1);
                                        queue.offer( head-1);
                                    }
                                }
                            }
                            if(head % length < length - 1) {
                              if(grid[head/length][head % length + 1]) {
                                    if(!set.contains(head + 1)) {
                                    set.add(head + 1);
                                    queue.offer(head + 1);
                                    }
                              }
                            }
                            if(head/length < grid.length - 1) {
                              if(grid[head/length+1][head%length]) {
                                if(!set.contains(head+length)){
                                    set.add(head+ length);
                                    queue.offer(head+ length);
                                    }
                                }
                            }
                            if(head/length > 0) {
                              if(grid[head / length - 1][head % length]) {
                                if(!set.contains(head - length)){
                                    set.add(head - length);
                                    queue.offer(head - length);
                                    }
                                }
                            }
                            //System.out.println(set);
                        }
                    }
                }
            }
        }
        return count;
    }
}
