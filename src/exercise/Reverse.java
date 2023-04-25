package exercise;

import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.Math.pow;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483412));
    }

    public static int reverse(int x) {
        int sum=0;
        ArrayList<String> str = new ArrayList<>();
        String max = Integer.MAX_VALUE + "";
        String min = Integer.MIN_VALUE + "";
        int xlen = max.length();
        int mlen = min.length();
        StringBuilder builder = new StringBuilder();
        String s = String.valueOf(x);
        if (x>0){
            if (s.length()>xlen){
                return 0;
            }else if (s.length()==xlen){
                for (int i = 0;i<xlen;i++){
                    if (max.charAt(i)>s.charAt(s.length()-i-1)){
                        break;
                    }else if(max.charAt(i)==s.charAt(s.length()-i-1)){

                    }else {
                        return 0;
                    }
                }
            }
        }else if (x<0){
            if (s.length()>mlen){
                return 0;
            }else if (s.length()==mlen){
                for (int i = 1;i<mlen-1;i++){
                    if (min.charAt(i)>s.charAt(s.length()-i)){
                        break;
                    } else if(min.charAt(i)==s.charAt(s.length()-i)){
                        continue;
                    } else {
                        return 0;
                    }
                }
            }
        }

        StringBuilder builder1 = new StringBuilder(s);
        StringBuilder reverse = builder1.reverse();
        String s1 = reverse.toString();
        if (x<0){
            builder.append("-");
            s1 = s1.substring(0, s.length() - 1);
        }
        builder.append(s1);
        return Integer.valueOf(builder.toString());


    }
}
