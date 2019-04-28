package algorithm.leetcode.etc;

public class LC067 {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int pA = a.length() - 1;
        int pB = b.length() - 1;
        int carry = 0;

        while (pA >= 0 || pB >= 0) {
            int sum = carry;

            if (pA >= 0)
                sum += a.charAt(pA--) - '0';
            if (pB >= 0)
                sum += b.charAt(pB--) - '0';

            carry = sum / 2;
            sb.append(sum % 2);
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
//    public static String addBinary(String a, String b) {
//        int n = Math.max(a.length(), b.length());
//        int[] nums = new int[n + 1];
//        int pointA = a.length() - 1;
//        int pointB = b.length() - 1;
//
//        while (pointA >= 0 && pointB >= 0)
//            nums[n--] = (a.charAt(pointA--) - '0') + (b.charAt(pointB--) - '0');
//
//        while (pointA >= 0)
//            nums[n--] = a.charAt(pointA--) - '0';
//
//        while (pointB >= 0)
//            nums[n--] = b.charAt(pointB--) - '0';
//
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (nums[i] > 1) {
//                nums[i - 1] += 1;
//                nums[i] -= 2;
//            }
//            sb.append(nums[i]);
//        }
//        sb.reverse();
//
//        return sb.toString().charAt(0) == '0' ? sb.toString().substring(1) : sb.toString();
//    }

    public static void main(String[] args) {
        String a = "11010";
        String b = "1111011";
        System.out.println(addBinary(a, b));
        System.out.println(10010101);
//        a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
//        b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
//        System.out.println(addBinary(a, b));
//        System.out.println(b);
    }


}
