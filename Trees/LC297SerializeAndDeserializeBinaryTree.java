import java.util.ArrayDeque;

class SerializeAndDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        String serialized = "";

        if(root == null){
            return serialized;
        }

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        serialized += String.valueOf(root.val) + "#";

        while(!q.isEmpty()){
            TreeNode cur = q.pollFirst();

            if(cur.left != null){
                serialized += String.valueOf(cur.left.val) + "#";
                q.offerLast(cur.left);
            }else{
                serialized += "N#";
            }

            if(cur.right != null){
                serialized += String.valueOf(cur.right.val) + "#";
                q.offerLast(cur.right);
            }else{
                serialized += "N#";
            }
        }

        return serialized;
    }

    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }

        String[] nodes = data.split("#");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int index = 1;
        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(!nodes[index].equals("N")){
                node.left = new TreeNode(Integer.parseInt(nodes[index]));
                q.offer(node.left);
            }
            index++;
            
            if(!nodes[index].equals("N")){
                node.right = new TreeNode(Integer.parseInt(nodes[index]));
                q.offer(node.right);
            }
            index++;
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