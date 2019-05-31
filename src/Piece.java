public enum Piece {
    O, X, NONE;
    private Piece flipped;

    static {
        O.flipped = X;
        X.flipped = O;
    }

    public Piece getFlipped() {
        return flipped;
    }

    @Override
    public String toString() {
        if (this == O) return " O ";
        else if (this == X) return " X ";
        else return "   ";

    }
}