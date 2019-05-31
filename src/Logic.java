public class Logic {
    public static int maxNoDiagonal(Piece[][] board, Piece piece) {
        int size = board.length;
        int max = 0;
        int tmp1 = 0, tmp2 = 0;
        boolean previous1 = false, previous2 = false;
        for (int i = 0; i < size; i++) {
            int x = 0, y = i;
            while (x <= i) {
                if (previous1 = false) {
                    tmp1 = 0;
                }
                if (previous2 = false) {
                    tmp1 = 0;
                }
                if (board[x][y] == piece) {
                    tmp1++;
                    previous1 = true;
                } else
                    previous1 = false;
                max = Math.max(max, tmp1);
                if (board[size - 1 - x][size - 1 - y] == piece) {
                    tmp2++;
                    previous2 = true;
                } else previous2 = false;
                max = Math.max(max, tmp2);

                x++;
                y--;
            }
            tmp1 = 0;
            tmp2 = 0;
        }

        return max;

    }

    public static int maxNoAntiDiagonal(Piece[][] board, Piece piece) {
        int size = board.length;
        int max = 0, tmp1 = 0, tmp2 = 0;
        boolean previous1 = false, previous2 = false;
        for (int i = 0; i < size; i++) {
            int x = size - 1 - i, y = size - 1;
            while (x >= 0) {
                if (!previous1) tmp1 = 0;
                if (!previous2) tmp2 = 0;
                if (board[x][y] == piece) {
                    tmp1++;
                    previous1 = true;
                } else previous1 = false;
                if (board[size - 1 - x][size - 1 - y] == piece) {
                    tmp2++;
                    previous2 = true;
                } else previous2 = false;
                max = Math.max(max, tmp1);
                max = Math.max(max, tmp2);
                x--;
                y--;
            }
            tmp1 = 0;
            tmp2 = 0;
        }
        return max;
    }

    public static int maxNoHorizontal(Piece[][] board, Piece piece) {
        int size = board.length;
        int max = 0, tmp = 0;
        boolean previous = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!previous) tmp = 0;
                if (board[i][j] == piece) {
                    tmp++;
                    previous = true;
                } else previous = false;
                max = Math.max(max, tmp);
            }
            tmp = 0;
        }
        return max;
    }

    public static int maxNoVertical(Piece[][] board, Piece piece) {
        int size = board.length;
        int max = 0, tmp = 0;
        boolean previous = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!previous) tmp = 0;
                if (board[j][i] == piece) {
                    tmp++;
                    previous = true;
                } else previous = false;
                max = Math.max(max, tmp);
            }
            tmp = 0;
        }
        return max;
    }

    public static Piece hasWin(Piece[][] board, int inRaw) {
        if (checkWin(board, Piece.X, inRaw)) return Piece.X;
        if (checkWin(board, Piece.O, inRaw)) return Piece.O;
        return Piece.NONE;
    }

    private static boolean checkWin(Piece[][] board, Piece piece, int inRaw) {
        if (maxNoAntiDiagonal(board, piece) >= inRaw ||
                maxNoDiagonal(board, piece) >= inRaw ||
                maxNoHorizontal(board, piece) >= inRaw ||
                maxNoVertical(board, piece) >= inRaw) return true;
        return false;
    }

    public static Move firstDifference(Piece[][] root, Piece[][] child) {
        if (root.length != child.length) return null;
        for (int i = 0; i < root.length; i++) {
            for (int j = 0; j < root.length; j++) {
                if (root[i][j] != child[i][j]) {
                    return new Move(child[i][j], i, j);
                }
            }
        }
        return null;
    }
    public static boolean gameOver(Piece[][] board){
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board.length ; j++) {
                if(board[i][j]==Piece.NONE)return false;
            }
        }
        return true;
    }
}
