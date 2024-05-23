package exercise;

public class StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
    }
    public static int strStr(String haystack, String needle) {
        if (haystack.length()<needle.length()){
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            int count = 0;
            char c = haystack.charAt(i);
            while (j<needle.length()&&(i+j)<haystack.length()&&haystack.charAt(i+j)==needle.charAt(j)){
                j++;
                if ((i+j)<haystack.length()&&c!=haystack.charAt(i+j)){
                    count++;
                }

            }

            if (j==needle.length()){
                return i;
            }
            if (count!=0){
                i = i+count-1;

            }
        }
        return -1;
    }
}
