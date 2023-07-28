package main.util.external_task;

import java.util.HashSet;
import java.util.Set;

public class TreeNodeTask {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(2)), new TreeNode(6, null, new TreeNode(7)));
        System.out.println(new TreeNodeTask().findTarget(node, 9));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private boolean findTarget(TreeNode root, int k) {
        Set<Integer> numbers = new HashSet<>();
        return helper(root, numbers, k);

    }

    private boolean helper(TreeNode node, Set<Integer> numbers, int k) {
        if (node == null) {
            return false;
        }
        if (node.val == k) {
            return true;
        }
        if (numbers.contains(k - node.val)) {
            return true;
        }
        numbers.add(node.val);
        return helper(node.left, numbers, k) || helper(node.right, numbers, k);
    }

}
