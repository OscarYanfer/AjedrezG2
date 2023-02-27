import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Class to represent the Bishop piece.
 * 
 * This class extends the ChessGamePiece class and implements the calculatePossibleMoves
 * method to return all the possible moves for a bishop on a chess board.
 */
public class Bishop extends ChessGamePiece {
    /**
     * Creates a new Bishop object.
     * 
     * @param board the board to create the bishop on
     * @param row row location of the Bishop
     * @param col col location of the Bishop
     * @param color either GamePiece.WHITE, BLACK, or UNASSIGNED
     */
    public Bishop(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
    }

    /**
     * Calculates the possible moves for this piece. These are ALL the possible moves,
     * including illegal (but at the same time valid) moves.
     * 
     * @param board the game board to calculate moves on
     * @return ArrayList<String> the moves
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
        ArrayList<String> northEastMoves = calculateNorthEastMoves(board, 8);
        ArrayList<String> northWestMoves = calculateNorthWestMoves(board, 8);
        ArrayList<String> southEastMoves = calculateSouthEastMoves(board, 8);
        ArrayList<String> southWestMoves = calculateSouthWestMoves(board, 8);
        ArrayList<String> allMoves = new ArrayList<String>();
        allMoves.addAll(northEastMoves);
        allMoves.addAll(northWestMoves);
        allMoves.addAll(southEastMoves);
        allMoves.addAll(southWestMoves);
        return allMoves;
    }

    /**
     * Creates an icon for this piece depending on the piece's color.
     * 
     * @return ImageIcon the ImageIcon representation of this piece.
     */
    @Override
    public ImageIcon createImageByPieceType() {
        return ImageIconFactory.createImageIcon(getColorOfPiece() == ChessGamePiece.WHITE ? "WhiteBishop.gif" : "BlackBishop.gif");
    }
}

/**
 * A factory class to create ImageIcons for chess pieces.
 */
class ImageIconFactory {
    /**
     * Creates an ImageIcon for the given file name.
     * 
     * @param fileName the name of the file to load
     * @return ImageIcon the ImageIcon for the given file name
     */
    public static ImageIcon createImageIcon(String fileName) {
        return new ImageIcon(Bishop.class.getResource("chessImages/" + fileName));
    }
}
