// 616. Course Schedule II
//
// There are a total of n courses you have to take, labeled from 0 to n - 1.
// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
// Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
//
// There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
//
// Example
//
// Given n = 2, prerequisites = [[1,0]]
// Return [0,1]
//
// Given n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
// Return [0,1,2,3] or [0,2,1,3]
public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        int[] result = new int[numCourses];

        if(prerequisites == null || prerequisites.length == 0) {
            for(int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }

        HashMap<Integer, Integer> mapping = new HashMap();
        //int[] result = new int[numCourses];
        int index = 0;
        for(int[] pre : prerequisites) {
            //if [1, 0] -> incress degree of 0;
            if(mapping.containsKey(pre[0])){
                mapping.put(pre[0], mapping.get(pre[0])+1);
            }else{
                mapping.put(pre[0], 1);
            }
        }
        //System.out.println(mapping);
        Arrays.sort(prerequisites, arrayComparator);
        Queue<Integer> dequeue = new LinkedList();
        for(int i = 0; i < numCourses; i++) {
            if(!mapping.containsKey(i)){
                dequeue.offer(i);
                result[index] = i;
                index++;
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
                    if(pre[1] == head) {
                        mapping.put(pre[0], mapping.get(pre[0]) - 1);
                        if(mapping.get(pre[0]) == 0) {
                            dequeue.offer(pre[0]);
                            mapping.remove(pre[0]);
                            result[index] = pre[0];
                            index++;
                        }
                    }
                }
            }
        }
        if(mapping.isEmpty()) {
            return result;
        }
        return new int[0];
    }

    final Comparator<int[]> arrayComparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1]-o2[1];
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
            if(prerequisites[mid][1] >= target) {
                end = mid;
            }else{
                start = mid;
            }
        }
        if(prerequisites[start][1] == target) {
            left = start;
        }else {
            left = end;
        }
        start = 0;
        end = prerequisites.length - 1;
         while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(prerequisites[mid][1] <= target) {
                start = mid;
            }else{
                end = mid;
            }
        }
        if(prerequisites[end][1] == target) {
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
