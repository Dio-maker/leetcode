package exercise;

public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCC"));
    }

    public static int romanToInt(String s) {
        int[] n = {1, 4, 5,9,10,40,50,90,100,400,500,900,1000};
        String[] sr ={"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int rs=0;
        int begin = 0;
        int i = sr.length-1;
        while (begin<s.length()){
            for (; i >=0 ; i--) {
                int l = sr[i].length();
                if (s.length()>=(l+begin)&&sr[i].equals(s.substring(begin,begin+l))){
                    rs=rs+n[i];
                    begin=begin+l;
                    break;
                }
            }
        }
        return rs;
    }
}
