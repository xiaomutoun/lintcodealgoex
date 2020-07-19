import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        Map<Integer, Integer> map = new HashMap<>();
        int i = 1;
    }


    public int minDistance(int[] a, int m) {
        Arrays.sort(a);
        int n = a.length, max = 1 << 29;
        int[][] dp = new int[m + 1][n + 1], cost = new int[n][n + 1];
        for (int i = 0; i < dp.length; ++i) Arrays.fill(dp[i], max);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                cost[i][j] = 0;
                int p = (i + j) / 2;
                for (int k = i; k < j; ++k) cost[i][j] += Math.abs(a[p] - a[k]);
            }
        }
        dp[0][0] = 0;
        for (int k = 1; k <= m; ++k) {
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= i; ++j) {
                    dp[k][i] = Math.min(dp[k][i], cost[i - j][i] + dp[k - 1][i - j]);
                }
            }
        }
        return dp[m][n];
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}