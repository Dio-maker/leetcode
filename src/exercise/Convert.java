package exercise;

import java.util.ArrayList;

public class Convert {
    public static void main(String[] args) {
        String convert = convert("PA", 1);
        System.out.println(convert);
    }

    public static String convert(String s, int numRows) {
        if (s.length()<=numRows||numRows==1){
            return s;
        }
        int num=(numRows-1)*2;
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<numRows;i++){
            int downNum=num-2*i;
            int upNum=num-2*(numRows-i-1);

            if (i==0||i==numRows-1){
                if (i==numRows-1){
                    downNum=upNum;
                }
                for (int j=i;j<s.length();j=j+downNum){
                    builder.append(s.charAt(j));
                }
            }else {
                int count=i;
                builder.append(s.charAt(count));
                while (count<s.length()){
                    count=count+downNum;
                    if (count<s.length()){
                        builder.append(s.charAt(count));
                    }
                    count=count+upNum;
                    if (count<s.length()){
                        builder.append(s.charAt(count));
                    }
                }
            }

        }
        return builder.toString();
    }
}
