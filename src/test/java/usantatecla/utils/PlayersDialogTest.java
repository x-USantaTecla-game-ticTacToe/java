package usantatecla.utils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PlayersDialogTest {

    @Mock
    private Console console;

    @InjectMocks
    private PlayersDialog playersDialog = new PlayersDialog();

    @Test
    public void testGivenNewPlayersDialogWhenNumberOfPlayersAreZeroThenIsCorrect() {
        when(this.console.readInt("Number of users [0-" + 2 + "] ")).thenReturn(0);
        assertEquals(0, this.playersDialog.read(2));
        verify(this.console).readInt("Number of users [0-" + 2 + "] ");
    }

    @Test
    public void testGivenNewPlayersDialogWhenNumberOfPlayersAreTwoThenIsCorrect() {
        when(this.console.readInt("Number of users [0-" + 2 + "] ")).thenReturn(2);
        assertEquals(2, this.playersDialog.read(2));
        verify(this.console).readInt("Number of users [0-" + 2 + "] ");
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayersDialogWhenNumberOfPlayersAreNegativeThenIsIncorrect() {
        when(this.console.readInt("Number of users [0-" + 2 + "] ")).thenReturn(-1);
        assertEquals(-1, this.playersDialog.read(2));
        verify(this.console).readInt("Number of users [0-" + 2 + "] ");
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewPlayersDialogWhenNumberOfPlayersAreThreeThenIsIncorrect() {
        when(this.console.readInt("Number of users [0-" + 2 + "] ")).thenReturn(3);
        assertEquals(3, this.playersDialog.read(2));
        verify(this.console).readInt("Number of users [0-" + 2 + "] ");
    }
    
}