package practice.binarySearch;

public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <=right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] <= nums[right]){ // Sorted part
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                if (target > nums[left] && target <= nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedArray searchRotatedArray = new SearchRotatedArray();
        int[] nums = { 4,5,6,7,0,1,2};
        int target = 3;
        System.out.println(searchRotatedArray.search(nums, target));

        nums = new int[]{4,5,6,7,0,1,2};
        target = 0;
        System.out.println(searchRotatedArray.search(nums, target));
    }
}
