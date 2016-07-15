package edu.ucsb.cs56.S12.sbaldwin.pokemon.components;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.Animation;
import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.Texture;

public class GraphicsComponent extends Component {

    public Animation animation;

    public GraphicsComponent(Texture texture) {
        this.animation = new Animation(texture);
    }

    public GraphicsComponent(Animation animation) {
        this.animation = animation;
    }
    
}
