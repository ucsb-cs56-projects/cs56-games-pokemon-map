package edu.ucsb.cs56.S12.sbaldwin.pokemon;


import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.Texture;

/**
 * This class doesn't do anything yet and is a basic stub for later addition for text boxes
 *
 * @author Steven Fields
 */
public class TextBox {

    Texture t;
    String totalText;
    private int startPos;
    private int endPos;
    private int totalCharsInBox = 25;

    /**
     * Creates a basic text box, doesn't do anything yet
     *
     * @param totalText the text to be displayed
     */
    public TextBox(String totalText) {
        this.totalText = totalText;
        startPos = 0;
        endPos = totalCharsInBox; //arbitrary
        t = Assets.textBox;
    }

    /**
     * Advances the text
     */
    public void advanceText() {
        startPos += totalCharsInBox;
        endPos += totalCharsInBox;
        if (endPos >= totalText.length()) {
            endPos = totalText.length() - 1;
        }
    }

    /**
     * Returns the current text
     *
     * @return the current text
     */
    public String getCurrentText() {
        if (isDone()) {
            return "";
        }

        return totalText.substring(startPos, endPos);
    }

    /**
     * Returns if the text box is done displaying text
     *
     * @return if the text is over
     */
    public boolean isDone() {
        return startPos >= totalText.length();
    }

}
