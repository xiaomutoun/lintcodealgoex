public class Test {

    public int[] plusOne(int[] digits) {
        int size = digits.length;
        boolean allNine = true;
        for (int i = 0; i < size; i++) {
            if (digits[i] != 9) {
                allNine = false;
                break;
            }
        }
        if (allNine) {
            int[] res = new int[size + 1];
            res[0] = 1;
            return res;
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (digits[i] != 9) {
                    digits[i] += 1;
                    return digits;
                } else {
                    digits[i] = 0;
                }
            }
            return digits;
        }
    }

    public static void main(String[] args) {
        String s = Integer.toBinaryString(-3);
        System.out.println(s.charAt(1));
    }
}
