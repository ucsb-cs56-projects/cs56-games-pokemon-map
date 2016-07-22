package edu.ucsb.cs56.S12.sbaldwin.pokemon.framework;

/**
 * Created by William Bennett on 7/22/2016.
 */
public class Ref<T> {
    public T reference;
    public Ref(T object) {
        this.reference = object;
    }
}
