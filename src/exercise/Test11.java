package exercise;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test11 {
    public static void main(String[] args) {
        ArrayList<BigDecimal> list1 = new ArrayList<>();
        list1.add(new BigDecimal("1.99"));
        list1.add(new BigDecimal("2.91"));
        BigDecimal decimal = list1.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(decimal);
        System.out.println(BigDecimal.ZERO);


    }
}
