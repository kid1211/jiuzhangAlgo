import java.util.*;
import java.util.regex.Pattern;

public class Amazon {

    public String[] logSort(String[] logs) {
        if (logs == null || logs.length == 0) {
            return null;
        }
        List<List<String>> numbersLog = new ArrayList<>();
        List<List<String>> parsedLogs = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            String[] tempString = logs[i].split(" ", 2);
            if (stringContainsNumber(tempString[1])) {
                numbersLog.add(Arrays.asList(tempString));
            } else {
                parsedLogs.add(Arrays.asList(tempString));
            }

            Collections.sort(parsedLogs, new Comparator<List<String>>() {
                @Override
                public int compare(List<String> o1, List<String> o2) {
                    //compare index 1 first
                    int compareResult = compare(o1.get(1), o2.get(1));
                    if (compareResult == 0) {
                        // System.out.println(o1.get(0) + " " + o2.get(0));
                        compareResult = o1.get(0).compareTo(o2.get(0));
                    }
                    return compareResult;
                }

                private int compare(String s1, String s2) {
                    return s1.compareTo(s2);
                }
            });
        }
        //combine two array together
        parsedLogs.addAll(numbersLog);
        //change the string[] to string
        String[] result = new String[logs.length];
        for (int i = 0; i < logs.length; i++) {
            result[i] = parsedLogs.get(i).get(0) + " " + parsedLogs.get(i).get(1);
        }
        return result;
    }


    public boolean stringContainsNumber(String s) {
        return Pattern.compile("[0-9]").matcher(s).find();
    }

    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    class ResultType {
        TreeNode node;
        int max = Integer.MIN_VALUE;
        int sum;

        public ResultType(TreeNode node, int sum) {
            this.sum = sum;
            this.node = node;
        }
    }

    /**
     * @param root: the root of binary tree
     * @return: the maximum weight node
     */
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        ResultType result = getMaxSubtree(root);
        return result.node;
    }

    private ResultType getMaxSubtree(TreeNode node) {
        if (node == null) {
            return new ResultType(node, 0);
        }
        ResultType left = getMaxSubtree(node.left);
        ResultType right = getMaxSubtree(node.right);
        int sum = left.sum + right.sum + node.val;
        ResultType result = new ResultType(node, sum);
        //result.sum = sum;
        if (sum > left.max && sum > right.max) {
            //result.node = node;
            result.max = sum;
        } else if (left.max > right.max) {
            result.node = left.node;
            result.max = left.max;
        } else {
            result.node = right.node;
            result.max = right.max;
        }
        return result;
    }

    //How to implement it in O(1)
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here

        if(head == null) {
            return null;
        }

        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode prep, newNode;
        prep = dummy;
        Map<RandomListNode, RandomListNode> hashMap = new HashMap<>();
        while(head != null) {
            if(hashMap.containsKey(head)){
                newNode = hashMap.get(head);
            }else{
                newNode = new RandomListNode(head.label);
                hashMap.put(head, newNode);
            }
            prep.next = newNode;
            //get randome
            if(head.random != null) {
                if(hashMap.containsKey(head.random)) {
                    newNode.random = hashMap.get(head.random);
                }else{
                    newNode.random = new RandomListNode(head.random.label);
                    hashMap.put(head.random, newNode.random);
                }
            }
            prep = prep.next;
            head = head.next;
        }
        return dummy.next;
    }


    private class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    ;
}
