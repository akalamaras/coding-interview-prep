package Learn.BinaryTrees;

import Support.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;

public class SerializeDeserializeBinaryTree {


    public String serialize(TreeNode root) {

        // Post order
        StringBuilder sb = new StringBuilder();

        helper(root,sb);
        return sb.toString();
    }

    private void helper(TreeNode root, StringBuilder sb) {

        if(root == null) {
            sb.append('X');
            sb.append('#');
            return;
        }

        sb.append(root.val);
        sb.append('#');

        helper(root.left, sb);
        helper(root.right, sb);

    }

    public TreeNode deserialize(String data) {

        ArrayDeque<String> nodes = new ArrayDeque<>(Arrays.asList(data.split("#")));
        return buildTree(nodes);


    }

    private TreeNode buildTree(ArrayDeque<String> nodes) {

        String val = nodes.remove();

        if(val.equals("X"))
            return null;
        else {

            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    public static void main(String[] args) {

        SerializeDeserializeBinaryTree sdbt = new SerializeDeserializeBinaryTree();

        TreeNode root = new TreeNode(4);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(6);
        root.left = left1;
        root.right = right1;
        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(3);
        left1.left = left2;
        left1.right = right2;
        TreeNode left3 = new TreeNode(5);
        TreeNode right3 = new TreeNode(7);
        right1.left = left3;
        right1.right = right3;


        System.out.println(sdbt.serialize(root));
    }
}
