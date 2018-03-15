package main.java.edu.ucsb.cs56.projects.games.pokemon.tests;

import main.java.edu.ucsb.cs56.projects.games.pokemon.components.PositionComponent;
import main.java.edu.ucsb.cs56.projects.games.pokemon.Vector2;

import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;


public class PositionComponentTest{
	
	@Test public void testConstructorwithPoint() {
		java.awt.Point P1 = new java.awt.Point(0, 0);
		PositionComponent PC1 = new PositionComponent(P1);
		Assert.assertTrue(PC1.position == P1);
	}

	@Test public void testConstructorwithIntsandVector() {
		Vector2 vec1 = new Vector2(0, 0);
		java.awt.Point P1 = new java.awt.Point(0, 0);
		PositionComponent PC2 = new PositionComponent(0, 0, vec1);
		Assert.assertTrue(PC2.offset == vec1);
	}
	
	@Test public void testConstructorwithPointandVector() {
		Vector2 vec2 = new Vector2(2, 3);
		java.awt.Point P1 = new java.awt.Point(5, 1);
		PositionComponent PC3 = new PositionComponent(P1, vec2);
		Assert.assertTrue(PC3.position == P1);
		Assert.assertTrue(PC3.offset == vec2);
	}
}
