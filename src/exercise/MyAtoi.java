package exercise;

public class MyAtoi {
    public static void main(String[] args) {
       int res = '2'-'0';
        System.out.println(myAtoi2("    +1"));
    }

    public static int myAtoi2(String s) {
        int len = s.length();
        int flag = 1;
        int rs = 0;
        int i=0;
        while (i<len&&s.charAt(i)==' '){
            i++;
        }
        int begin = i;
      while (i<len){
          if ('-'==s.charAt(i)&&i==begin){
              flag = -1;
          } else if ('+'==s.charAt(i)&&i==begin) {
              flag = 1;
          } else if (Character.isDigit(s.charAt(i))){
              int num=s.charAt(i)-'0';
              if (rs>Integer.MAX_VALUE/10 || rs==Integer.MAX_VALUE/10&&num>Integer.MAX_VALUE%10){
                  return Integer.MAX_VALUE;
              }
              if (rs<Integer.MIN_VALUE/10 || rs==Integer.MIN_VALUE/10&&-num<Integer.MIN_VALUE%10){
                  return Integer.MIN_VALUE;
              }
              rs=rs*10+num*flag;
          }else {
              break;
          }
          i++;
      }
      return rs;
    }

}
