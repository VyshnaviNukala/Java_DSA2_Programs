class Solution {
    public boolean isValidSudoku(char[][] board) {
   
    for (int i = 0; i < 9; i++) {
        Set<Character> rowSet = new HashSet<>();
        for (int j = 0; j < 9; j++) {
            char digit = board[i][j];
            if (digit == '.') continue;
            if (rowSet.contains(digit)) return false;
            rowSet.add(digit);
        }
    }
    
   
    for (int j = 0; j < 9; j++) {
        Set<Character> colSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            char digit = board[i][j];
            if (digit == '.') continue;
            if (colSet.contains(digit)) return false;
            colSet.add(digit);
        }
    }
   
    for (int k = 0; k < 9; k++) {
        Set<Character> boxSet = new HashSet<>();
        int iStart = (k / 3) * 3;
        int jStart = (k % 3) * 3;
        for (int i = iStart; i < iStart + 3; i++) {
            for (int j = jStart; j < jStart + 3; j++) {
                char digit = board[i][j];
                if (digit == '.') continue;
                if (boxSet.contains(digit)) return false;
                boxSet.add(digit);
            }
        }
    }
    
    return true;
}

}