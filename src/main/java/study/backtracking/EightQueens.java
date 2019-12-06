package study.backtracking;

/**
 * 八皇后问题求解实现
 * 问题描述：
 * 在一个8 x 8 的棋盘上，希望往上面放8个棋子（Queen），
 * 每个棋子所在的行、列和对角线上都不能有另一个棋子存在
 *
 * @author:hxd
 * @date:2019/11/16
 */
public class EightQueens {
    /**
     * 记录满足条件的方法位置，下标表示 行，值表示 列
     */
    private int[] results = new int[8];
    /**
     * 总共有多少种放法
     */
    private int count = 0;

    private int n;

    EightQueens(int n) {
        this.n = n;
    }

    /**
     * 计算
     *
     * @param row
     */
    public void cal8Queens(int row) {
        // 八个棋子都放好了，打印结果
        if (row == n) {
            printQueens(results);
            return;
        }
        // 每一行都有八种放法
        for (int column = 0; column < n; column++) {
            // 此位置是否满足条件
            if (isOk(row, column)) {
                // 记录下来满足的位置
                results[row] = column;
                // 考察下一行
                cal8Queens(row + 1);
            }
        }
    }

    /**
     * 判断该行该列的位置是否满足条件
     *
     * @param row
     * @param column
     * @return
     */
    private boolean isOk(int row, int column) {
        // 考察位置左边列
        int leftColumn = column - 1;
        // 考察位置右边列
        int rightColumn = column + 1;
        // 从考察位置上一行开始检查
        for (int i = row - 1; i >= 0; i--) {
            // 正上方是否满足
            if (results[i] == column) {
                return false;
            }
            // 左上对角线是否满足
            if (leftColumn >= 0 && results[i] == leftColumn) {
                return false;
            }
            // 右上对角线是否满足
            if (rightColumn < n && results[i] == rightColumn) {
                return false;
            }
            // 一次检查对角线上的每个位置
            leftColumn--;
            rightColumn++;
        }
        return true;
    }

    /**
     * 打印二维矩阵
     *
     * @param results
     */
    private void printQueens(int[] results) {
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (results[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println(++count);
        System.out.println();
    }
}
