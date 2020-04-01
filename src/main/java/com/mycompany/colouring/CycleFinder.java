/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.colouring;

import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import org.jgrapht.Graph;

/**
 *
 * @author jessica
 */
public class CycleFinder {

    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = new int[n][n];

//JohnsonSimpleCycles​(Graph<V,​E> graph)
        int row = 0;
        int column = 0;
        while (row < n) {
            if (matrix[row][column] < n) {
                matrix[row][column]++;

                if (row > 0) {
                    for (int i = 0; i < row; i++) {
                        Arrays.fill(matrix[i], 0);
                    }
                }
                if (column > 0) {
                    for (int j = 0; j < column; j++) {
                        matrix[row][j] = 0;
                    }

                }
                row = 0;
                column = 0;
//                    times++;
                if (checkMatrixValid(matrix)) {
//                    System.out.println("matrix");
//                    for (int i = 0; i < n; i++) {
//                        for (int j = 0; j < n; j++) {
//                            System.out.print(matrix[i][j] + " ");
//                        }
//                        System.out.println();
//                    }
                }

            } else {
                if (column < n - 1) {
                    column++;
                } else {
                    row++;
                    column = 0;
                }
            }
//            System.out.println("times "+times);
            //System.out.println("exited while loop");

        }

    }

    public static boolean checkMatrixValid(int[][] matrix) {
        for (int[] row : matrix) {
            Set<Integer> set = new HashSet<>();

            // Iterate through the array 
            for (int t : row) {
                // Add each element into the set 
                set.add(t);
            }

            if (set.size() > 2) {

                return false;
            } else {
//                System.out.println("row ");
//                for (int i=0;i<row.length;i++) {
//                    System.out.print(row[i]+" ");
//                }
//                System.out.println("set ");
//                for (int j:set) {
//                    System.out.print(j+" ");
//                }

            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int[] column = getColumn(matrix, i);
            Set<Integer> set = new HashSet<>();

            // Iterate through the array 
            for (int t : column) {
                // Add each element into the set 
                set.add(t);
            }
            if (set.size() > 2) {
                return false;
            }
        }
        return true;
    }

    public static int[] getColumn(int[][] array, int index) {
        int[] column = new int[array[0].length];
        for (int i = 0; i < column.length; i++) {
            column[i] = array[i][index];
        }
        return column;
    }

}
