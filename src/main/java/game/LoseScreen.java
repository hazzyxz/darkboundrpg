package game;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class LoseScreen implements Screen {
    public void displayOutput(AsciiPanel terminal) {
        terminal.clear();
        AsciiArtDisplayer asciiDisplay = new AsciiArtDisplayer();

        asciiDisplay.displayAsciiArtFromFile(11,3,"/asciiArt/youDied.txt",AsciiPanel.brightRed,terminal);
        asciiDisplay.displayAsciiArtFromFile(13,30,"/asciiArt/rose.txt",AsciiPanel.brightBlack,terminal);

        terminal.writeCenter("-- press [Space] to return --", 22);

    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_SPACE ? new StartScreen() : this;
    }


}
