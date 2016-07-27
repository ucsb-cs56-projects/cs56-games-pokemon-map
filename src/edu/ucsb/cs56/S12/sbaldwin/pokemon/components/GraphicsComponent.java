package edu.ucsb.cs56.S12.sbaldwin.pokemon.components;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.Animation;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.Texture;

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
