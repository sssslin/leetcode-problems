package com.tags.array;

/**
 * Leetcode 第十一题
 */
public class MaxArea {

  public static void main(String[] args) {

    int[] test = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int max = maxArea(test);
    System.out.println(max);
  }


  public static int maxArea(int[] height) {

    int max = 0;
    for (int i = 0; i < height.length; i++) {
      for (int j = 1; j + i < height.length; j++) {
        int h = height[i] < height[i + j] ? height[i] : height[i + j];
        int range = j;
        int sqr = h * range;
        if (sqr > max) {
          max = sqr;
        }
      }
    }
    return max;
  }

  public static int maxArea2(int[] height) {
    int res = 0, i = 0, j = height.length - 1;
    while (i < j) {
      res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
      // 为什么要比较两边的高度?
      if (height[i] < height[j]) ++i;
      else --j;
    }
    return res;
  }
}
