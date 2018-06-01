package lintcode;

/**
 * CA
 * 103. 带环链表 II
 * https://www.lintcode.com/problem/linked-list-cycle-ii/description
 * @author wangw
 * @version $$Id: linked_list_cycle_ii, v 0.1 2018/6/1 0001 16:13 wangw Exp $$
 */
public class linked_list_cycle_ii {
    /*
        * @param head: The first node of linked list.
        * @return: The node where the cycle begins. if there is no cycle, return null
        */
    public ListNode detectCycle(ListNode head) {
        //双指针找到是否带环
        if(head == null){
            return null;
        }
        ListNode fast=head,slow=head;
        //典型的双指针
        while (true){
            if(fast.next==null || fast.next.next==null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(fast.equals(slow)){
                break;
            }
        }
        /*
        设表头到环的起始节点的距离为P 环的长度为C 两个指针相遇后 相遇点到环的起始结点的距离为L
        因为fast已进环,那么slow进环的时候,fast到slow的距离肯定是小于环的长度C的,而fast比slow快1,所以只要再走不到C步两者相遇. 推出结论1: L < C
        再根据两者的速度, slow走的长度是 P+L;fast走的长度是 P+L+n*C 又因为fast的速度是slow的两倍 推出结论2: P + L = n*C
        此时出现一个很有意思的现象 slow再前进P步,相当于前进了 n*C-L步,然后正好到了入环点的位置,
        那么,与此同时,有一个结点,设它为check从表头出发,也是一步一步走,当它走P步的时候,也到了入环点的位置,这两个指针刚好相遇!
        即,check与slow相遇的点就是入环点
         */
        ListNode check = head;
        while (true){
            if(check.equals(slow)){
                return check;
            }
            check = check.next;
            slow = slow.next;
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
