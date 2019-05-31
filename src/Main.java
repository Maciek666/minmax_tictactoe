import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Board board = new Board(3, 3);
        System.out.println(board);
        List<Piece[][]> copy = new ArrayList<>();
        Piece piece = Piece.O;
        Player h1 = new Human(board, Piece.O);
        Player h2 = new AI(board, Piece.X);
        while (Logic.hasWin(board.getBoard(), board.getInRaw()) == Piece.NONE && !Logic.gameOver(board.getBoard())) {
            System.out.println("  " + piece + "turn");
            if (piece == Piece.O) {
                try {
                    h2.makeMove();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    h1.makeMove();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            piece = piece.getFlipped();
            System.out.println(board);
        }
        if (Logic.hasWin(board.getBoard(), board.getInRaw()) != Piece.NONE)
            System.out.println(piece.getFlipped() + "WIN");
        else System.out.println("REMIS");
    }

}
