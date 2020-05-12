package com.muehda.sparsearray;

/**
 * @Description 稀疏数组的实现
 * @Author fengjl
 * @Date 2019/8/12 22:57
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class sparsearray {
    public static void main(String[] args) {
        // 1、初始化棋牌的大小
        int[][] chessarray1 = new int[11][11];
        // 2、给棋盘上的棋子赋值
        chessarray1[1][2] = 1;
        chessarray1[2][3] = 2;
        chessarray1[4][5] = 2;
        // 3、把棋牌格式化打印出来
        System.out.println("原始数组为：");
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(chessarray1[i][j]+"\t");
            }
            System.out.println();
        }

        // 将二维数组转换为稀疏数组
        // 1、记录数组中数值不为0的个数
        int num = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessarray1[i][j] != 0) {
                    num++;
                }
            }
        }
        // 2、初始化稀疏数组
        int[][] sparsearray = new int[num+1][3];
        // 3、给稀疏数组的第一行赋值
        sparsearray[0][0] = 11;
        sparsearray[0][1] = 11;
        sparsearray[0][2] = num;
        // 4、遍历原始二维数组给，稀疏数组的其他位置赋值
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessarray1[i][j] != 0) {
                    count++;
                    sparsearray[count][0] = i;
                    sparsearray[count][1] = j;
                    sparsearray[count][2] = chessarray1[i][j];
                }
            }
        }

        // 5、遍历压缩后的稀疏数组
        System.out.println("压缩后的稀疏数组为：");
        for (int[] ints : sparsearray) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }

        //将稀疏数组还原
        // 1、初始原数组
        int[][] chessarray2 = new int[sparsearray[0][0]][sparsearray[0][1]];
        // 2、给原数组赋值
        for (int i = 1; i < sparsearray.length; i++) {
            chessarray2[sparsearray[i][0]][sparsearray[i][1]] = sparsearray[i][2];
        }
        // 3、将原数组打印出来
        System.out.println("还原后的数组为：");
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(chessarray2[i][j]+"\t");
            }
            System.out.println();
        }


    }
}
