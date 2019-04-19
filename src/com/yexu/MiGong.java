package com.yexu;

/**
 * ${DESCRIPTION}
 *
 * @Author: chaizhengmao
 * @Date: 2019/3/27 10:15
 */
public class MiGong {

    private static int[][] map;
    private static int endRow = 6;
    private static int endCol = 5;

    public static void initMap(int row, int col) {
        map = new int[row][col];
        for (int i = 0; i < col; i++) {
            map[0][i] = 1;
            map[row - 1][i] = 1;
        }
        for (int i = 0; i < row; i++) {
            map[i][0] = 1;
            map[i][col - 1] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
    }

    public static void listMap() {
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //使用递归回溯来找路
    //1. map 表示地图
    //2. i j 是指定从地图的哪个点开始出发 (1,1)
    //3. 约定 元素的值 0: 可以走还没有走 1 : 墙 2: 表示可以走 3 : 表示已经走过，但是是死路
    //确定一个策略: 下=》右=》上=》左
    //修改策略 上=》右=》下=》左
    public static boolean setWay(int startRow, int startCol) {
        //找到了
        if (map[endRow][endCol] == 2) {
            return true;
        } else {
            //可以走，但没走
            if (map[startRow][startCol] == 0) {
                //从这里开始递归回溯
                map[startRow][startCol] = 2;//可以走，但是还没走
                //策略，下=》右=》上=》左
                if (setWay(startRow + 1, startCol)) {
                    return true;
                } else if (setWay(startRow, startCol + 1)) {
                    return true;
                } else if (setWay(startRow - 1, startCol)) {
                    return true;
                } else if (setWay(startRow, startCol - 1)) {
                    return true;
                }else{
                    //走不通
                    map[startRow][startCol] = 3;
                    return false;
                }
            }else{ //如果 map[i][j]!=0 //则值 1,2,3
                return false;
            }
        }
    }

    public static void main(String[] args) {
        initMap(8, 7);
        listMap();
        setWay(1,1);
        listMap();
    }
}
