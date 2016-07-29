package edu.ucsb.cs56.S12.sbaldwin.pokemon.framework;

/**
 * A data structure for a reference
 *
 * @author William Bennett
 */
public class Ref<T> {
    public T reference;

    public Ref() {
        this.reference = null;
    }

    public Ref(T object) {
        this.reference = object;
    }
}
