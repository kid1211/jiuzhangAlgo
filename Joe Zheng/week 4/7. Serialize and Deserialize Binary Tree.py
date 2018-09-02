"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""


class Solution:
    """
    @param root: An object of TreeNode, denote the root of the binary tree.
    This method will be invoked first, you should design your own algorithm 
    to serialize a binary tree which denote by a root node to a string which
    can be easily deserialized by your own "deserialize" method later.
    """
    def serialize(self, root):
        # write your code here
        if root is None:
            return None
        rtn = []
        # bfs
        q = collections.deque([root])
    
        #  '#' become the end of page variable
        while q:
            tmpNode = q.popleft()
            if tmpNode is None:
                rtn.append('#')
                continue
            rtn.append(tmpNode.val)
            q.append(tmpNode.left)
            q.append(tmpNode.right)
            

        # print(','.join(map(str, rtn)))
        return "{" + ','.join(map(str, rtn)) + "}"
        

    """
    @param data: A string serialized by your serialize method.
    This method will be invoked second, the argument data is what exactly
    you serialized at method "serialize", that means the data is not given by
    system, it's given by your own serialize method. So the format of data is
    designed by yourself, and deserialize it here as you serialize it in 
    "serialize" method.
    """
    def deserialize(self, data):
        # write your code here
        # strip the first and last one
        print(data)
        if data is None:
            return None
        data = data[1:-1]
        q = collections.deque(data.split(','))
        
        # root
        root = TreeNode(q.popleft())
        lastNodes = collections.deque([root])
        # will do a not first, so invert the init logic
        putLeft = False
        
        while q:
            # next node to be linked to tree
            tmp = q.popleft()
            
            if tmp is '#':
                # skip this around, but still need to toggle
                putLeft = not putLeft
                # if the turn is to put right, need to pop the first one from 
                # list
                if not putLeft:
                    lastNodes.popleft()
                continue
            tmp = TreeNode(tmp)
            
            # get the last one from the right
            lastNode = lastNodes.popleft()
            # toggle
            putLeft = not putLeft
            
            if putLeft:
                lastNode.left = tmp
                lastNodes.appendleft(lastNode)
            else:
                lastNode.right = tmp
            lastNodes.append(tmp)
                
        return root
# {1,2,2,4,5,6,3,5,6}
# {1,#, 2}
# {1,2,3,#,#,4,5}
            
                
            
