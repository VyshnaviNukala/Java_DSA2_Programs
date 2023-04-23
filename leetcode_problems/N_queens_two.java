class Solution {
    private int count;

    public int totalNQueens(int n) {
        count = 0;
        int[] cols = new int[n];
        boolean[] diag = new boolean[2 * n - 1];
        boolean[] antidiag = new boolean[2 * n - 1];
        backtrack(0, n, cols, diag, antidiag);
        return count;
    }

    private void backtrack(int row, int n, int[] cols, boolean[] diag, boolean[] antidiag) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols[col] == 0 && !diag[row - col + n - 1] && !antidiag[row + col]) {
                cols[col] = row + 1;
                diag[row - col + n - 1] = true;
                antidiag[row + col] = true;
                backtrack(row + 1, n, cols, diag, antidiag);
                cols[col] = 0;
                diag[row - col + n - 1] = false;
                antidiag[row + col] = false;
            }
        }
    }
}