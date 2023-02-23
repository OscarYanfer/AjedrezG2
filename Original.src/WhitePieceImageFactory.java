import javax.swing.ImageIcon;

public class WhitePieceImageFactory implements ChessPieceImageFactory {
    @Override
    public ImageIcon createImageIcon(int color) {
        return new ImageIcon(getClass().getResource("chessImages/WhiteRook.gif"));
    }
}
