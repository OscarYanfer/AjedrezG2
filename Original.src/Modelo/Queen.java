import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Queen extends ChessGamePiece {
    /**
     * Constructor de la clase Queen
     * @param board el tablero de juego
     * @param row fila de la pieza
     * @param col columna de la pieza
     * @param color color de la pieza
     */
    public Queen(ChessGameBoard board, int row, int col, int color) {
        super(board, row, col, color);
    }

    /**
     * Método para calcular los movimientos posibles de la pieza Queen
     * @param board el tablero de juego
     * @return ArrayList<String> lista de movimientos posibles
     */
    @Override
    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
        ArrayList<String> allMoves = new ArrayList<>();
        int maxDistance = 8;
        allMoves.addAll(calculateNorthEastMoves(board, maxDistance));
        allMoves.addAll(calculateNorthWestMoves(board, maxDistance));
        allMoves.addAll(calculateSouthEastMoves(board, maxDistance));
        allMoves.addAll(calculateSouthWestMoves(board, maxDistance));
        allMoves.addAll(calculateNorthMoves(board, maxDistance));
        allMoves.addAll(calculateSouthMoves(board, maxDistance));
        allMoves.addAll(calculateWestMoves(board, maxDistance));
        allMoves.addAll(calculateEastMoves(board, maxDistance));
        return allMoves;
    }

    /**
     * Método para crear el icono de la pieza Queen
     * @return ImageIcon el icono de la pieza
     */
    @Override
    public ImageIcon createImageByPieceType() {
        return ChessPieceImageFactoryQueen.createQueenImage(getColorOfPiece());
    }
}