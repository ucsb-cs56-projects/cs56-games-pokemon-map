package main.java.edu.ucsb.cs56.projects.games.pokemon.systems;

import main.java.edu.ucsb.cs56.projects.games.pokemon.components.Entity;
import main.java.edu.ucsb.cs56.projects.games.pokemon.framework.Pair;
import main.java.edu.ucsb.cs56.projects.games.pokemon.framework.Ref;

import java.lang.ref.Reference;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Stores data on a subject and a message to be applied to the subject
 *
 * @author William Bennett
 */
public class SystemMessage {
    Pair<String, Object> message;
    public Entity subject;

    /**
     * Creates a system message with a subject (Entity) and a message (Pair)
     *
     * @param subject the subject
     * @param message the message
     */
    public SystemMessage(Entity subject, Pair<String, Object> message) {
        this.message = message;
        this.subject = subject;
    }

    public boolean getMessage(String message, Ref<Object> reference) {
        if (message.equals(this.message.first)) {
            reference.reference = this.message.second;
            return true;
        }
        else {
            reference.reference = null;
            return false;
        }
    }
}
