class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isLevelValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isLevelValid(TreeNode root, long left, long right){
        if(root == null){
            return true;
        }
        
        if(root.val >= right || root.val <= left){
            return false;
        }

        return isLevelValid(root.left, left, (long) root.val) && isLevelValid(root.right, (long) root.val, right);
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