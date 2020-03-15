package 树;

/**
 * @author sunjh
 * @date 2020/3/15 20:58
 */

/*
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。

假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class 重建二叉树 {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        reConstructBinaryTree(pre, in);
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return constract(pre, in, 0, 0, pre.length);
    }

    private static TreeNode constract(int[] pre, int[] in, int preStart, int inStart, int len) {
        if (len <= 0) {
            return null;
        }
        if (len == 1) {
            return new TreeNode(pre[preStart]);
        }
        int index = indexOfArray(in, pre[preStart]);
        TreeNode left = null;
        TreeNode right = null;
        if (index != inStart) {
            int leftLen = index - inStart;
            left = constract(pre, in, preStart + 1, inStart, leftLen);
        }
        if (index != inStart + len) {
            int rightLen = len + inStart - index - 1;
            right = constract(pre, in, preStart + 1 + (index - inStart), inStart + 1 + (index - inStart), rightLen);
        }
        TreeNode tmp = new TreeNode(pre[preStart]);
        tmp.left = left;
        tmp.right = right;
        return tmp;
    }

    private static int indexOfArray(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
