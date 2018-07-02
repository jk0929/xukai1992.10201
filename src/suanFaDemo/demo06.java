package suanFaDemo;


/**
 * Created by Admin on 2018/6/27.
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 示例:
 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class demo06 {
    public static void main(String[] args){
        ListNode p = new ListNode(1);
        p.add(2);
        p.add(3);
        p.add(4);

        Solution6 solution6 = new Solution6();
        ListNode node = solution6.swapPairs(p);
        String  str = node.eachFor();
        System.out.println(str);
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution6 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        head = dummy;
        while (head.next != null && head.next.next != null) {
            ListNode n1 = head.next, n2 = head.next.next;
            // head->n1->n2->...
            // => head->n2->n1->...
            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;

            // move to next pair
            head = n1;
        }

        return dummy.next;
    }
}

