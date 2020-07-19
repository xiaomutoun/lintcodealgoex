package array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class No1499MaxValueOfEquation {

    /** Tag: priority queue, deque
     *
     * Given an array points containing the coordinates of points on a 2D plane, sorted by the
     * x-values, where points[i] = [xi, yi] such that xi < xj for all 1 <= i < j <= points.length.
     * You are also given an integer k.

     Find the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| <= k and
     1 <= i < j <= points.length. It is guaranteed that there exists at least one pair of points
     that satisfy the constraint |xi - xj| <= k.


     Example 1:
     Input: points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
     Output: 4
     Explanation: The first two points satisfy the condition |xi - xj| <= 1 and if we calculate
     the equation we get 3 + 0 + |1 - 2| = 4. Third and fourth points also satisfy the condition
     and give a value of 10 + -10 + |5 - 6| = 1.
     No other pairs satisfy the condition, so we return the max of 4 and 1.

     Example 2:
     Input: points = [[0,0],[3,0],[9,2]], k = 3
     Output: 3
     Explanation: Only the first two points have an absolute difference of 3 or less in the
     x-values, and give the value of 0 + 0 + |0 - 3| = 3.
     *
     */
    public int findMaxValueOfEquation(int[][] p, int k) {
        int res = Integer.MIN_VALUE;
        Deque<int[]> dq = new LinkedList<>();
        for (int[] pt: p) {
            while (!dq.isEmpty() && pt[0] - dq.getFirst()[0] > k) dq.pollFirst();
            if (!dq.isEmpty()) {
                res = Math.max(res, pt[0] + pt[1] + dq.getFirst()[1] - dq.getFirst()[0]);
                while (!dq.isEmpty() && pt[1] - pt[0] >= dq.getLast()[1] - dq.getLast()[0])
                    dq.pollLast();
            }
            dq.addLast(pt);
        }
        return res;
    }

    public int findMaxValueOfEquation2(int[][] p, int k) {
        int result = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - b[0] - (a[1] - a[0])));
        for (int[] point : p) {
            while (!pq.isEmpty() && point[0] - pq.peek()[0] > k) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                int[] head = pq.peek();
                result = Math.max(result, point[1] + head[1] + point[0] - head[0]);
            }
            pq.offer(point);
        }

        return result;
    }

    public static void main(String[] args) {
        No1499MaxValueOfEquation test = new No1499MaxValueOfEquation();
        int[][] pts = {{1, 3}, {2, 0}, {5, 10}, {6, -10}};
        int[][] pts2 = {{0, 0}, {3, 0}, {9, 2}};
        System.out.println(test.findMaxValueOfEquation(pts, 1) + " should be 4");
        System.out.println(test.findMaxValueOfEquation(pts2, 3) + " should be 3");
        System.out.println(test.findMaxValueOfEquation2(pts, 1) + " should be 4");
        System.out.println(test.findMaxValueOfEquation2(pts2, 3) + " should be 3");
    }
}
