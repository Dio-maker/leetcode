package exercise;

import java.util.Arrays;

public class SumOfTheTwoNumbers {
    public static void main(String[] args) {
        int[] sum = twoSum(new int[]{3,3,3}, 9);
        System.out.println(Arrays.toString(sum));

        float a=0.3f;
        float b=0.1f;
        System.out.println(a-2*b+b);
    }

    public static int[] twoSum(int[] nums, int target) {

        for (int i=0;i<nums.length-1;i++){
            int i1 = target - nums[i];
            for (int j=i+1;j<nums.length;j++){

                if (i1==nums[j]){
                    return new int[]{i,j};
                }
            }

        }
        return new int[0];
    }
}
