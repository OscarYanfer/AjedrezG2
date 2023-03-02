import org.junit.Test;
import static org.junit.Assert.*;

public class ChessGameLogTest {
    @Test
    public void testClearLog() {
        ChessGameLog log = ChessGameLog.create();
        log.addToLog("Test log entry");
        log.clearLog();
        String lastLog = log.getLastLog();
        assertEquals("", lastLog);
    }
}