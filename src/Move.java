public class Move {
    int x;
    int y;
    Piece piece;

    public Move() {
    }

    public Move(Piece piece, int x, int y) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    @Override
    public String toString() {
        return x+" "+y;
    }
}
