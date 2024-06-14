import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 0, m = 0, p = 0, r=0;

        /* Input matrix A dimensions */
        System.out.print("Enter the number of rows and columns for matrix A: ");
        while (true) {
            try {
                n = scanner.nextInt();
                m = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter integer values only.");
                return;
            }
        }

        /* Input matrix A elements */
        int[][] matrixA = new int[n][m];
        System.out.println("Enter the elements of matrix A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                while (true) {
                    try {
                        matrixA[i][j] = scanner.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Enter integer values only.");
                        return;
                    }
                }
            }
        }

        /* Input matrix B dimensions */
        System.out.print("Enter the number of rows and columns for matrix B: ");
        while (true) {
            try {
                r = scanner.nextInt();
                p = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter integer values only.");
                return;
            }
        }

        /* check to ensure the inner dimensions match:
           value of column in matrixA should equal value of row in MatrixB */
        if (m != r) {
            System.out.println("Matrix multiplication not possible. The number of columns in A must equal the number of rows in B.");
            return;
        }

        /* Input matrix B elements */
        int[][] matrixB = new int[r][p];
        System.out.println("Enter the elements of matrix B:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < p; j++) {
                while (true) {
                    try {
                        matrixB[i][j] = scanner.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter an integer value.");
                        return;
                    }
                }
            }
        }

        scanner.close();

        /* Initialize matrix C */
        int[][] matrixC = new int[n][p];

        /* Perform matrix multiplication */
        for (int i = 0; i < n; i++) {                   // row of MatrixA
            for (int j = 0; j < p; j++) {               // column of MatrixB

                for (int k = 0; k < m; k++) {           // k represents the changing values, in both matrices i and j don't change
                                                        // it is k which changes in the row(MatrixA) across and column(MatrixB) down
                    matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        /* Output the result */
        System.out.println("Matrix C (Result of multiplication):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                System.out.print(matrixC[i][j] + " ");
            }
            System.out.println();
        }

    }
}
