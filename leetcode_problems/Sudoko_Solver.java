class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    
    private boolean solve(char[][] board, int row, int col) {
        if (row == 9) {
            // We've filled all the cells, so we're done
            return true;
        }
        
        if (col == 9) {
            // We've filled all the cells in the current row, so move to the next row
            return solve(board, row + 1, 0);
        }
        
        if (board[row][col] != '.') {
            // This cell is already filled, so move to the next one
            return solve(board, row, col + 1);
        }
        
        // Try to fill the current cell with a valid digit
        for (char digit = '1'; digit <= '9'; digit++) {
            if (isValid(board, row, col, digit)) {
                board[row][col] = digit;
                if (solve(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        
        // We couldn't find a valid digit, so backtrack
        return false;
    }
    
    private boolean isValid(char[][] board, int row, int col, char digit) {
        // Check if the digit is already present in the same row or column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit || board[i][col] == digit) {
                return false;
            }
        }
        
        // Check if the digit is already present in the same 3x3 sub-box
        int subBoxRow = (row / 3) * 3;
        int subBoxCol = (col / 3) * 3;
        for (int i = subBoxRow; i < subBoxRow + 3; i++) {
            for (int j = subBoxCol; j < subBoxCol + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }
        
        // The digit is valid
        return true;
    }
}
