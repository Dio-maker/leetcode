package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(5));
    }

    public static List<String> generateParenthesis(int n) {
        char[] str = new char[2 * n];
        ArrayList<String> list = new ArrayList<>();
        generateP(str,0,list);
        return list;
    }

    public static void generateP(char[] str, int i, ArrayList<String> list) {
        if (i==str.length){
            if (valid(str)){
                list.add(String.valueOf(str));
            }
        }else {
            str[i] = '(';
            generateP(str,i+1,list);
            str[i] = ')';
            generateP(str,i+1,list);
        }
    }

    public static boolean valid(char[] str){
        int num = 0;
        for (char s : str) {
            if (Objects.equals(s, '(')){
                num++;
            }else {
                num--;
            }
            if (num<0){
                return false;
            }
        }
        return num == 0;
    }
}



