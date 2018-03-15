package edu.ucsb.cs56.projects.games.pokemon.IO;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by John Bowman on 11/8/2016.
 */
public class ReadFile {

    public static String readFile(String path, Charset encoding) throws IOException {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            return new String(encoded, encoding);
        } catch(IOException e) {
            return null;
        }

    }


}
