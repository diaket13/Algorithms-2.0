package lintcode;

/**
 * CA
 * 174. 删除链表中倒数第n个节点
 * https://www.lintcode.com/problem/remove-nth-node-from-end-of-list/description
 * @author wangw
 * @version $$Id: remove_nth_node_from_end_of_list, v 0.1 2018/5/30 0030 17:48 wangw Exp $$
 */
public class remove_nth_node_from_end_of_list {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //这个是要删除的结点的前面的结点
        ListNode deleteNode = head;
        //这是头
        ListNode node = head;
        //开始遍历列表,妈的这是双指针,换地方换地方(原来放到链表的目录里了)
        while (node.next != null){
            /*
                原理很简单,等遍历的指针往下走了n次后,这个删除结点再同步跟着往下走.
                那么 deleteNode 和 node 就相差了n个结点
                当node的next为最后一个结点的时候,deleteNode为倒数第n+1个结点
             */
            if(n>0){
                n--;
            }else {
                deleteNode = deleteNode.next;
            }
            node = node.next;
        }
        //遍历完了n还大于0,不用想,把头结点删了
        if(n > 0){
            return head.next;
        }
        //把deleteNode后面的结点删了
        deleteNode.next = deleteNode.next.next;
        return head;
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
