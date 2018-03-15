package main.java.edu.ucsb.cs56.projects.games.pokemon.tests;

import org.junit.Assert;
import org.junit.Test;

import main.java.edu.ucsb.cs56.projects.games.pokemon.components.CollisionComponent;


public class CollisionComponentTest {

	@Test public void noArgConstructor() {
		CollisionComponent C1 = new CollisionComponent();
		Assert.assertTrue(C1.hasCollision == false);
		Assert.assertTrue(C1.height == 0);
		Assert.assertTrue(C1.width == 0);
	}
	
	@Test public void constructorWithCollisionandIntArgs() {
		CollisionComponent C2 = new CollisionComponent(true, 64, 32);
		Assert.assertTrue(C2.hasCollision == true);
		Assert.assertTrue(C2.height == 2);
		Assert.assertTrue(C2.width == 4);
	}

	@Test public void constructorWithCollisionandRectangleArg() {
		java.awt.Rectangle R1 = new java.awt.Rectangle(64, 64);
		CollisionComponent C3 = new CollisionComponent(false, R1);
		Assert.assertTrue(C3.hasCollision == false);
		Assert.assertTrue(C3.height == 3);
		Assert.assertTrue(C3.width == 3);	
	}
}

