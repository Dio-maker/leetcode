package exercise;

import exercise.entity.ListNode;

public class SwapPairs {
    public static void main(String[] args) {
        ListNode node = new ListNode();
        ListNode node1 = node.getListNode(1, 5, 7, 9,8,0,1,4,2);
        ListNode node2 = swapPairs(node1);
        System.out.println(node2);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode t = head;
        if (t==null||t.next==null){
            return head;
        }
        head = t.next;
        ListNode i = t.next.next;
        t.next.next=t;
        t.next = i;

        while (t.next!=null&&t.next.next!=null){

                ListNode k = t.next;
                t.next = k.next;
                k.next=k.next.next;
                t.next.next = k;
                t=k;
        }
        return head;
    }
}
