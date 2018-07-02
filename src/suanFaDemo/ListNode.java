package suanFaDemo;

/**
 * Created by Admin on 2018/6/25.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode add(int var){
        ListNode node = new ListNode(var);
        ListNode next = this.next;
        if(next == null){
            this.next = node;
            return this;
        }
        while (next.getNext() != null){
            next = next.getNext();
        }
        next.next = node;
        return this;
    }

    public String  eachFor(){
        String str = "";
        if(this.next == null){
            return str+this.val;
        }
        str = str +this.val;
        ListNode next = this.next;
        str = str +"-->"+next.val;
        while (next.getNext() != null){
            next = next.getNext();
            str = str +"-->"+next.getVal();
        }
        return str;
    }
}
