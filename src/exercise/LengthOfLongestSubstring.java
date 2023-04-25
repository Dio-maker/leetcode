package exercise;

import java.util.ArrayList;
import java.util.HashMap;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abbcbbcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {

        int sum=0;
        Integer p=0;
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){

                p = Math.max(p,map.get(s.charAt(i))+1);

            }
            map.put(s.charAt(i),i);
            sum = Math.max(sum, i+1-p);

        }

        return sum;
    }
}

