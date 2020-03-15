package 树;

import java.util.Stack;

/**
 * @author sunjh
 * @date 2020/3/13 16:17
 */
public class TreeErgodic {
    public static void main(String[] args) {
        TreeNode treeNode = createTree();
        preOrder(treeNode);
        System.out.println();
        inOrder(treeNode);
        System.out.println();
        postOrder(treeNode);
    }

    public static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (null != node || !stack.isEmpty()) {
            while (null != node) {
                System.out.print(node.value + "->");
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                TreeNode tmp = stack.pop();
                node = tmp.right;
            }
        }
    }

    public static void inOrder(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (null != node || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                TreeNode tmp = stack.pop();
                System.out.print(tmp.value + "->");
                node = tmp.left;
            }
        }
    }

    public static void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode last = null;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                TreeNode tmp = stack.pop();
                if (tmp.right == null || tmp.right.equals(last)) {
                    System.out.print(tmp.value + "->");
                    last = tmp;
                } else {
                    stack.push(tmp);
                    node = tmp.right;
                }
            }
        }
    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode("a");
        TreeNode t1_1 = new TreeNode("b");
        TreeNode t1_2 = new TreeNode("c");
        TreeNode t2_1 = new TreeNode("d");
        TreeNode t2_2 = new TreeNode("e");
        TreeNode t2_3 = new TreeNode("f");
        TreeNode t2_4 = new TreeNode("g");
        root.left = t1_1;
        root.right = t1_2;
        t1_1.left = t2_1;
        t1_1.right = t2_2;
        t1_2.left = t2_3;
        t1_2.right = t2_4;
        return root;
    }

    /**
     * @author sunjh
     * @date 2020/3/13 23:32
     */
    public static class TreeNode {
        public String value;

        public TreeNode(String value) {
            this.value = value;
        }

        public TreeNode left;
        public TreeNode right;
    }
}
