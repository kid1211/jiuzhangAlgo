# v1
"""
Definition of ListNode
class ListNode(object):

    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""
from heapq import heappop, heappush

class Solution:
    """
    @param lists: a list of ListNode
    @return: The head of one sorted list.
    """
    def mergeKLists(self, lists):
        if not lists:
            return None
        
        trav = dummy = ListNode(-1)
        heap = []
        self.i = 1
        def heappushNode(heap, node):
            self.i += 1
            heappush(heap, (node.val, self.i, node))
        for ll in lists:
            if ll:
                heappushNode(heap, ll)
                
        while heap:
            _, _, node = heappop(heap)
            trav.next = node
            trav = trav.next
            #print(trav.val)
            if trav.next:
                heappushNode(heap, trav.next)
                
                    
        return dummy.next
            

        
# version2的TypeError是因为在heappush的时候tuple里面有（node2.val, node2），如果原本heap里就有一个（node1.val, node1）, node2.val == node1.val, node2 != node1，那么在插入时比较完node.val之后还要继续比较node。但是两个node之间不能进行'<'比较，所以报错。改正的话，在tuple里的node前面再加一个数，保证不会比较到node就行了。
        