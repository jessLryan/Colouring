/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.colouring;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author jessica
 */
public class CycleFinder {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        
         List<int[][]> adjMatrices = allValidMatrices(n);
//         for (int[][] matrix:adjMatrices) {
//             System.out.println("matrix");
//             for (int[] row : matrix) {
//                 System.out.println();
//                 for (int i=0;i<row.length;i++) {
//                     System.out.print(row[i]+" ");
//                 }
//             }
//             System.out.println();
//         }
     }
    
    public static List<int[][]> allValidMatrices(int n) {
        List<int[][]> validMatrices = new ArrayList<int[][]>();
        List<ArrayList<Integer>> total = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> soFar = new ArrayList<Integer>();
        allCombos(total,soFar, n);
        for (ArrayList<Integer> colours : total) {
            int[][] matrix = new int[n][n];
            int rowNo = 0;
            for (int i=0;i<n-i;i+=n) {
                int[] row = colours.subList(i, i+n).stream().mapToInt(j -> j).toArray();
                matrix[rowNo] = row;
            }
            if (checkMatrixValid(matrix)) {
                validMatrices.add(matrix);
            }
        }
        return validMatrices;
    }
    
    public static boolean checkMatrixValid(int[][] matrix) {
        for (int[] row : matrix) {
            Set mySet = Set.of(row);
            if (mySet.size()>2) {
                return false;
            }
        }
        for (int i=0;i< matrix.length;i++) {
            int[] column = getColumn(matrix,i);
            Set mySet = Set.of(column);
            if (mySet.size()>2) {
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
    
    public static void allCombos(List<ArrayList<Integer>> total, ArrayList<Integer> soFar, int n) {
        for (int i = 0; i < n + 1; i++) {
            ArrayList<Integer> newSoFar = (ArrayList<Integer>) soFar.clone();
            newSoFar.add(i);
            if (newSoFar.size() == (n * n)) {
                total.add(newSoFar);
            } else {
                allCombos(total, newSoFar, n);
            }
        }
    }
    
}
