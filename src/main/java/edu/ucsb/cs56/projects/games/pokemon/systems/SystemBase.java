package main.java.edu.ucsb.cs56.projects.games.pokemon.systems;

/**
 * Abstract class for all classes that use System messages
 *
 * @author William Bennett
 */
public abstract class SystemBase {
    protected SystemMessenger messenger;

    /**
     * Registers a messenger
     *
     * @param messenger the messenger
     */
    public void registerMessenger(SystemMessenger messenger) {
        this.messenger = messenger;
    }

    protected abstract void handleMessages();
}
