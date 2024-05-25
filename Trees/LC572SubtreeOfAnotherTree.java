class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }

        if(checkSubTree(root, subRoot)){
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean checkSubTree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }else if (root == null || subRoot == null){
            return false;
        }

        if(root.val != subRoot.val){
            return false;
        }

        return checkSubTree(root.left, subRoot.left) && checkSubTree(root.right, subRoot.right);
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