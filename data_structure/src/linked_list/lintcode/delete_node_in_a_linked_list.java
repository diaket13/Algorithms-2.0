package linked_list.lintcode;

/**
 * CA
 * 372. Delete Node in a Linked List
 * https://www.lintcode.com/problem/delete-node-in-a-linked-list/description
 * @author wangw
 * @version $$Id: delete_node_in_a_linked_list, v 0.1 2018/5/30 0030 17:23 wangw Exp $$
 */
public class delete_node_in_a_linked_list {


     /*
     * @param node: the node in the list should be deletedt
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        //怎么样无须改变上一个结点的指向而删除结点.偷梁换柱,将这个结点变成下一个结点,然后清空原下一个结点的内存即可(java的话 坐等JVM回收)
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
