class EvaluateBooleanBinaryTree {
  //no main function with tests inputs in this one too because
  //setting up the treenode structure for each test case is kind of annoying
  //this problem is pretty easy though
  public static boolean evaluateTree(TreeNode root) {
      TreeNode cur = root;
      
      if(cur.val < 2){
        if(cur.val == 0){
          return false;
        }
        return true;
      }
      
      int left = -1;
      int right = -1;
      

      left = cur.left.val;
      right = cur.right.val;
        
      boolean leftB = false;
      boolean rightB = false;
        
      if(left > 1){
        leftB = evaluateTree(cur.left);
      }else{
        if(left == 1){
          leftB = true;
        }
      }
        
      if(right > 1){
        evaluateTree(cur.right);
      }else{
        if(right == 1){
          rightB = true;
        }
      }
      
      if(cur.val == 2){
        return leftB || rightB;
      }
      return leftB && rightB;
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