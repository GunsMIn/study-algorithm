package com.example.studyalgorithm;

import java.util.Scanner;

    public class ZigzagMatrix {
        public static long solution(int n, int r, int c) {
            // Adjust indices to be zero-based for easier calculations
            r--;
            c--;

            if (r % 2 == 0) {
                // Even rows (0-based): numbers increase left to right
                return (long) r * n + c + 1;
            } else {
                // Odd rows (0-based): numbers increase right to left
                return (long) r * n + (n - c);
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter matrix size n: ");
            int n = scanner.nextInt();
            System.out.print("Enter row number r: ");
            int r = scanner.nextInt();
            System.out.print("Enter column number c: ");
            int c = scanner.nextInt();

            System.out.println("The number at position (" + r + ", " + c + ") is: " + solution(n, r, c));
            scanner.close();
        }
    }

