"""
Definition of ListNode
class ListNode(object):

    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""


class Solution:
    """
    @param: head: the head of linked list.
    @return: a middle node of the linked list
    """

    def middleNode(self, head):
        # write your code here
        quickPointer = head
        slowPointer = head

        while(quickPointer != None
              and quickPointer.next != None
              and quickPointer.next.next != None):
            quickPointer = quickPointer.next.next
            slowPointer = slowPointer.next

        # print(slowPointer.val)
        return slowPointer
