public class Test {

    public int climbStairs(int n) {
        if (n < 0) return 0;
        else if (n == 0 || n == 1) return 1;
        else return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        String s = Integer.toBinaryString(-3);
        System.out.println(s.charAt(1));
    }
}
