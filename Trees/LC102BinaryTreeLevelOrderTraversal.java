import java.util.ArrayList;
import java.util.List;

class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();

        if(root != null){
            List<TreeNode> start = new ArrayList<>();
            start.add(root);
            bfs(start, answer);
        }

        return answer;
    }

    public void bfs(List<TreeNode> nextVisits, List<List<Integer>> answer){
        List<TreeNode> next = new ArrayList<>();
        List<Integer> level = new ArrayList<>();

        for(TreeNode node : nextVisits){
            level.add(node.val);
            if(node.left != null){next.add(node.left);}
            if(node.right != null){next.add(node.right);}
        }

        if(level.size() > 0){answer.add(level);}

        if(next.size() > 0){
            bfs(next, answer);
        }
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