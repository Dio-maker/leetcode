package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 */
public class FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{-5,-4,-3,-2,-1,0,0,1,2,3,4,5,0}, 0));

    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        digui(target,nums,0,list,0,tmp,0);
        return list;
    }

    public static void digui(int target,int []nums,int count,List<List<Integer>> list, long sum,List<Integer> tmp,int i1){
        if (count == 4){
            if (sum == target){
                list.add(new ArrayList<>(tmp));

            }
        }else {
            for (int k = i1; nums.length-k>0 ; k++) {
                while (k+1<nums.length&&nums[k] == nums[k+1]){
                    k++;
                }
                tmp.add(nums[k]);
                digui(target,nums,count+1,list,sum+nums[k],tmp,i1+1);
                tmp.remove(count);
            }
            i1++;
        }
    }


}
