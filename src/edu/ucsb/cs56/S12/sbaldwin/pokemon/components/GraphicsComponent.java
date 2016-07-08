package edu.ucsb.cs56.S12.sbaldwin.pokemon.components;


public class GraphicsComponent extends Component {

    private Texture t;

    public GraphicsComponent(Texture t) {
	this.t = t;
    }

    public void getTexture() {
	return t;
    }
    
}
