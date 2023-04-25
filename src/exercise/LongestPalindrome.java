package exercise;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = longestPalindrome("babad");
        System.out.println(s);
    }
    public static String longestPalindrome(String s){
        boolean[][] posi = new boolean[s.length()][s.length()];
        int max=1;
        int begin=0;
        for (int i=0;i<s.length();i++){
            posi[i][i] = true;
        }

        char[] c = s.toCharArray();
        for (int i = 1;i<s.length();i++){
            for (int j=0;j<i;j++){
                if (c[i]!=c[j]){
                    posi[j][i]=false;
                }else{
                    if (i-j>2){
                        posi[j][i]=posi[j+1][i-1];
                    }else {
                        posi[j][i]=true;
                    }
                }

                if (posi[j][i]&&i-j+1>max){
                    begin=j;
                    max=i-j+1;
                }
            }
        }
        return s.substring(begin,begin+max);
    }
}
