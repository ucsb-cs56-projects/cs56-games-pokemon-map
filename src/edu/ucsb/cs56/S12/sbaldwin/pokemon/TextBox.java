package edu.ucsb.cs56.S12.sbaldwin.pokemon;


import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.Texture;

public class TextBox {

    Texture t;
    String totalText;
    private int startPos;
    private int endPos;
    private int totalCharsInBox = 25;

    public TextBox(String totalText) {
        this.totalText = totalText;
        startPos = 0;
        endPos = totalCharsInBox; //arbitrary
        t = Assets.textBox;
    }

    public void advanceText() {
        startPos += totalCharsInBox;
        endPos += totalCharsInBox;
        if (endPos >= totalText.length()) {
            endPos = totalText.length() - 1;
        }
    }

    public String getCurrentText() {
        if (isDone()) {
            return "";
        }

        return totalText.substring(startPos, endPos);
    }

    public boolean isDone() {
        return startPos >= totalText.length();
    }

}
