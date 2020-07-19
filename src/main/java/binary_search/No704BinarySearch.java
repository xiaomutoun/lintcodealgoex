package binary_search;

public class No704BinarySearch {

    /**
     * Given a sorted (in ascending order) integer array nums of n elements and a target value,
     * write a function to search target in nums. If target exists, then return its index,
     * otherwise return -1.


     Example 1:
     Input: nums = [-1,0,3,5,9,12], target = 9
     Output: 4
     Explanation: 9 exists in nums and its index is 4

     Example 2:
     Input: nums = [-1,0,3,5,9,12], target = 2
     Output: -1
     Explanation: 2 does not exist in nums so return -1

     */
    public int search(int[] nums, int target) {
        int len = nums.length, lo = 0, hi = len - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else if (nums[mid] == target) return mid;
            else hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        No704BinarySearch test = new No704BinarySearch();
        int res = test.search(new int[]{-1,0,3,5,9,12}, 9);
        System.out.println("res = " + res + ", should be 4");
        res = test.search(new int[]{-1,0,3,5,9,12}, 2);
        System.out.println("res = " + res + ", should be -1");
    }

}












