package exercise;

public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1, 2, 3, 2, 2, 4, 3, 7, 9}, 3));
    }
    public static int removeElement(int[] nums, int val) {
        int[] ints = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val){
                ints[count++]=nums[i];
            }
        }
        for (int i = 0; i < count; i++) {
            nums[i]=ints[i];
        }
        return count;
    }
}
