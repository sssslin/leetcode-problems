package com.tags.algorithm.binarySearch.integer;


/**
 * 二分模板一共有两个，分别适用于不同情况。
 * 算法思路：假设目标值在闭区间[l, r]中， 每次将区间长度缩小一半，当l = r时，我们就找到了目标值。
 *
 * 模板中的check方法，指的是，按照要求，需要自己写的校验方法，一般和题目要求有关
 */
public class Template {

    /**
     * 当我们将区间[left, right]划分成[left, mid]和[mid + 1, right]时，
     * 其更新操作是right = mid或者left = mid + 1;，计算mid时不需要加1。
     */
    int binarySearch1(int left, int right) {
        while (left < right) {
            int mid = left + right >> 1;
            if (check(mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    /**当我们将区间[left, right]划分成[left, mid - 1]和[mid, right]时，其更新操作是right = mid - 1或者left = mid;
     * 此时为了防止死循环，计算mid时需要加1。
     */
    int binarySearch2(int left, int right) {
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (check(mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static boolean check(int mid) {
        return false;
    }
}
