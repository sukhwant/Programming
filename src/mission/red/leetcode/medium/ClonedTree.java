package mission.red.leetcode.medium;

public class ClonedTree {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return inOrderTraversal(original, cloned, target);
    }

    private TreeNode inOrderTraversal(final TreeNode original, final TreeNode cloned,
        final TreeNode target) {

        if(original == null)
            return null;

        if(original.equals(target)){
            return cloned;
        }

        TreeNode leftAnswer = inOrderTraversal(original.left, cloned.left, target);
        if(leftAnswer != null)
            return leftAnswer;

        return inOrderTraversal(original.right, cloned.right, target);
    }

    public static void main(String[] args) {

    }
}
