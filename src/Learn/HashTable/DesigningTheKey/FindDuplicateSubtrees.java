package Learn.HashTable.DesigningTheKey;

import Support.TreeNode;

import javax.swing.tree.TreeCellRenderer;
import java.util.*;

public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        if(root == null)
            return new LinkedList<>();

        HashMap<String,TreeNode> map = new HashMap<>();

        helper(root,map);

        List<TreeNode> list = new LinkedList<>();

        for(Map.Entry<String,TreeNode> e: map.entrySet()) {
            if( e.getValue() != null)
                list.add(e.getValue());
        }

        return list;


    }

    public String helper(TreeNode node, HashMap<String,TreeNode> map) {

        if(node.left == null && node.right == null) {
            String str = "" + node.val;

            if(!map.containsKey(str))
                map.put(str,null);
            else
                map.put(str,node);

            return str;
        }
        // post order
        String left = "";
        if(node.left != null)
            left = helper(node.left,map);

        String right = "";
        if(node.right != null)
            right = helper(node.right,map);

        // new subtree found -> put null; subtree already found -> put the subtree's root node
        String str = left + " # " + right + " # " + node.val;
        if(!map.containsKey(str))
            map.put(str,null);
        else
            map.put(str,node);

        return str;
    }

    class Better {


        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

            List<TreeNode> res = new ArrayList<>();
            if(root == null)
                return res;

            Map<String,Integer> map = new HashMap<>();
            helperTwo(root,map,res);
            return res;
        }

        private String helperTwo(TreeNode node, Map<String,Integer> map, List<TreeNode> list) {

            if(node == null)
                return "#";

            String left = helperTwo(node.left,map,list);
            String right = helperTwo(node.right,map,list);

            String key = node.val + "," + left + "," + right;

            int val = map.getOrDefault(key,0);
            if(val == 1)
                list.add(node);

            map.put(key,val+1);

            return key;

        }
    }
}
