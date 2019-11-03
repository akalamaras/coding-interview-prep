package Companies.Cisco.SecondGo.Trees;

import Support.TreeNode;

public class ClosestBSTValue {

    public int closestVal(TreeNode root, int target) {

        int a = root.val;
        TreeNode child = (a < target) ? root.left : root.right;
        if(child == null)
            return a;

        int b = closestVal(child, target);
        if(Math.abs(a - target) < Math.abs(b - target))
            return a;
        else
            return b;
    }
}
