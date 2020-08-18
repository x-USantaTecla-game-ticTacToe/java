package usantatecla.utils;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleTest {

    @Mock
    private BufferedReader bufferedReader;

    @InjectMocks
    private Console console = new Console();

    @Test
    public void testGivenNewConsoleWhenReadLineCorrectStringThenIsCorrect() throws IOException {
        when(this.bufferedReader.readLine()).thenReturn("1");
        assertEquals("1", this.console.readString(""));
    }

    @Test
    public void testGivenNewConsoleWhenReadLineCorrectStringIntegerThenIsCorrect() throws IOException {
        when(this.bufferedReader.readLine()).thenReturn("1");
        assertEquals(1, this.console.readInt(""));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewConsoleWhenReadLineCorrectStringIntegerThenIsInCorrect() throws IOException {
        when(this.bufferedReader.readLine()).thenReturn("a");
        assertEquals(1, this.console.readInt(""));
    }

    @Test
    public void testGivenNewConsoleWhenReadLineCorrectStringCharThenIsCorrect() throws IOException {
        when(this.bufferedReader.readLine()).thenReturn("a");
        assertEquals('a', this.console.readChar(""));
    }

    @Test(expected = AssertionError.class)
    public void testGivenNewConsoleWhenReadLineCorrectStringCharThenIsInCorrect() throws IOException {
        when(this.bufferedReader.readLine()).thenReturn("a");
        assertEquals(1, this.console.readChar(""));
    }

} 