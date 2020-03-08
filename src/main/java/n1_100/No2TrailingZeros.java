package n1_100;

/**
 * Difficulty: Easy
 * Tags: Mathematics

 Description:
     Write an algorithm which computes the number of trailing zeros in n factorial.

 Example
     Example 1:
     Input:  11
     Output: 2

     Explanation:
     11! = 39916800, so the output should be 2

     Example 2:
     Input:  5
     Output: 1

     Explanation:
     5! = 120, so the output should be 1.

 Challenge
    O(log N) time
 */
public class No2TrailingZeros {
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        long result = 0;
        while(n > 0){
            result += n / 5;
            n /= 5;
        }
        return result;
    }

    public static void main(String[] args) {
        No2TrailingZeros test = new No2TrailingZeros();
        assert(test.trailingZeros(11) == 2);
    }
}
