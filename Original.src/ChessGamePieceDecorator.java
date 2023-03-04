import java.util.ArrayList;

public class ChessGamePieceDecorator {
	 private ChessGamePiece decoratedPiece;

	    public ChessGamePieceDecorator(ChessGamePiece decoratedPiece) {
	        this.decoratedPiece = decoratedPiece;
	    }

	    @Override
	    protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
	        return decoratedPiece.calculatePossibleMoves(board);
	    }

	    @Override
	    public ImageIcon createImageByPieceType() {
	        return decoratedPiece.createImageByPieceType();
	    }

	    // delegate to decoratedPiece for other methods as well
	}

	public class ColoredChessGamePieceDecorator extends ChessGamePieceDecorator {
	    private Color color;

	    public ColoredChessGamePieceDecorator(ChessGamePiece decoratedPiece, Color color) {
	        super(decoratedPiece);
	        this.color = color;
	    }

	    @Override
	    public ImageIcon createImageByPieceType() {
	        // create a new image with the desired color
	        // using the superclass method to get the original image
	        ImageIcon originalImage = super.createImageByPieceType();
	        BufferedImage tinted = new BufferedImage(
	            originalImage.getIconWidth(),
	            originalImage.getIconHeight(),
	            BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g = tinted.createGraphics();
	        g.drawImage(originalImage.getImage(), 0, 0, null);
	        g.dispose();
	        for (int i = 0; i < tinted.getWidth(); i++) {
	            for (int j = 0; j < tinted.getHeight(); j++) {
	                Color c = new Color(tinted.getRGB(i, j), true);
	                int r = (int) (c.getRed() * color.getRed() / 255.0);
	                int g = (int) (c.getGreen() * color.getGreen() / 255.0);
	                int b = (int) (c.getBlue() * color.getBlue() / 255.0);
	                int a = c.getAlpha();
	                tinted.setRGB(i, j, new Color(r, g, b, a).getRGB());
	            }
	        }
	        return new ImageIcon(tinted);
	    }
}
