class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<Integer> precedessor = new ArrayDeque<>();
        Deque<Integer> successor = new ArrayDeque<>();

        getPredecessor(root, target, precedessor);
        getSuccessor(root, target, successor);

        for (int i = 0; i < k; i++) {
            if (precedessor.isEmpty()) {
                result.add(successor.pop());
            } else if (successor.isEmpty()) {
                result.add(precedessor.pop());
            } else if (Math.abs((double) precedessor.peek() - target) < Math.abs((double) successor.peek() - target)) {
                result.add(precedessor.pop());
            } else {
                result.add(successor.pop());
            }
        }

        return result;
    }

    private void getPredecessor(TreeNode root, double target, Stack<Integer> precedessor) {
        if (root == null) {
            return;
        }

        getPredecessor(root.left, target, precedessor);

        if (root.val > target) {
            return;
        }

        precedessor.push(root.val);

        getPredecessor(root.right, target, precedessor);
    }

    private void getSuccessor(TreeNode root, double target, Stack<Integer> successor) {
        if (root == null) {
            return;
        }

        getSuccessor(root.right, target, successor);

        if (root.val <= target) {
            return;
        }

        successor.push(root.val);

        getSuccessor(root.left, target, successor);
    }
}
