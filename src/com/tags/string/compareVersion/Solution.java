package com.tags.string.compareVersion;

public class Solution {

    public static void main(String[] args) {

        int result = compareVersion("1.22.3", "1.02.2");
        System.out.println(result);
    }

    /**
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion(String version1, String version2) {


        int i = 0;
        int m = version1.length();;

        int j = 0;
        int n = version2.length();

        while (i < m || j < n) {

            int num1 = 0, num2 = 0;

            while (i < m && version1.charAt(i) != '.') {
                num1 = num1 * 10 + version1.charAt(i++) - '0';
            }

            while (j < n && version2.charAt(j) != '.') {
                num2 = num2 * 10 + version2.charAt(j++) - '0';
            }

            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }

            i++;
            j++;
        }
        return 0;
    }

   

}
