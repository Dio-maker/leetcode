package exercise;


import exercise.entity.ListNode;

public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode node = new ListNode();
        ListNode node1 = node.getListNode(1, 5, 7, 9);
        ListNode node2 = node.getListNode(3, 4, 6, 11);

        System.out.println(mergeTwoLists(node1, node2));
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head;
        ListNode sub;
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        boolean flag = list1.val <= list2.val;
        if (flag){
            head = list1;
            sub = list2;
        }else {
            head = list2;
            sub = list1;
        }
        ListNode t = head;
        while (t.next != null && sub != null){
            if (sub.val<t.next.val){
                ListNode node = new ListNode(sub.val);
                node.next = t.next;
                t.next = node;
                sub = sub.next;
            }else {
                t = t.next;
            }
        }
        if (sub != null){
            t.next = sub;
        }


        return head;
    }
}

