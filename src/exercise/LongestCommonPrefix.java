package exercise;


import java.util.HashSet;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strings = {"adasdsac","adasds","adasdac"};
        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strs) {
        boolean flag = true;
        StringBuilder builder = new StringBuilder();
        int len = 0;
        HashSet<Character> hashSet = new HashSet<>();
        if (strs.length<=1){
            return strs[0];
        }else {
            len = strs[0].length();
        }
        for (int i = 0; i < strs.length; i++) {
            len = Math.min(strs[i].length(), len);
        }
        int j = 0;

        while (j<len){
            for (int i = 0; i < strs.length; i++) {
                hashSet.add(strs[i].charAt(j));
            }
            if (hashSet.size()<=1){
                builder.append(hashSet.iterator().next());
            }else {
                break;
            }
            hashSet.clear();
            j++;
        }


        return builder.toString();
    }
}

