package exercise;

public class AddTwoNumbers {
    public static void main(String[] args){
        ListNode2 num1  = new ListNode2(9, new ListNode2(2));

        ListNode2 num2 = new ListNode2(6, new ListNode2(5, new ListNode2(4, new ListNode2(9,new ListNode2(7)))));
        ListNode2 r = addTwoNumbers(num1, num2);
        System.out.println(r);

    }


    public static ListNode2 addTwoNumbers(ListNode2 l1, ListNode2 l2) {
        ListNode2 l3=new ListNode2();
        ListNode2 t3=l3;
        int mod=0;
        while (l1!=null || l2!=null){
            mod = sumNums(l1!=null?l1.val:0, l2!=null?l2.val:0, t3,mod);
            l1=l1!=null?l1.next:l1;
            l2=l2!=null?l2.next:l2;
            if (l1!=null||l2!=null){
                t3.next=new ListNode2();
                t3=t3.next;
            }
        }
        if (mod!=0){
            t3.next=new ListNode2(mod);
        }
        return l3;
    }

    public static int sumNums(int a,int b,ListNode2 l3,int m){
        int sum=a+b+m;
        int mod = sum / 10;
        l3.val=sum%10;
        return mod;
    }

}

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2() {}
    ListNode2(int val) { this.val = val; }
    ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }

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
