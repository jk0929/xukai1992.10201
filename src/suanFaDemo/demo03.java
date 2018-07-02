package suanFaDemo;

/**
 * Created by Admin on 2018/6/25.
 *
 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 示例：
 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 */
public class demo03 {
    public static void main(String[] args){
        ListNode p = new ListNode(1);
        p.add(2);
        p.add(4);

        ListNode q = new ListNode(1);
        q.add(3);
        q.add(4);

        Solution3 solution3 = new Solution3();
        ListNode node = solution3.mergeTwoLists(p,q);
        String str = node.eachFor();
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
class Solution3 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 != null){
            return l2;
        }
        if(l1 != null && l2 == null){
            return l1;
        }
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                head.next = temp1;
                head = head.next;
                temp1 = temp1.next;
            }else {
                head.next = temp2;
                head = head.next;
                temp2 = temp2.next;
            }
        }
        //其中一个链表已经跑到头之后，继续单链表的合并
        while (temp1 != null){
            head.next = temp1;
            head = head.next;
            temp1 = temp1.next;
        }
        while (temp2 != null){
            head.next = temp2;
            head = head.next;
            temp2 = temp2.next;
        }
        head = p.next;
        return head;
    }

    /**
     * 将单项链表进行排序
     */
    public ListNode mergeTwoListsTwo(ListNode l1, ListNode l2) {
        ListNode result = null;
        result = getResult(result, l1, l2);
        return result;
    }
    /**
     * 一开始的时候想写while，但是发现无法获得头结点，并且定义变量较为复杂。
     * 回头一想，认为递归可以直接实现队列的排序。所以又重新编写一下逻辑。
     * 这样编写节约内存，提升效率。
     *
     * @param result null
     * @param l1 单项链表1 头项
     * @param l2 单项链表2 头项
     * @return 返回头结点
     */
    public ListNode getResult(ListNode result, ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            result = l2;
            //result.next = getResult(result.next, l1, l2.next);
            return result;
        }
        if (l2 == null) {
            result = l1;
            //result.next = getResult(result.next, l1.next, l2);
            return result;
        }
        if (l1.val > l2.val) {
            result = l2;
            l2 = l2.next;
        } else {
            result = l1;
            l1 = l1.next;
        }
        result.next = getResult(result.next, l1, l2);
        return result;
    }

    //循环的方式
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null )
            return list1;
        ListNode tmp1 = list1;
        ListNode tmp2 = list2;
        ListNode head = new ListNode(0);//这里不能把返回链表赋值为null，因为下一行马上就要把它赋值给另一链表，得让它在内存里有位置才行
        ListNode headptr = head;
        while(tmp1 != null && tmp2!=null){

            if(tmp1.val <= tmp2.val)
            {
                head.next=tmp1;
                head = head.next;
                tmp1 = tmp1.next;
            }else{
                head.next=tmp2;
                head = head.next;
                tmp2=tmp2.next;
            }

        }
        //其中一个链表已经跑到头之后，继续单链表的合并
        while(tmp1 != null){
            head.next = tmp1;
            head = head.next;
            tmp1= tmp1.next;
        }
        while(tmp2 != null){
            head.next = tmp2;
            head = head.next;
            tmp2= tmp2.next;
        }
        head = headptr.next;
        return head;
    }
}
