package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int count = 0;
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length-1; j++) {
                if (j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                for (int k = nums.length-1-count; k > j; k--) {

                    if (k>j+1&&nums[k]==nums[k-1]){
                        continue;
                    }
                    if (nums[i]+nums[j]+nums[k]<0){
                        break;
                    } else if (nums[i]+nums[j]+nums[k]==0) {
                        ls.add(Arrays.asList(nums[i],nums[j],nums[k]));
                        break;
                    }else {
                        count++;
                    }
                }
            }
        }
        return ls;
    }

}
