from collections import defaultdict
from collections import deque 

class _314_BinaryTreeVerticalOrderTraversal_FollowUp_BFS_DFS:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        columnTable = defaultdict(list)
        queue = deque([(root, 0)])

        while queue:
            node, column = queue.popleft()

            if node is not None:
                columnTable[column].append(node.val)
                queue.append((node.left, column - 1))
                queue.append(node.right, column + 1)
        
        return [columnTable[x] for x in range(min(columnTable), max(columnTable)+1)]
