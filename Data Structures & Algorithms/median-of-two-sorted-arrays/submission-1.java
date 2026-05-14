class Solution {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int total = nums1.length + nums2.length;

    if (total % 2 == 1) {
      return findKth(nums1, nums2, total / 2 + 1);
    }

    int left = findKth(nums1, nums2, total / 2);
    int right = findKth(nums1, nums2, total / 2 + 1);

    return ((double) left + right) / 2.0;
  }

  private int findKth(int[] nums1, int[] nums2, int k) {
    int l1 = 0;
    int l2 = 0;

    while (true) {
      if (l1 == nums1.length) {
        return nums2[l2 + k - 1];
      }

      if (l2 == nums2.length) {
        return nums1[l1 + k - 1];
      }

      if (k == 1) {
        return Math.min(nums1[l1], nums2[l2]);
      }

      int target = k / 2;

      int len1 = nums1.length - l1;
      int len2 = nums2.length - l2;

      int step1 = Math.min(target, len1);
      int step2 = Math.min(target, len2);

      int num1 = nums1[l1 + step1 - 1];
      int num2 = nums2[l2 + step2 - 1];

      if (num1 <= num2) {
        l1 += step1;
        k -= step1;
      } else {
        l2 += step2;
        k -= step2;
      }
    }
  }

}