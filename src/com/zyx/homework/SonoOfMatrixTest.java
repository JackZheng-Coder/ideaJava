package com.zyx.homework;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */

/**
 * 矩阵包含  判断大矩阵中与小矩阵最相似的块
 * 输入: 矩阵A和矩阵B(B的行和列皆小于A),
 * 输出: 矩阵A中, 和矩阵B最相似的子矩阵C
 * 最相似: B和C的对应元素差值最小
 * 样例输入:
 * 3 4 5
 * 5 3 4
 * 8 2 4
 * end
 * 7 3
 * 4 9
 * end
 * 样例输出:
 * 4 5
 * 3 4
 */

/**
 * 思路：把矩阵A分割成n+1个跟矩阵B一样的子矩阵，然后矩阵B对应元素减去对于子元素，并保持大小。将得到n+1个差值集合，将差值集合相加，
 * 最小的和为的子矩阵为该最相似矩阵
 */
public class SonoOfMatrixTest {
    public static void main(String[] args) {
        // 读取输入
        Scanner scanner = new Scanner(System.in);
        List<String> lines_A = new ArrayList<>();
        List<String> lines_B = new ArrayList<>();
        boolean flag = false;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (flag && line.equals("end"))
                break;
            if (line.equals("end")) {
                flag = true;
                continue;
            }
            if (!flag)
                lines_A.add(line);
            else
                lines_B.add(line);
        }
        int[][] A = parse(lines_A);
        int[][] B = parse(lines_B);
        // 计算最相似块
        int[][] C = new int[B.length][B[0].length];// 存储最相似子矩阵
        int min = Integer.MAX_VALUE;// 相应元素的最小差值
        for (int i = 0; i <= (A.length - B.length); ++i) {
            for (int j = 0; j <= (A[0].length - B[0].length); ++j) {// 遍历A中的块
                int sumOfBlock = 0;
                // 遍历B矩阵并计算其与A矩阵相应块的差值的和
                for (int m = 0; m < B.length; ++m) {
                    for (int n = 0; n < B[0].length; ++n) {
                        sumOfBlock += substract(A[i + m][j + n], B[m][n]);
                    }
                }
                if (min > sumOfBlock) {
                    min = sumOfBlock;
                    for (int m = 0; m < B.length; ++m)
                        for (int n = 0; n < B.length; ++n)
                            C[m][n] = A[i + m][j + n];
                }
            }
        }
        // 输出
        for (int m = 0; m < C.length; ++m) {
            for (int n = 0; n < C.length; ++n)
                System.out.print(C[m][n] + " ");
            System.out.println();
        }

    }

    // 用较大值减较小值
    public static int substract(int a, int b) {
        return (a > b) ? a - b : b - a;
    }

    // 将字符串转为整型矩阵
    public static int[][] parse(List<String> lines) {
        String[] lineOne = lines.get(0).split(" ");
        int[][] matrix = new int[lines.size()][lineOne.length];

        for (int i = 0; i < lines.size(); ++i) {
            String[] line = lines.get(i).split(" ");
            for (int j = 0; j < matrix.length; ++j)
                matrix[i][j] = Integer.parseInt(line[j]);
        }
        return matrix;
    }
}
