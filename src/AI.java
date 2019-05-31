public class AI implements Player {
    Board board;
    Piece piece;

    public AI(Board board, Piece piece) {
        this.board = board;
        this.piece = piece;
    }

    public double cost(Piece[][] board) {
        Piece winner = Logic.hasWin(board, this.board.getInRaw());
        if (winner == piece) return 10;
        else if (winner == Piece.NONE) return 0;
        else return -10;
    }


    private double minmax(Piece[][] node, int depth, double alpha, double beta, boolean maximizingPlayer) {
        if (depth <= 0 || Logic.hasWin(node, board.getInRaw()) != Piece.NONE || Logic.gameOver(node)) {
            return cost(node);
        }

        if (maximizingPlayer) {
            double maxEval = Double.NEGATIVE_INFINITY;

            for (int j = 0; j < node.length; j++) {
                for (int i = 0; i < node.length; i++) {
                    if (node[j][i] == Piece.NONE) {

                        node[j][i] = piece;
                        double eval = minmax(node, depth - 1, alpha, beta, false);
                        node[j][i] = Piece.NONE;
                        maxEval = Math.max(maxEval, eval);
                        alpha = Math.max(alpha, eval);
                        if (beta <= alpha) return maxEval;
                    }
                }
            }
            return maxEval;
        } else {
            double minEval = Double.POSITIVE_INFINITY;
            for (int j = 0; j < node.length; j++) {
                for (int i = 0; i < node.length; i++) {
                    if (node[j][i] == Piece.NONE) {

                        node[j][i] = piece.getFlipped();
                        double eval = minmax(node, depth - 1, alpha, beta, true);
                        node[j][i] = Piece.NONE;
                        minEval = Math.min(minEval, eval);
                        beta = Math.min(beta, eval);
                        if (beta <= alpha) return minEval;
                    }
                }
            }
            return minEval;
        }
    }

    public Move findBest(Piece[][] board) {
        double maxEval = Double.NEGATIVE_INFINITY;
        Move move = new Move(piece, -1, -1);
        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board.length; i++) {

                if (board[j][i] == Piece.NONE) {

                    board[j][i] = this.piece;

                    double eval = minmax(board, 7, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, false);

                    board[j][i] = Piece.NONE;

                    if (maxEval < eval) {
                        maxEval = eval;
                        move = new Move(piece, i, j);
                    }

                }
            }
        }

        return move;
    }

    @Override
    public boolean makeMove() {
        board.move(findBest(this.board.getBoard()));
        System.gc();
        return false;
    }
}

