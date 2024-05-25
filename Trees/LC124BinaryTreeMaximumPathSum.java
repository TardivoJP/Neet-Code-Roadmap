class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);

        return max;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        max = Math.max(max, root.val);

        if(root.left == null && root.right == null){
            return root.val;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        max = Math.max(max, (left+right+root.val));
        max = Math.max(max, left + root.val);
        max = Math.max(max, right + root.val);

        return Math.max(root.val, Math.max(left + root.val, right + root.val));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}