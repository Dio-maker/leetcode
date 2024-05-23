package exercise.entity;

import com.sun.deploy.util.StringUtils;

import javax.xml.soap.Node;
import java.util.*;
import java.util.regex.Pattern;

/**
 * date: 2024/5/8
 *
 * @author wmk
 * @version 1.0.0
 * @since 1.0.0
 */
public class SuffixExpressionTest {
    public Stack<String> array;
    public Stack<ListNode2> listStack;
    public Stack<String> stringArray;
    public int length;

    //新建两个栈
    public SuffixExpressionTest(String infixExpression) {
        array = new Stack<String>();
        stringArray = new Stack<String>();
    }
//t C/GJ/(kg CH4*GJ*h/P/D)
    public static void main(String[] args) {
        String infixExpression = "1/(2+3)-5";//输入中缀表达式（不可以用空格将每一个字符隔开，否则会报错）
        SuffixExpressionTest test1 = new SuffixExpressionTest(infixExpression);
        try {
            List<String> suffixExpression = test1.getSuffixExpression(infixExpression);//获得后缀表达式
            System.out.println(infixExpression + " 的后缀表达式为 " + suffixExpression);
            String result = test1.getSuffixExpressionResult(suffixExpression);
            System.out.println(suffixExpression + " 的结果为 " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //获得后缀表达式
    public List<String> getSuffixExpression(String infixExpression) {
        if (infixExpression == null){
            throw new RuntimeException("字符串为空， 请输入字符串");
        }
        List<String> string = new ArrayList<String>();
        String keepNum = "";//用来拼接多位数字的
        //从左到右开始遍历字符串
        for (int i = 0; i < infixExpression.length(); i++) {
            String ch = infixExpression.substring(i, i + 1);//获得下标为i的字符串
            //判断是否为基本运算符
            if (isOper(ch)) {
                //如果是基本运算符，那么分情况讨论
                if (stringArray.empty() || stringArray.peek().equals("(")) {
                    //如果栈为空， 或者栈顶是左括号，直接入栈
                    stringArray.push(ch);
                } else if (ch.equals("(")) {
                    //如果当前符号是左括号，那么直接入栈
                    stringArray.push(ch);
                } else if (ch.equals(")")) {
                    //如果当前符号是右括号，那么就将从栈S1中跳出2个数字，然后栈S2中跳出一个符号，进行相应的运算，将结果压入栈S1
                    //重复上述操作，直到遇到左括号
                    while (!stringArray.peek().equals("(")) {
                        String temp = stringArray.pop();
                        array.push(temp);
                    }
                    stringArray.pop();//将左括号从栈中跳出,消除左括号
                } else {
                    //如果当前符号都不符合上面的几种情况，那么比较优先级
                    if (priority(ch) > priority(stringArray.peek())) {
                        stringArray.push(ch);//如果当前符号的优先级大于栈顶的优先级，那么直接将符号压入栈中
                    } else {
                        String temp = stringArray.pop();
                        array.push(temp);
                        stringArray.push(ch);//当前符号压入栈S2
                    }
                }
            } else {
                //如果当前符号是数字，那么注意多位数字的拼接
                keepNum = ch;
                int j;
                for (j = i + 1; j < infixExpression.length(); j++) {
                    String str = infixExpression.substring(j, j + 1);
                    if (isOper(str)) {
                        break;
                    }
                    keepNum += str;//拼接多位数字
                }
                array.push(keepNum);
                keepNum = "";//将其重置为""
                i = j - 1;//注意这一步是必须的，因为退出循环的时候j对应的是非数字的下标，而在外部循环中又有i++,所以i = j - 1才可以，如果没有的话，那么就会少了一些字符
            }
        }
        //结束遍历之后，判断array是否为空，如果不为空，就将其所有元素压入栈stringArray中
        while (!array.empty()) {
            stringArray.push(String.valueOf(array.pop()));//将栈array中的数字压入栈stringArray中，那么输出栈stringArray就是后缀表达式
        }
        //获取后缀表达式
        while (!stringArray.empty()) {
            string.add(stringArray.pop());
        }
        return string;//返回后缀表达式
    }

    /**
     * 计算后缀表达式的值，通过配合栈来实现
     * 如果遇到的数字，那么就将数字压入栈中，否则，跳出两个数字，进行相应的运算，并将结果压入栈中，最后站还有一个数，那么这个数就是表达式的值
     *
     * @param suffixExpression
     * @return
     */
    public String getSuffixExpressionResult(List<String> suffixExpression) {
        String regex = "\\*|/";
        Pattern p = Pattern.compile(regex);
        int result = 0;
        if (suffixExpression == null){
            throw new RuntimeException("后缀表达式为空，注意检查");
        }
        //从左到右开始遍历
        for (int i = 0; i < suffixExpression.size(); i++) {
            String str = suffixExpression.get(i);
            if (isOper(str)) {
                //如果当前的字符是基本运算符，那么就从栈中条出两个数字，并进行相应的运算，之后将结果压入栈中
                //由于是从左到右开始遍历，那么应该是num2 - num1,num2 / num1
                String str1 = array.pop();
                String str2 = array.pop();
                if (str.equals("*")){
                    String[] split = str2.split("\\+");
                    for (String s:split){
                        s=str1.concat("*").concat(s);
                    }
                    StringUtils.join(Arrays.asList(split), "+");
                    array.push(str2.concat("-").concat(str1));
                }
                else if (str.equals("/")) {
                    //注意除法的运算规则
//                    array.push(num2.concat("/").concat(num1));
                }
            }else {
                array.push(str);
            }
        }
        return array.pop();
    }

    /**
     * 比较优先级
     *
     * @param ch
     * @return
     */
    public int priority(String ch) {
        if (ch.equals("+") || ch.equals("-")){
            return 1;
        }
        else if (ch.equals("*") || ch.equals("/")){
            return 2;
        }
        else if (ch.equals("%")){
            return 3;
        }
        else{
            throw new RuntimeException("该符号不是基本运算符号，表达式错误，注意检查");
        }
    }

    /**
     * 判断是否为基本运算符号
     *
     * @param ch
     * @return
     */
    public boolean isOper(String ch) {
        return (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/") || ch.equals("%") || ch.equals("(") || ch.equals(")"));
    }
}