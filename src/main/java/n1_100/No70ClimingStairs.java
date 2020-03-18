package n1_100;

import utils.MyStopWatch;

/**
 Description: You are climbing a stair case. It takes n steps to reach to the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 Note: Given n will be a positive integer.

 Example 1:
     Input: 2
     Output: 2
     Explanation: There are two ways to climb to the top.
     1. 1 step + 1 step
     2. 2 steps

 Example 2:
     Input: 3
     Output: 3
     Explanation: There are three ways to climb to the top.
     1. 1 step + 1 step + 1 step
     2. 1 step + 2 steps
     3. 2 steps + 1 step
 */
public class No70ClimingStairs {

    public int climbStairs(int n) {
        // recursive: Time Limit Exceeded
        if (n < 0) return 0;
        else if (n == 0 || n == 1) return 1;
        else return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs2(int n) {
        // iterative:
        int f = 1, cur = 1, pre = 1;
        while (f != n) {
            int t = cur;
            cur = cur + pre;
            pre = t;
            f += 1;
        }
        return cur;
    }

    public static void main(String[] args) {

        No70ClimingStairs instance = new No70ClimingStairs();

        MyStopWatch.start();
        int res = instance.climbStairs(45);
        MyStopWatch.stop();
        System.out.println("Recursive: Result is " + res + " and " + MyStopWatch.countTime());

        MyStopWatch.start();
        int res2 = instance.climbStairs2(45);
        MyStopWatch.stop();
        System.out.println("Iterative: Result is " + res2 + " and " + MyStopWatch.countTime());
    }
}
