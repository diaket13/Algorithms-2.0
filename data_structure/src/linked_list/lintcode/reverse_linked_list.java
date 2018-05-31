package linked_list.lintcode;

/**
 * 35. 翻转链表
 * https://www.lintcode.com/problem/reverse-linked-list/description
 * @author wangw
 * @version $$Id: reverse_linked_list, v 0.1 2018/5/31 0031 11:09 wangw Exp $$
 */
public class reverse_linked_list {
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode previous = null;
        ListNode next;
        while (head.next != null) {
            next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        head.next = previous;
        return head;
    }

    /*便于理解 写个递归 head为当前node,previous为当前结点之前的结点
    * 每次都找出head的下一个结点next,然后将previous变成head的next
    * 接着head为previous,next为head,继续递归*/
    ListNode reverse(ListNode head, ListNode previous) {
        if (head.next == null) {
            head.next = previous;
            return head;
        }
        ListNode next = head.next;
        head.next = previous;
        return reverse(next, head);
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
