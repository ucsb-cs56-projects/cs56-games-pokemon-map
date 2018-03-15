package edu.ucsb.cs56.projects.games.pokemon.tests;

import org.junit.Assert;
import org.junit.Test;

import edu.ucsb.cs56.projects.games.pokemon.components.CollisionComponent;
import edu.ucsb.cs56.projects.games.pokemon.components.TileComponent;

public class TileComponentTest {

	@Test public void constructor() {
		int ID = 876;
		TileComponent T1 = new TileComponent(ID);
		Assert.assertTrue(T1.ID == ID);
	}
	
}

