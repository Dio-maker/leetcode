package exercise;

import exercise.entity.ListNode;


/**
 *
 */
public class RemoveNthFromEnd {

    public static void main(String[] args){
        ListNode node = new ListNode(0);
//        ListNode t=node;
//        for (int i = 1; i < 10; i++) {
//            ListNode tm = new ListNode(i);
//            t.setNext(tm);
//            t=t.getNext();
//        }
        ListNode r = removeNthFromEnd(node, 1);
        System.out.println(r);

    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode thead = head;
        int nodeLength = getNodeLength(head);
        if (nodeLength-n==0){
            return head.getNext();
        }
        for (int i = 1; i < nodeLength; i++) {
            if (nodeLength-n==i){
                delNode(thead);
                break;
            }
            thead=thead.getNext();
        }

        return head;
    }

    static void delNode(ListNode n){
        n.setNext(n.getNext().getNext());
    }

    static int getNodeLength(ListNode n){
        int count = 0;
        while (n!=null){
            count++;
            n=n.getNext();
        }
        return count;
    }
}

