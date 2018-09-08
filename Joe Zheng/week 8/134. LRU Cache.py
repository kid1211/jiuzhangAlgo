class LinkedNode:

    def __init__(self, key=None, value=None, next=None):
        self.key = key
        self.value = value
        self.next = next


class LRUCache:
    """
    @param: capacity: An integer
    """

    def __init__(self, capacity):
        # do intialization if necessary
        self.head = LinkedNode()
        self.tail = self.head
        self.cap = capacity
        # Store the prev node as the key,value
        self.hashmap = {}

    def appendTail(self, node):
        self.hashmap[node.key] = self.tail
        self.tail.next = node
        self.tail = node

    def removeHead(self):
        # self.head is a dumjy node
        first = self.head.next
        # print(self.hashmap)
        del self.hashmap[first.key]
        self.head.next = first.next
        self.hashmap[self.head.next.key] = self.head

    def move2Tail(self, key):
        if key is self.tail.key:
            return
        prev = self.hashmap[key]
        curt = prev.next
        prev.next = curt.next

        # connect the link
        if curt.next is not None:
            self.hashmap[curt.next.key] = prev
            curt.next = None
        self.appendTail(curt)

    """
    @param: key: An integer
    @return: An integer
    """

    def get(self, key):
        # write your code here
        if key in self.hashmap:
            self.move2Tail(key)
            # print(self.hashmap)
            return self.tail.value
        return -1

    """
    @param: key: An integer
    @param: value: An integer
    @return: nothing
    """

    def set(self, key, value):
        # write your code here

        if key in self.hashmap:
            self.move2Tail(key)
            self.tail.value = value
            return

        self.appendTail(LinkedNode(key, value))
        if self.cap < len(self.hashmap):
            self.removeHead()

            # change value and do get stuff
        # else set it, append to the last node if < cap

    # Node operation
