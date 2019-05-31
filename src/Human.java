import java.util.Scanner;

public class Human implements Player {
    Board board;
    Piece piece;

    public Human(Board board, Piece piece) {
        this.board = board;
        this.piece = piece;
    }

    @Override
    public boolean makeMove(){
        System.out.println("podaj wsp X i Y");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt(), y = in.nextInt();
        return board.move(this.piece, x, y);

    }
}
