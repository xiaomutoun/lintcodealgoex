package array;

import java.util.ArrayList;
import java.util.List;

/** Tag: Deque, Two Pointers, O(n) on array, LintCode
 * Difficulty: Hard
 * Company: Zenefits, Google, Microsoft, Amazon

 Description:
     Given an array of n integer with duplicate number, and a moving window(size k),
     move the window at each iteration from the start of the array, find the maximum number
     inside the window at each moving.

 Example:
     Example 1:

     Input:
     [1,2,7,7,8]
     3
     Output:
     [7,7,8]

     Explanation：
     At first the window is at the start of the array like this `[|1, 2, 7| ,7, 8]` , return the maximum `7`;
     then the window move one step forward.`[1, |2, 7 ,7|, 8]`, return the maximum `7`;
     then the window move one step forward again.`[1, 2, |7, 7, 8|]`, return the maximum `8`;
     Example 2:

     Input:
     [1,2,3,1,2,3]
     5
     Output:
     [3,3]

     Explanation:
     At first, the state of the window is as follows: ` [,2,3,1,2,1 | , 3] `, a maximum of ` 3 `;
     And then the window to the right one. ` [1, | 2,3,1,2,3 |] `, a maximum of ` 3 `;

 Challenge:
    o(n) time and O(k) memory

 */
public class No362SlidingWindowMaximum {
    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        List<Integer> temp = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if(!temp.isEmpty()) {
                for(int j = temp.size()-1; j >= 0; j--) {
                    if(curr > temp.get(j)) {
                        temp.remove(j);
                    }
                }
            }
            temp.add(curr);
            if(i >= k-1) {
                if(i >= k && temp.get(0) == nums[i-k]) {
                    temp.remove(0);
                }
                result.add(temp.get(0));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        No362SlidingWindowMaximum test = new No362SlidingWindowMaximum();
        int[] arr1 = new int[]{1, 2, 7, 7, 8};
        int[] arr2 = new int[]{1, 2, 3, 1, 2, 3};
        assert(test.maxSlidingWindow(arr1, 3).equals(new int[]{7, 7, 8}));
        assert(test.maxSlidingWindow(arr2, 5).equals(new int[]{3, 3}));
    }
}
