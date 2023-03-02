import org.junit.Test;
import static org.junit.Assert.*;

public class ChessPanelTest {

    @Test
    public void testGetInstance() {
        ChessPanel instance1 = ChessPanel.getInstance();
        ChessPanel instance2 = ChessPanel.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    public void testComponentLayout() {
        ChessPanel panel = ChessPanel.getInstance();
        assertNotNull(panel.getGameLog());
        assertNotNull(panel.getGameBoard());
        assertNotNull(panel.getGameEngine());
        assertNotNull(panel.getGraveyard(1));
        assertNotNull(panel.getGraveyard(2));
        //assertEquals(panel.getComponent(0), panel.getMenuBar());
        assertEquals(panel.getComponent(1), panel.getGameBoard());
        assertEquals(panel.getComponent(2), panel.getGameLog());
        assertEquals(panel.getComponent(3), panel.getGraveyard(1));
        assertEquals(panel.getComponent(4), panel.getGraveyard(2));
    }

}