package exercise;

public class AddTwoNumbers {
    public static void main(String[] args){
        ListNode num1  = new ListNode(9, new ListNode(2));

        ListNode num2 = new ListNode(6, new ListNode(5, new ListNode(4, new ListNode(9,new ListNode(7)))));
        ListNode r = addTwoNumbers(num1, num2);
        System.out.println(r);

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3=new ListNode();
        ListNode t3=l3;
        int mod=0;
        while (l1!=null || l2!=null){
            mod = sumNums(l1!=null?l1.val:0, l2!=null?l2.val:0, t3,mod);
            l1=l1!=null?l1.next:l1;
            l2=l2!=null?l2.next:l2;
            if (l1!=null||l2!=null){
                t3.next=new ListNode();
                t3=t3.next;
            }
        }
        if (mod!=0){
            t3.next=new ListNode(mod);
        }
        return l3;
    }

    public static int sumNums(int a,int b,ListNode l3,int m){
        int sum=a+b+m;
        int mod = sum / 10;
        l3.val=sum%10;
        return mod;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        String str="["+val;

        while (this.next!=null){
            str=str+","+next.val;
            next=next.next;
        }
        str=str+"]";
        return str;
    }
}
