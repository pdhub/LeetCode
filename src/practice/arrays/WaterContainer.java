package practice.arrays;

public class WaterContainer {

    public int maxArea(int[] height) {
        int[] leftHeight = new int[height.length];
        int[] rightHeight = new int[height.length];

        int maxIndex = 0;
        leftHeight[0] =  maxIndex;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[maxIndex]) {
                maxIndex = i;
            }
            leftHeight[i] = maxIndex;
        }

        maxIndex = height.length - 1;
        rightHeight[height.length - 1] =  maxIndex;
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] > height[maxIndex]) {
                maxIndex = i;
            }
            rightHeight[i] = maxIndex;
        }

        int maxWater = 0;
        for (int i = 0; i < height.length; i++) {
            int temp = Math.min(height[leftHeight[i]], height[rightHeight[i]]) * Math.abs(leftHeight[i]-rightHeight[i]);
            if (temp > maxWater)
                maxWater = temp;
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};

        System.out.println(new WaterContainer().maxArea(heights));

        heights = new int[]{1,2,1};
        System.out.println(new WaterContainer().maxArea(heights));
    }
}
