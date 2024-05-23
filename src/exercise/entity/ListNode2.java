package exercise.entity;


import lombok.Data;

@Data
  public class ListNode2 {
      public String val;
      public ListNode2 next;
      public ListNode2() {}
      public ListNode2(String val) { this.val = val; }
      public ListNode2(String val, ListNode2 next) { this.val = val; this.next = next; }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public ListNode2 getNext() {
        return next;
    }

    public void setNext(ListNode2 next) {
        this.next = next;
    }
}