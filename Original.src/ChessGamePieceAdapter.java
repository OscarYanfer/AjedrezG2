
public class ChessGamePieceAdapter implements GraveyardPiece {
    private ChessGamePiece piece;

    public ChessGamePieceAdapter(ChessGamePiece piece) {
        this.piece = piece;
    }

    @Override
    public void addPieceToGraveyard(ChessGraveyard graveyard) {
        graveyard.addPiece(piece);
    }
}
