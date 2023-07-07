package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {

        ArrayList<String> list = new ArrayList<>();
        if (digits.length() == 0){
            return list;
        }
        String[] strs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        digui(strs,list,0,digits,new StringBuilder());
        return list;
    }

    private static void digui(String[] strs ,ArrayList<String> list, int index, String digits,StringBuilder sb) {
        if (index == digits.length()){
            list.add(sb.toString());

        }else {
            int n = (digits.charAt(index) - '0')-2;
            for (int i = 0; i < strs[n].length(); i++) {
                sb.append(strs[n].charAt(i));
                digui(strs,list,index+1,digits,sb);
                sb.deleteCharAt(index);
            }
        }

    }

}
