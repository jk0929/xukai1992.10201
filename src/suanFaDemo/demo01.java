package suanFaDemo;


/**
 * Created by Admin on 2018/6/25.
 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 示例：
 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class demo01 {
    public static void main(String[] args){
        ListNode node = new ListNode(1);
        node.add(2);
        node.add(3);
        node.add(4);
        node.add(5);
        String str = node.eachFor();
        System.out.println(str);

        Solution solution = new Solution();
        solution.removeNthFromEndTwo(node,2);

        str = node.eachFor();
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
class Solution {
    public ListNode removeNthFromEndTwo(ListNode head, int n) {
        ListNode p=head;
        ListNode q=head;
        //将p向后移动n个位置
        for(int i=0;i<n;i++){
            p=p.next;
        }
        //如果链表长度等于n，则只删除头结点；
        if(p==null){
            head=head.next;
            return head;
        }
        //如果链表长度大于n，则只删除倒数n个位置的节点；
        while(p.next!=null){
            p=p.next;
            q=q.next;
        }
        q.next=q.next.next;
        return head;
    }
}
