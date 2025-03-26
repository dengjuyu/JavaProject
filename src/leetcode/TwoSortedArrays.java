package leetcode;

import java.util.Arrays;

public class TwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] nums3 = new int[len1 + len2];
        System.arraycopy(nums1, 0, nums3, 0, len1);
        System.arraycopy(nums2, 0, nums3, len1, len2);

        Arrays.sort(nums3);

        int len3 = nums3.length;

        double res = 0;

        if (len3 % 2 == 0) {
            res = (double) (nums3[len3 / 2] + nums3[(len3 / 2) - 1]) / 2;
        } else {
            res = nums3[(len3 - 1) / 2];
        }

        System.out.println(res);
    }
}
