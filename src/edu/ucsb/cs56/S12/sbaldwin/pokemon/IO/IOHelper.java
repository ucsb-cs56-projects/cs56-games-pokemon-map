package edu.ucsb.cs56.S12.sbaldwin.pokemon.IO;

/**
 * Created by William Bennett on 7/15/2016.
 */
public class IOHelper {
    private String stream;
    private int position;

    public IOHelper(String inputString) {
        stream = inputString;
    }

    public int seekNext(char c) {
        while (peekChar() != c) {
            getChar();
        }
        return position;
    }

    private char peekChar() {
        return stream.charAt(position);
    }

    private char getChar() {
        return stream.charAt(position++);
    }
}
