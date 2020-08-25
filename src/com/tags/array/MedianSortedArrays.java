package com.tags.array;

/**
 * 参考链接
 * https://blog.csdn.net/chen_xinjia/article/details/69258706
 * https://www.youtube.com/watch?v=do7ibYtv5nk&feature=emb_rel_end
 */
public class MedianSortedArrays {

  public static void main(String[] args) {
//    int[] nums1 = {3, 5, 8, 9};
    int[] nums1 = {1,2};
    int[] nums2 = {3,4};

//    int[] nums1 = {1,3};
//    int[] nums2 = {2};
    double median = findMedianSortedArrays(nums1, nums2);
    System.out.println(median);

  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // 保证对长度小的数组进行切分,会让时间复杂度降低
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    }

    int len = nums1.length + nums2.length;
    int cut1 = 0;// 表示第一个数组要切出的元素个数
    int cut2 = 0;// 表示第二个数组元素要切除的元素个数
    int cutL = 0;// 第一个数组的左边界
    int cutR = nums1.length;// 第一个数组的右边界
    // Integer.MIN_VALUE 以及 Integer.MAX_VALUE是考虑切在边缘的时候用于比较用的
    while (cut1 <= nums1.length) {// 这个保证切的不对的时候,再移位之后重新切
      // 该题的中心思想是两个数组合并成一个,然后开始做
      cut1 = (cutR - cutL) / 2 + cutL;// 对整个数组进行二分
      cut2 = len / 2 - cut1;// cut1位置确定后,cut的位置也就确定了,因此,nums1,nums2切点两侧的数据都能确定了
      // L1代表第一个数组切的一刀的左边的数字
      double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
      // L2代表第二个数组切的一刀的左边的数字
      double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
      // R1代表第二个数组切的一刀的右边的数字
      double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
      // R2代表第二个数组切的一刀的右边的数字
      double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
      // 这部分代码只有在切的不对的时候才执行,根据情况进行左移,或者右移
      // 切的正确的一刀应该符合: L1 <= R2 且 L2 <=R1
      // 然后对取的数进行比较,如果不符合上面那个公式,说明切的不对,得移位,具体左移或者右移得如下
      if (L1 > R2) {
        // 左移
        cutR = cut1 - 1;
      } else if (L2 > R1) {
        // 右移
        cutL = cut1 + 1;
      } else {
        // 处理奇偶问题
        if (len % 2 == 0) {
          // 左边取最大值
          L1 = L1 > L2 ? L1 : L2;
          // 右边取最小值
          R1 = R1 < R2 ? R1 : R2;
          return (L1 + R1) / 2;
        } else {
          R1 = (R1 < R2) ? R1 : R2;
          return R1;
        }
      }
    }
    return -1;
  }
}
