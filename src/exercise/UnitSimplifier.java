package exercise;

import com.sun.deploy.util.StringUtils;
import exercise.entity.CalUnitDto;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * date: 2024/5/7
 *
 * @author wmk
 * @version 1.0.0
 * @since 1.0.0
 */
public class UnitSimplifier {
    private static final List<String> specificUnit = Arrays.asList("%");
    //p*km/h*p*h/p*h = pkmh
    public static void main(String[] args) {
        CalUnitDto dto1 = new CalUnitDto(BigDecimal.ONE, "kg BOD/P/D");
        CalUnitDto dto2 = new CalUnitDto(BigDecimal.ONE, "P*D");
        CalUnitDto dto3 = new CalUnitDto(BigDecimal.ONE, "%");
        String formula = "{f2}*{f1}";
        HashMap<String, CalUnitDto> map = new HashMap<>();
        map.put("{f1}",dto1);
        map.put("{f2}",dto2);
        map.put("{f3}",dto3);
        System.out.println(calculateUnit(map, formula));


    }


    public static String calculateUnit(Map<String, CalUnitDto> inputMap, String formula){
        //根据公式转换单位符号

        if (formula.contains("/")){
            String[] split = formula.split("/");
            for(int i = 1;i<split.length;i++){
                CalUnitDto unitDto = inputMap.get(split[i]);
                String unitCode = unitDto.getUnitCode();
                if (unitCode!=null){
                    StringBuilder builder = new StringBuilder(unitCode);
                    for (int j=0;j<builder.length();j++){
                        if ('/' == builder.charAt(j)){
                            builder.setCharAt(j,'*');
                        } else if ('*' == builder.charAt(j)) {
                            builder.setCharAt(j,'/');
                        }
                    }
                    unitDto.setUnitCode(builder.toString());
                }
            }
        }
        //将占位符替换为单位
        for (String name : inputMap.keySet()) {
            CalUnitDto unitDto = inputMap.get(name);
            formula = formula.replace(name,unitDto.getUnitCode());
        }
        formula = "*"+formula;

        //切割公式
        String regex = "[*/+\\-]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(formula);
        String[] tokens = formula.split(regex);
        /*将句子结束符连接到相应的句子后*/
        if(tokens.length > 0)
        {
            int count = 0;
            while(count < tokens.length)
            {
                if(m.find())
                {
                    tokens[count+1] = m.group()+tokens[count+1];
                }
                count++;
            }
        }
        //分子
        ArrayList<String> numerator = new ArrayList<>();
        //分母
        ArrayList<String> denominator  = new ArrayList<>();

        for (String s:tokens){
            if (!"".equals(s)){
                if (s.charAt(0) == '/'){
                    denominator.add(s.substring(1));
                } else if (s.charAt(0) == '*') {
                    numerator.add(s.substring(1));
                }
            }
        }

        for (int i=0;i< numerator.size();i++){
            for (int j = 0; j < denominator.size(); j++) {
                if (numerator.get(i).equals(denominator.get(j))){
                    numerator.remove(i);
                    denominator.remove(j);
                    i--;
                    break;
                }
            }
        }
        StringBuilder result = new StringBuilder();

        if (numerator.size()>0){
            numerator.removeAll(specificUnit);
            String s = String.join("*", numerator);
            result.append(s);
        }
        if (denominator.size()>0){
            denominator.remove(specificUnit);
            String s = String.join("/", denominator);
            result.append("/").append(s);
        }

        return result.toString();
    }


}