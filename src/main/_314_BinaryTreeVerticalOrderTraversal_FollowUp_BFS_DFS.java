package src.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _314_BinaryTreeVerticalOrderTraversal_FollowUp_BFS_DFS {
    // BFS
    public List<List<Integer>> verticalOrder_BFS(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Map<Integer, List<Integer>> cacheMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> idxs = new LinkedList<>();
        queue.add(root);
        idxs.add(0);
        int leftMost = 0;
        int rightMost = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int idx = idxs.poll();
            int val = node.val;
            cacheMap.putIfAbsent(idx, new ArrayList<>());
            cacheMap.get(idx).add(val);

            if (node.left != null) {
                queue.add(node.left);
                leftMost = Math.min(leftMost, idx - 1);
                idxs.add(idx - 1);
            }

            if (node.right != null) {
                queue.add(node.right);
                rightMost = Math.max(rightMost, idx + 1);
                idxs.add(idx + 1);
            }
        }

        for (int i = leftMost; i <= rightMost; i++){
             ans.add(cacheMap.get(i));
        }

        return ans;
    }
    
    
    // This DFS correct https://leetcode.com/problems/binary-tree-vertical-order-traversal/solutions/3066220/dfs-java/
    List<List<Integer>> ans = new ArrayList<>();
    Map<Integer, List<Integer>> cacheMap = new HashMap<>();

    int min = 0, max = 0;
    public List<List<Integer>> verticalOrder_DFS(TreeNode root) {
        if (root != null)
           dfsPreOrder(root, 0);
        for (int i = min; i <= max; i++){
             ans.add(cacheMap.get(i));
        }
        return ans;
    }

   private void dfsPreOrder(TreeNode root, int index){
       if (root == null) {
           return;
       }

       cacheMap.putIfAbsent(index, new ArrayList<>());
       cacheMap.get(index).add(root.val);
       dfsPreOrder(root.left, index - 1);
       dfsPreOrder(root.right, index + 1);
       min = Math.min(min, index);
       max = Math.max(max, index);
   }
}
