package exercise;

public class RemoveDuplicates {
    public static void main(String[] args) {

        System.out.println(removeDuplicates(new int[]{0, 0, 1, 2, 4, 4,4,4,4,4,4, 8, 9, 5, 5, 5}));

    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (; i < nums.length; i++) {
            int t = i+1;
            while (t<nums.length&&nums[i]==nums[t]){
                if (t==nums.length-1){
                    return i+1;
                }
                t++;
            }

            if (t<nums.length){
                int k = nums[i+1];
                nums[i+1]=nums[t];
                int n = 0;
                while (i+n<nums.length-2&&k==nums[i+2+n]){
                    nums[i+2+n]=nums[t];
                    n++;
                }
            }
        }
        return i+1;
    }
}
