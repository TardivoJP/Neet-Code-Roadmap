class DistributeCoinsInBinaryTree {
    public static int moves;

    public static int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }

    public static int dfs(TreeNode current) {
        if (current == null)
            return 0;

        int leftCoins = dfs(current.left);
        int rightCoins = dfs(current.right);

        moves += Math.abs(leftCoins) + Math.abs(rightCoins);

        return (current.val - 1) + leftCoins + rightCoins;
    }

    public static class TreeNode {
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
