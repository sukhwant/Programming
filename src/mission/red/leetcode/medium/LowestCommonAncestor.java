package mission.red.leetcode.medium;

import java.util.LinkedList;
import java.util.List;


public class LowestCommonAncestor {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }

        public TreeNode(final int val, final TreeNode left,
            final TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pathP = new LinkedList<>();
        List<TreeNode> pathQ = new LinkedList<>();

        findPath(root, p, pathP);
        findPath(root, q, pathQ);

        // Compare...

        TreeNode curr = root;
        for(int i =0; i<pathP.size();i++){
            if(pathP.get(i) == pathQ.get(i)){
                curr = pathP.get(i);
            } else{
                break;
            }
        }
        return curr;
    }
    private boolean findPath(TreeNode root, TreeNode p, List<TreeNode> path)
    {
        if (root == null) {
            return false;
        }
        path.add(root);

        if (root == p) {
            return true;
        }
        if (root.left != null && findPath(root.left, p, path)) {
            return true;
        }
        if (root.right != null && findPath(root.right, p, path)) {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    public static void main(String[] args) {

        TreeNode left = new TreeNode(5, new TreeNode(6), new TreeNode(2,
            new TreeNode(7), new TreeNode(4)));
        TreeNode right = new TreeNode(1,
            new TreeNode(0),
            new TreeNode(8));
        TreeNode root = new TreeNode(3, left, right);

        TreeNode parent = new LowestCommonAncestor().lowestCommonAncestor(root, left, right);

    }
}
