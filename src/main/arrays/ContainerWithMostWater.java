package arrays;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 * Example Image: <a href="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg">...</a>
 */

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int area;
        int maxArea = 0;
        while(i < j) {
            if(height[i] <= height[j]) {
                area = height[i] * (j - i);
                i++;
            } else {
                area = height[j] * (j - i);
                j--;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] H = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(H)); // 49
    }
}
