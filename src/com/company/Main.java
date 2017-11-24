package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static int minLine;
    private static int maxCol;
    private static int matrixSize;

    public static void main (String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter matrix size:");
        matrixSize = scanner.nextInt();
        System.out.println(matrixSize);
        int[][] matrix = generateMatrix();
        printMatrix(matrix);
        findValues(matrix);
        System.out.println("Min value line(index): " + minLine);
        System.out.println("Max value col(index): " + maxCol);
    }

    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrixSize; i++) {
            for(int j = 0; j < matrixSize; j++) {
                if (j == matrixSize - 1) System.out.println(matrix[i][j]);
                else System.out.print(matrix[i][j] + " | ");
            }
        }
    }

    public static void findValues(int[][] matrix) {
        int min = matrix[0][0];
        int max = matrix[0][0];

        for(int i = 0; i < matrixSize; i++) {
            for(int j = 0; j < matrixSize; j++) {
                if(matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxCol = j;
                }
                else if(matrix[i][j] < min) {
                    min = matrix[i][j];
                    minLine = i;
                }
            }
        }
    }

    public static int[][] generateMatrix() {
        int[][] matrix = new int[matrixSize][matrixSize];

        for(int i = 0; i < matrixSize; i++) {
            for(int j = 0; j < matrixSize; j++) {
                matrix[i][j] = randomValue();
            }
        }

        return matrix;
    }

    public static int randomValue() {
        return (int)(Math.random() * 100);
    }
}