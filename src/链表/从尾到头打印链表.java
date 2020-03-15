package 链表;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author sunjh
 * @date 2020/3/15 16:14
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/*
输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class 从尾到头打印链表 {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = listNode;
        while (null != node) {
            stack.push(node);
            node = node.next;
        }
        ArrayList<Integer> list = new ArrayList<>(stack.size());
        while (!stack.isEmpty()) {
            list.add(stack.pop().val);
        }
        return list;
    }
}
