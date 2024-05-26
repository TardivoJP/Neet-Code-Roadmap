import java.util.HashMap;

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderIndexMap);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inorderIndexMap){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int middle = inorderIndexMap.get(preorder[preStart]);
        int leftTreeSize = middle - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + leftTreeSize, inorder, inStart, middle - 1, inorderIndexMap);
        root.right = buildTree(preorder, preStart + leftTreeSize + 1, preEnd, inorder, middle + 1, inEnd, inorderIndexMap);

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