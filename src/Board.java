public class Board {
    private int size;
    private int inRaw;
    private Piece[][] board;

    public Board(int size, int inRaw) {
        this.size = size;
        this.inRaw = inRaw;
        board = new Piece[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                board[i][j] = Piece.NONE;
            }
        }
    }

    public boolean move(Move move) {
        return move(move.piece, move.x, move.y);
    }

    public boolean move(Piece piece, int x, int y) {
        if (board[y][x] == Piece.NONE) {
            board[y][x] = piece;
            return true;
        }
        return false;
    }

    public int getInRaw() {
        return inRaw;
    }

    public Piece[][] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        int x = 0, y = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size * 2; i++) {
            for (int j = 0; j < size * 2; j++) {
                if (i % 2 == 0) {
                    if (i != 0)
                        sb.append("--");
                } else {
                    if (j % 2 == 1) {
                        if (j != size * 2 - 1)
                            sb.append("|");
                    } else {
                        sb.append(board[x][y]);
                        y++;
                    }
                }
            }
            sb.append("\n");
            y = 0;
            if (i % 2 == 1) x++;
        }
        return sb.toString();
    }
}
