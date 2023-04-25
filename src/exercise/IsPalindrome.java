package exercise;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int len = s.length();
        int start= 0;
        int end = len-1;
        while (end - start>=1){
            if ((s.charAt(start)!=s.charAt(end))){
                return false;
            }
            end--;
            start++;
        }
        return true;
    }
}

