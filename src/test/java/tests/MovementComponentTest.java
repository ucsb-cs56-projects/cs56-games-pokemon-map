package main.java.edu.ucsb.cs56.projects.games.pokemon.tests;

import org.junit.Assert;
import org.junit.Test;

import main.java.edu.ucsb.cs56.projects.games.pokemon.components.MovementComponent;
import main.java.edu.ucsb.cs56.projects.games.pokemon.components.MovementComponent.Direction;
import main.java.edu.ucsb.cs56.projects.games.pokemon.Vector2;

public class MovementComponentTest {

	@Test public void noArgConstructor() {
		Vector2 vec1 = new Vector2(9, 6);
		MovementComponent MC1 = new MovementComponent(vec1);
		Assert.assertTrue(MC1.velocity == vec1);
		Assert.assertTrue(MC1.getDirection() == Direction.None);
	}
}

