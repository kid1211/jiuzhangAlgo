public class Solution {


    public boolean isValidSudoku(char[][] board) {
        // write your code here
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char currentVal = board[i][j];
                if (currentVal == '.') {
                    continue;
                }
                if (!isValidInRow(board[i], currentVal)) {
                    return false;
                }
                if (!isValidInColume(board, i, j)) {
                    return false;
                }
                if (!isValidInBlock(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidInBlock(char[][] board, int row, int column) {
        int existTimes = 0;
        for (int i = row / 3 * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (column / 3) * 3; j < (column / 3) * 3 + 3; j++) {
                if (board[i][j] == board[row][column]) {
                    existTimes++;
                }
            }
        }
        return existTimes <= 1;
    }

    private boolean isValidInColume(char[][] board, int row, int column) {
        int existTimes = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] == board[row][column]) {
                existTimes++;
            }
        }
        return existTimes <= 1;
    }

    private boolean isValidInRow(char[] row, char currentVal) {
        int existTimes = 0;
        for (char c : row) {
            if (c == currentVal) {
                existTimes++;
            }
        }
        return existTimes <= 1;
    }


    //linked list -> using a next to connect
    // while all not null, merge. or copy
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, index = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }
        while (i >= 0) {
            A[index--] = A[i--];
        }
        while (j >= 0) {
            A[index--] = B[j--];
        }
    }

    /**
     * @param l1: The first list.
     * @param l2: The second list.
     * @return: the sum list of l1 and l2.
     */
    //solution need to know the length of the node first.
    //using reverse
    public ListNode addLists2(ListNode l1, ListNode l2) {
        //reverse the strings
        l1 = reverse(l1);
        l2 = reverse(l2);
        return reverse(addList1(l1, l2));

    }

    private ListNode addList1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;

        while (l1 != null && l2 != null) {
            tail.next = new ListNode((l1.val + l2.val + carry) % 10);
            tail = tail.next;
            carry = (l1.val + l2.val + carry) / 10;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            tail.next = new ListNode((l1.val + carry) % 10);
            tail = tail.next;
            carry = (l1.val + carry) / 10;

            l1 = l1.next;
        }
        while (l2 != null) {
            tail.next = new ListNode((l2.val + carry) % 10);
            tail = tail.next;
            carry = (l2.val + carry) / 10;

            l2 = l2.next;
        }

        while (carry != 0) {
            tail.next = new ListNode(carry % 10);
            tail = tail.next;
            carry = carry / 10;
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            //{1,2,3} -> head = 1, head.next = 2, head.next = prev -> temp = 2, prev = 1, head = 2
            //swap
            //{head{next -> } temp = next, }
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
