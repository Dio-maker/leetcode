package exercise.entity;


import lombok.Data;

@Data
  public class ListNode {
      public int val;
      public ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      public ListNode getListNode(Integer... x){
          ListNode head = new ListNode(x[0]);
          ListNode t = head;
          for (int i=1;i<x.length;i++){
              ListNode node = new ListNode(x[i]);
              t.next=node;
              t=t.next;
          }
          return head;
      }
  }
