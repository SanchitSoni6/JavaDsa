# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # Empty tree
        if not root:
            return []

        res = []

        # Stack containing nodes of the current level
        nodesStack = []
        nodesStack.append(root)

        # Tracks the direction of the current level
        rightToLeft = True

        while nodesStack:
            res.append([])

            # Process the current level and create a new stack for the next level
            curStack = nodesStack
            nodesStack = []

            # Alternate the traversal direction
            rightToLeft = not rightToLeft

            while curStack:
                # Pop nodes according to the current level's direction
                curNode = curStack.pop()
                res[-1].append(curNode.val)

                if rightToLeft:
                    # Push right first so left is processed first when popped
                    if curNode.right:
                        nodesStack.append(curNode.right)
                    if curNode.left:
                        nodesStack.append(curNode.left)
                else:
                    # Push left first so right is processed first when popped
                    if curNode.left:
                        nodesStack.append(curNode.left)
                    if curNode.right:
                        nodesStack.append(curNode.right)

        return res