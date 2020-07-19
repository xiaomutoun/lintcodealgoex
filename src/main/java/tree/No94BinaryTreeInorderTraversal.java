package tree;

import java.util.ArrayList;
import java.util.List;

/** Tag: Binary Tree, Traversal, Recursive, Iterative
 * Tree Traversals (Inorder, Preorder and Postorder)
 *         1
 *      2   3
 *    4  5
 *  Depth First Traversals:
 *  (a) Inorder (Left, Root, Right) : 4 2 5 1 3
 *  (b) Preorder (Root, Left, Right) : 1 2 4 5 3
 *  (c) Postorder (Left, Right, Root) : 4 5 2 3 1
 *  Breadth First or Level Order Traversal : 1 2 3 4 5
 */
public class No94BinaryTreeInorderTraversal {

    // Inorder traversal recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        else {
            List<Integer> leftRes = inorderTraversal(root.left);
            List<Integer> rightRes = inorderTraversal(root.right);
            leftRes.add(root.val);
            leftRes.addAll(rightRes);
            return leftRes;
        }
    }

    public List<Integer> inordertraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<TreeNode> nodeList = new ArrayList<>();
        if (root != null) nodeList.add(root);
        while (nodeList.size() > 0) {
            int size = nodeList.size();
            TreeNode node = nodeList.get(size - 1);
            if (node.left == null) {
                result.add(node.val);
                nodeList.remove(node);
                if (node.right != null) nodeList.add(node.right);
            } else {
                nodeList.add(node.left);
                node.left = null;
            }
        }
        return result;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

