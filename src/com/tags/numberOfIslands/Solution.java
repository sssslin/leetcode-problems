package com.tags.numberOfIslands;

/**
 * 思考:如何将实际问题抽象成一个常规的算法题
 * 建模的过程,就是抽象的过程,
 * 做算法题的第一步,应该是建模,把实际问题和对应的算法或者数据结构关联起来,
 * 然后用具体的数据结构和算法去解决.
 * 首先要培养的是这个方面的能力,这就要求知识面广,基础扎实
 * https://www.youtube.com/watch?v=hhBiPyr1Byo
 */
public class Solution {
    // Assumption
    final static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {

        // sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        final int rows = grid.length;
        final int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int x, int y, int rows, int cols) {
        // base case
        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == '0') {
            return;
        }

        // recursive rule
        grid[x][y] = '0';

        for (int[] dir : dirs) {
            int neiX = dir[0] + x;
            int neiY = dir[1] + y;
            dfs(grid, neiX, neiY, rows, cols);
        }
    }

}
