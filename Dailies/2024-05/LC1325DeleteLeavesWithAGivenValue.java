class DeleteLeavesWithAGivenValue {
    //no main function with tests inputs in this one too because
    //setting up the treenode structure for each test case is kind of annoying
    //this problem is pretty straight forward though
    //leetcode itself also has a pretty cool tree visualization when running test cases
    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode cur = root;

        if(cur.left == null && cur.right == null){
            if(cur.val == target){
                return null;
            }else{
                return cur;
            }
        }

        if(cur.left != null){
            cur.left = removeLeafNodes(cur.left, target);
        }

        if(cur.right != null){
            cur.right = removeLeafNodes(cur.right, target);
        }
        
        if(cur.left == null && cur.right == null){
            if(cur.val == target){
                return null;
            }else{
                return cur;
            }
        }

        return cur;     
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