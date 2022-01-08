package com.tags.reverse;

public class Solution {
    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            // 每次取末尾数字
            int tmp = x % 10;
            // 判断是否是 大于 最大的32位整数
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }

            // 判断是否 小于 最小的32位整数
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }

            res = res * 10 + tmp;
            x /= 10;
            System.out.print("tmp:" + tmp + "  ");
            System.out.print("res:" + res + "  ");
            System.out.println("x:" + x);
        }
        return res;
    }

    public static void main(String[] args) {
        // %:在Java中的运算规则是整除取余数
        int mod = -12345 % 10;
        //  System.out.println(mod);

        // /:在Java中默认返回整数,向下取整,相当于Math.floor()方法;
        int result = 12345 / 10;
       //    System.out.println(result);

        int reverseResult = reverse(12345);
        System.out.println(reverseResult);
    }
}
