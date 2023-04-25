package exercise;

public class MaxArea {
    public static void main(String[] args) {

    }
    public int maxArea(int[] height) {

        int r = height.length-1;
        int l = 0;
        int max = 0;
        int rs = 0;
        while (l<r){
            rs = Math.min(height[l],height[r]) * (r-l);
            max = Math.max(rs,max);
            if (height[l]>height[r]){
                r--;
            }else {
                l++;
            }
        }

        return max;
    }

}
