class Solution {
    List<List<String>> res = new ArrayList<>();
    int[] queens;
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        queens = new int[n];
        Arrays.fill(queens, -1);
        backtrack(0);
        return res;
    }

    public void backtrack(int row) {
        if (row == n) {
            addSolution();
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                queens[row] = col;
                backtrack(row + 1);
                queens[row] = -1;
            }
        }
    }

    public boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) {
                return false;
            }
            if (Math.abs(row - i) == Math.abs(col - queens[i])) {
                return false;
            }
        }
        return true;
    }

    public void addSolution() {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            solution.add(new String(row));
        }
        res.add(solution);
    }
}
