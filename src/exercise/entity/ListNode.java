package exercise.entity;


import lombok.Data;

@Data
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) { this.val = val; }

}
