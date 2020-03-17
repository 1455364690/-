package 链表;

/**
 * @author sunjh
 * @date 2020/3/16 11:26
 */

public class 链表中是否存在环 {
    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head) {
        if (null == head){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null){
            if (slow.equals(fast)){
                return true;
            }else{
                slow = slow.next;
                fast = fast.next;
                if (fast == null){
                    return false;
                }else{
                    fast = fast.next;
                }
            }
        }
        return false;
    }
}
