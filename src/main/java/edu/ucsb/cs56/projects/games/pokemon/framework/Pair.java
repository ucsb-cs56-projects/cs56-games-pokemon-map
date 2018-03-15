package main.java.edu.ucsb.cs56.projects.games.pokemon.framework;

/**
 * A data structure for a pair
 *
 * @author William Bennett
 */
public class Pair<T, U> {
    public T first;
    public U second;

    /**
     * Takes two references and stores them as pairs
     *
     * @param first the first object
     * @param second the second object
     */
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Checks if the two pairs are equal by seeing if the corresponding first and second pairs are the same
     *
     * @param o the second pair
     * @return if they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (first != null ? !first.equals(pair.first) : pair.first != null)
            return false;
        return !(second != null ? !second.equals(pair.second) : pair.second != null);

    }

    /**
     * Gives a unique hash code
     *
     * @return a hash code
     */
    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}
