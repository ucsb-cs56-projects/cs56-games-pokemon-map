package edu.ucsb.cs56.S12.sbaldwin.pokemon.IO;

/**
 * Created by William Bennett on 7/15/2016.
 */
public class IOHelper {
    private String stream;
    private int position;

    /**
     * Creates a IOHelper with a string
     *
     * @param inputString the String
     */
    public IOHelper(String inputString) {
        stream = inputString;
    }

    /**
     * Gets the position of the next char c in the stream
     *
     * @parma c the char
     * @return the next position of c
     */
    public int seekNext(char c) {
        while (peekChar() != c) {
            getChar();
        }
        return position;
    }

    /**
     * Gets the current char in the string
     *
     * @return the current char in the string
     */
    private char peekChar() {
        return stream.charAt(position);
    }

    /**
     * Gets the char at the position and iterates the position
     *
     * @return the current char
     */
    private char getChar() {
        return stream.charAt(position++);
    }
}
