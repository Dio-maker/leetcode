package exercise;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Math.abs(target-(nums[0]+nums[1]+nums[2]));
        int minNum = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length - 1; j++) {
                if (j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                for (int k = nums.length-1; k > j ; k--) {
                    int sum = nums[i]+nums[j]+nums[k];
                    int t = Math.abs(target - sum);
                    if (t==0){
                        return sum;
                    }
                    min = Math.min(t, min);

                    if (min==t){
                        minNum = sum;
                    }
                }
            }
        }
        return minNum;
    }
}
