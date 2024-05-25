class KthSmallestElementInABST {
    int count = 0;
    int answer = -1;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return answer;
    }

    public void dfs(TreeNode root, int k){
        if(root == null || answer != -1){
            return;
        }

        dfs(root.left, k);
        count++;
        if(count == k){
            answer = root.val;
            return;
        }
        dfs(root.right, k);
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