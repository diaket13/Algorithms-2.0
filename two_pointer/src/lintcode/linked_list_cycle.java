package lintcode;

/**
 * CA
 * 102. 带环链表
 * https://www.lintcode.com/problem/linked-list-cycle/description
 * @author wangw
 * @version $$Id: linked_list_cycle, v 0.1 2018/5/31 0031 15:45 wangw Exp $$
 */
public class linked_list_cycle {
    /*
 * @param head: The first node of linked list.
 * @return: True if it has a cycle, or false
 */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if(head == null){
            return false;
        }
        ListNode fast=head,slow=head;
        //典型的双指针
        while (true){
            if(fast.next==null || fast.next.next==null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(fast.equals(slow)){
                return true;
            }
        }
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int val) {
          this.val = val;
          this.next = null;
      }
  }
}
