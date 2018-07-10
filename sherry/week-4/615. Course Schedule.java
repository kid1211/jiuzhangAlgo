// 615. Course Schedule
//
// There are a total of n courses you have to take, labeled from 0 to n - 1.
//
// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
// Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//
// Example
//
// Given n = 2, prerequisites = [[1,0]]
// Return true
//
// Given n = 2, prerequisites = [[1,0],[0,1]]

//TODO: test version, using binary search to increase time complexity
public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        //prerequesities are direct nodes. so
        // 1. loop over to find all indegree, put in map<int, indegree>
        // 2. initailize a dequeue to search sort
        // 3. degree the ingree ->
        // return true if dequeue is null

        if(prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        HashMap<Integer, Integer> mapping = new HashMap();

        for(int[] pre : prerequisites) {
            //if [1, 0] -> incress degree of 0;
            if(mapping.containsKey(pre[1])){
                mapping.put(pre[1], mapping.get(pre[1])+1);
            }else{
                mapping.put(pre[1], 1);
            }
        }
        Arrays.sort(prerequisites, arrayComparator);
        Queue<Integer> dequeue = new LinkedList();
        for(int i = 0; i < numCourses; i++) {
            if(!mapping.containsKey(i)){
                dequeue.offer(i);
            }
        }
        // for(int i = 0; i < prerequisites.length; i++) {
        //     System.out.println(prerequisites[i][0] + " " + prerequisites[i] [1]);
        // }
        // how to deal with duplicate code
        // ERROR for duplicate code
        while(!dequeue.isEmpty()) {
            int head = dequeue.poll();
            // useing binary search to get
            if(getArrayForIndex(head, prerequisites) != null){
                for(int[] pre: getArrayForIndex(head, prerequisites)){
                    if(pre[0] == head) {
                        mapping.put(pre[1], mapping.get(pre[1]) - 1);
                        if(mapping.get(pre[1]) == 0) {
                            dequeue.offer(pre[1]);
                            mapping.remove(pre[1]);
                        }
                    }
                }
            }
        }
        if(mapping.isEmpty()) {
            return true;
        }
        return false;
    }

    final Comparator<int[]> arrayComparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0]-o2[0];
        }
    };

    private int[][] getArrayForIndex(int target, int[][] prerequisites) {
        int[][] result;
        int start = 0;
        int end = prerequisites.length - 1;
        int left = 0;
        int right = end;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(prerequisites[mid][0] >= target) {
                end = mid;
            }else{
                start = mid;
            }
        }
        if(prerequisites[start][0] == target) {
            left = start;
        }else {
            left = end;
        }
        start = 0;
        end = prerequisites.length - 1;
         while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(prerequisites[mid][0] <= target) {
                start = mid;
            }else{
                end = mid;
            }
        }
        if(prerequisites[end][0] == target) {
            right = end;
        }else {
            right = start;
        }
        if(right - left + 1 > 0) {
        result = new int[right-left + 1][2];
            for(int i = 0; i < result.length; i++) {
                result[i] = prerequisites[left + i].clone();
            }
            return result;
        }
        return null;
    }

}
