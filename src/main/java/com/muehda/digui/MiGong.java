package com.muehda.digui;

/**
 * @Description
 * @Author fengjl
 * @Date 2019/8/31 13:40
 * @Version 1.0
 **/
public class MiGong {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        // 开始构建墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        // 设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        // 输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map, 1, 1);

        // 输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * 深入理解迷宫递归
     * ①：1：代表墙， 2：代表已经走过的路，3:代表路走不同，
     *
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j+1)) {
                    return true;
                } else if (setWay(map, i-1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    // 这个点的上下左右都不通的话，那么这个点设置为不通
                    map[i][j] = 3;
                    return false;
                }

            } else {
                // 不等于0 可能就是 123
                return false;
            }

        }
    }
}
