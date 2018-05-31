package lintcode;

/**
 * CA
 * 97. 二叉树的最大深度
 * https://www.lintcode.com/problem/maximum-depth-of-binary-tree/description
 * @author wangw
 * @version $$Id: maximum_depth_of_binary_tree, v 0.1 2018/5/31 0031 10:50 wangw Exp $$
 */
public class maximum_depth_of_binary_tree {

    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        // 这个就是很简单的分治法,把求结点的深度分成求2个子结点的深度,最大的+1就是此结点的最大深度
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }

    class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
