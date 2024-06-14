import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* Input matrix A dimensions */
        System.out.print("Enter the number of rows and columns for matrix A: ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        /* Input matrix A elements */
        int[][] matrixA = new int[n][m];
        System.out.println("Enter the elements of matrix A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        /* Input matrix B dimensions */
        System.out.print("Enter the number of rows and columns for matrix B: ");
        int r = scanner.nextInt();
        int p = scanner.nextInt();

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
                matrixB[i][j] = scanner.nextInt();
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
