package suanFaDemo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Admin on 2018/6/27.
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

 示例:
 输入:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 输出: 1->1->2->3->4->4->5->6
 [[2],[],[-1]]
 */
public class demo05 {
    public static void main(String[] args){
        ListNode[] lists = new ListNode[3];

        ListNode p = new ListNode(1);
        p.add(4);
        p.add(5);
        lists[0] = p;

        ListNode q = new ListNode(1);
        q.add(3);
        q.add(4);
        lists[1] = q;

        ListNode z = new ListNode(2);
        z.add(6);
        lists[2] = z;


        Solution5 solution5 = new Solution5();
        ListNode node = solution5.mergeKListsNew(lists);
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
class Solution5 {

    public ListNode mergeKListsNew(ListNode[] lists) {
        List<ListNode> listNodes = new ArrayList<>(lists.length);
        for (ListNode node:lists){
            listNodes.add(node);
        }
        // write your code here
        if (lists == null || listNodes.size() == 0) {
            return null;
        }

        while(listNodes.size() > 1) {
            List<ListNode> newLists = new ArrayList<>();
            //将list集合中两两先组合
            for(int i=0;i+1<listNodes.size();i=i+2) {
                ListNode mergedList = mergeTwoLists(listNodes.get(i), listNodes.get(i+1));
                newLists.add(mergedList);
            }
            //如果为奇数，则需要将集合中最后一个取出，放进一个新集合
            if(listNodes.size()%2 == 1) {
                newLists.add(listNodes.get(listNodes.size()-1));
            }
            //如果集合数量大于1，则进入下一次循环，重复执行
            listNodes = newLists;
        }
        return listNodes.get(0);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode point = head;

        while(l1!=null && l2!=null) {
            if(l1.val<l2.val) {
                point.next = l1;
                l1 = l1.next;
            }
            else {
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
        }
        if(l1!=null) {
            point.next = l1;
        }
        if(l2!=null) {
            point.next = l2;
        }
        return head.next;
    }

}

