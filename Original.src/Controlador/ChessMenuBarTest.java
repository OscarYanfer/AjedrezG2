import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;

import org.junit.Before;
import org.junit.Test;

public class ChessMenuBarTest {

    private ChessMenuBar menuBar;
    private ChessPanel chessPanel;

    @Before
    public void setUp() {
        chessPanel = mock(ChessPanel.class);
        menuBar = new ChessMenuBar();
        menuBar.setParent(chessPanel);
    }

    @Test
    public void testNewGameRestartHandler() {
        JMenuItem newGameRestartItem = menuBar.getMenu(0).getItem(0);
        ActionEvent event = new ActionEvent(newGameRestartItem, 0, "");
        menuBar.actionPerformed(event);
        verify(chessPanel.getGameEngine()).reset();
    }

    @Test
    public void testAboutHandler() {
        JMenuItem aboutItem = menuBar.getMenu(2).getItem(0);
        ActionEvent event = new ActionEvent(aboutItem, 0, "");
        menuBar.actionPerformed(event);
        assertEquals("Dialog message is incorrect", "YetAnotherChessGame v1.0 by:\nBen Katz\nMyles David\n"
                + "Danielle Bushrow\n\nFinal Project for CS2114 @ VT", mock(JOptionPane.class).getMessage());
    }

    @Test
    public void testToggleGraveyardHandler() {
        JMenuItem toggleGraveyardItem = menuBar.getMenu(1).getItem(0);
        ActionEvent event = new ActionEvent(toggleGraveyardItem, 0, "");
        menuBar.actionPerformed(event);
        verify(chessPanel.getGraveyard(1)).setVisible(true);
        verify(chessPanel.getGraveyard(2)).setVisible(true);
        menuBar.actionPerformed(event);
        verify(chessPanel.getGraveyard(1)).setVisible(false);
        verify(chessPanel.getGraveyard(2)).setVisible(false);
    }

    @Test
    public void testToggleGameLogHandler() {
        JMenuItem toggleGameLogItem = menuBar.getMenu(1).getItem(1);
        ActionEvent event = new ActionEvent(toggleGameLogItem, 0, "");
        menuBar.actionPerformed(event);
        verify(chessPanel.getGameLog()).setVisible(true);
        menuBar.actionPerformed(event);
        verify(chessPanel.getGameLog()).setVisible(false);
    }
}
