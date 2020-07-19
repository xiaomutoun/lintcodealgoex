package bit_manipulation;

public class BitManip {
    public static void main(String[] args) {

        // Basis:
        // 1. >> and >>>
        if (true) {
            System.out.println("-128 >> 3 = " + (-128 >> 3));
            System.out.println("-128 >>> 3 = " + (-128 >>> 3));
            System.out.println("128 >> 3 = " + (128 >> 3));
            System.out.println("128 >>> 3 = " + (128 >>> 3));
        }

        // ============================================

        // Application:
        // 1. to calculate 2**n: 2**n = 1 << k
        for (int i = 0; i < 11; i++){
            // System.out.println("2^" + i + " = " + (1 << i));
        }
    }
}
