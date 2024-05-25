class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((root == p || root == q) || (p.val > root.val && q.val < root.val) || (p.val < root.val && q.val > root.val)){
            return root;
        }

        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        
        return root;
    }

    public TreeNode lowestCommonAncestorClever(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(p.val > root.val && q.val > root.val){
                root = root.right;
            }else if(p.val < root.val && q.val < root.val){
                root = root.left;
            }else{
                break;
            }
        }

        return root;
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