package practice.arrays;

public class WaterContainer {

    public int maxArea(int[] height) {
        int max=0;
        int i = 0;
        int j = height.length-1;
        while(i<j)
        {
            if((j-i)*Math.min(height[i],height[j])>max)
                max=(j-i)*Math.min(height[i],height[j]);
            if(height[i]<height[j])
                i++;
            else j--;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};

        System.out.println(new WaterContainer().maxArea(heights));

        heights = new int[]{1,2,1};
        System.out.println(new WaterContainer().maxArea(heights));
    }
}
