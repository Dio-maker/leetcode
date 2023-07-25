package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
[-2,-1,-1,1,1,2,2]
0
[-3,-2,-1,0,0,1,2,3]
[0,0,0,1000000000,1000000000,1000000000,1000000000]
 */
public class FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{0,0,0,1000000000,1000000000,1000000000,1000000000}, 1000000000));

    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        digui(target,nums,0,list,0,tmp,0);
        return list;
    }
//[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    public static void digui(long target,int []nums,int count,List<List<Integer>> list, long sum,List<Integer> tmp,int i1){
        for (int i = 0; i < nums.length-3; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            if ((long) nums[i]+nums[nums.length-3]+nums[nums.length-2]+nums[nums.length-1]<target){
                continue;
            }
            if ((long) nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                break;
            }
            for (int j = i+1; j < nums.length-2; j++) {
                if (j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                if ((long) nums[i]+nums[j]+nums[nums.length-2]+nums[nums.length-1]<target){
                    continue;
                }
                if ((long) nums[i]+nums[j]+nums[j+1]+nums[j+2]>target){
                    break;
                }
                int left = j+1;
                int right = nums.length-1;
                while (left<right){
                    if (left>j+1&&nums[left] == nums[left-1]){
                        left++;
                        continue;
                    }
                    if (right<nums.length-1&&nums[right] == nums[right+1]){
                        right--;
                        continue;
                    }
                    long sumN =(long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sumN == target){
                        list.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right=nums.length-1;
                    }else if (sumN<target){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
    }
}
