package edu.ucsb.cs56.S12.sbaldwin.pokemon.systems;

/**
 * Created by William Bennett on 7/21/2016.
 */
public abstract class SystemBase {
    protected SystemMessenger messenger;

    public void registerMessenger(SystemMessenger messenger) {
        this.messenger = messenger;
    }

    protected abstract void handleMessages();
}
