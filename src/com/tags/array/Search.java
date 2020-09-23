package com.tags.array;

/**
 * 这道题是有思路可以做出来的
 *
 * 这道题要求的时间复杂度是O(log(n)),其实就是暗示，我们要用二分法做，不然时间复杂度满足不了要求
 * 而且，根据题目描述，数组是部分有序的，我们所做的所有分析建立在这个上面
 *
 * 划定一个mid = (start + end) / 2
 * 如果start < mid，说明前半段有序，
 *      再判断target是否在[start,end]之间，则需要将end 设为mid - 1(等于的情况已经判断了)
 *      否则，start = mid + 1
 * 否则则说明是后半段有序,与前半段类似进行判断
 *      再判断target是否在[mid,end]之间，则需要将start 设为mid + 1(等于的情况已经判断了)
 *      否则，end = mid - 1
 *  本题还有一个难点就是，如何处理等于号的情况，由于先处理了相等的情况，所以和mid的比较，都可以
 *  避免相等的情况
 * 本解法复杂度：space---O(1),time---O(logn)
 */
public class Search {

    public static void main(String[] args) {
        int nums[] = {4, 5, 6, 0, 1, 2};

        int result = search(nums, 3);
        System.out.println(result);
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int lo = 0;
        int hi = nums.length - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 这里判断的依据是，保证遍历的数组，都是升序的，避开有旋转的部分，
            // 只有这样，才能通过边缘值判断target在不在这个区间内
            if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
