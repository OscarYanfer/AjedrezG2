import javax.swing.ImageIcon;

public class ChessPieceImageFactoryQueen {

    private ChessPieceImageFactoryQueen(){
        //Constructor vacío.
    }

    private static final String IMAGE_PATH = "chessImages/";
    private static final String WHITE_QUEEN_IMAGE_NAME = "WhiteQueen.gif";
    private static final String BLACK_QUEEN_IMAGE_NAME = "BlackQueen.gif";
    private static final String DEFAULT_IMAGE_NAME = "default-Unassigned.gif";

    /**
     * Método para crear el icono de la pieza Queen
     * @param color el color de la pieza
     * @return ImageIcon el icono de la pieza
     */
    public static ImageIcon createQueenImage(int color) {
        String imageName;
        if (color == ChessGamePiece.WHITE) {
            imageName = WHITE_QUEEN_IMAGE_NAME;
        } else if (color == ChessGamePiece.BLACK) {
            imageName = BLACK_QUEEN_IMAGE_NAME;
        } else {
            imageName = DEFAULT_IMAGE_NAME;
        }
        return new ImageIcon(ChessPieceImageFactoryQueen.class.getResource(IMAGE_PATH + imageName));
    }
}