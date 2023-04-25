package exercise;

import java.util.*;

public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1100));
    }
    public  static String intToRoman(int num) {
        int[] n = {1, 4, 5,9,10,40,50,90,100,400,500,900,1000};
        String[] s ={"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        StringBuilder builder = new StringBuilder();

        for (int i = n.length-1; i >=0; i--) {
            while (num>=n[i]){
                num = num - n[i];
                builder.append(s[i]);
            }
            if (num == 0){
                break;
            }
        }
        return builder.toString();
    }
}
