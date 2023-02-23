import javax.swing.ImageIcon;

public class BlackPieceImageFactory implements ChessPieceImageFactory {
    @Override
    public ImageIcon createImageIcon(int color) {
        return new ImageIcon(getClass().getResource("chessImages/BlackRook.gif"));
    }
}