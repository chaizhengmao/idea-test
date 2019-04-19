package com.yexu;

import com.sun.istack.internal.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @Author: chaizhengmao
 * @Date: 2019/3/26 9:44
 */
public class SparseArray {
    public static void main(String[] args) throws Exception {
        int rowSize = 11;
        int colSize = 11;
        int difSize = 2;
        int[][] data = new int[rowSize][colSize];
        data[1][2] = 1;
        data[2][3] = 2;
        ArrayList<Node> nodes = new ArrayList<>();
//        Arrays.copyOf(nodes.toArray(),10);
        Arrays.toString(nodes.toArray());
        nodes.add(new Node(rowSize, colSize, difSize));
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + "\t");
                if (data[i][j] != 0) {
                    nodes.add(new Node(i, j, data[i][j]));
                }
            }
            System.out.println();
        }
        nodes.forEach(System.out::println);

        File file = new File("./sparsearray.txt");
        if (file.exists()) {
            file.delete();
            file = new File("./sparsearray.txt");
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(nodes);
        System.out.println("对象写入成功");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        List<Node> nodes1 = (List<Node>) (ois.readObject());
        nodes1.forEach(System.out::println);
        System.out.println("对象读入成功");
        int[][] recoverData = new int[nodes1.get(0).getRow()][nodes1.get(0).getCol()];
        nodes1.remove(0);
        nodes1.forEach((item) -> recoverData[item.getRow()][item.getCol()] = item.getValue());
        for (int i = 0; i < recoverData.length; i++) {
            for (int j = 0; j < recoverData[i].length; j++) {
                System.out.print(recoverData[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

class Node implements Serializable {
    private Integer row;
    private Integer col;
    private Integer value;

    public Node() {
        super();
    }

    public Node(@NotNull Integer row, Integer col, Integer value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    @NotNull public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "row=" + row +
                ", col=" + col +
                ", value=" + value +
                '}';
    }
}
