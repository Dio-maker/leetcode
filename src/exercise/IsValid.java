package exercise;


import java.util.HashMap;
import java.util.Stack;

public class IsValid {
    public static void main(String[] args) {
        System.out.println(isValid("[[[()]]]"));
    }

    public static boolean isValid(String s) {

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.size()>0&&stack.peek()==map.get(c)){
                stack.pop();
            }else {
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }
}
