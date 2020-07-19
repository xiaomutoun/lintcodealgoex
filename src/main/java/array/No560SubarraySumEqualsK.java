package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous
 * sub arrays whose sum equals to k.

 Example 1:

 Input: nums = [1,1,1], k = 2
 Output: 2
 */
public class No560SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int size = nums.length, sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>(); // storing sum frequencies in a hash table
        for (int i = 0; i < size; i++) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += nums[i];
            if (map.containsKey(sum - k)) res += map.get(sum - k);
        }
        return res;
    }

}
