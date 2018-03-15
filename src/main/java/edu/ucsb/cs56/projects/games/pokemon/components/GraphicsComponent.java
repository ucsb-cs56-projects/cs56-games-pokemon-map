package main.java.edu.ucsb.cs56.projects.games.pokemon.components;

import main.java.edu.ucsb.cs56.projects.games.pokemon.graphics.Animation;
import main.java.edu.ucsb.cs56.projects.games.pokemon.graphics.Texture;

/**
 * A component to handle graphics of the entity
 *
 * @author Steven Fields
 * @author William Bennett
 */
public class GraphicsComponent extends Component {

    public Animation animation;

    /**
     * Constructs a graphics component from a static texture
     *
     * @param texture the Texture
     */
    public GraphicsComponent(Texture texture) {
        this.animation = new Animation(texture);
    }

    /**
     * Constructs a graphcis component from an Animation
     *
     * @param animation the Animation
     */
    public GraphicsComponent(Animation animation) {
        this.animation = animation;
    }

}
