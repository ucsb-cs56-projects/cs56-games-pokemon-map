package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import java.awt.*;
import java.awt.image.BufferedImage;

class Texture
{
	private String name;
	private String tileset;
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	
	private BufferedImage image;
	
	public Texture(String name, String tileset, int x1, int y1, int x2, int y2)
	{
		this.name = name;
		this.tileset = tileset;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		
		image = GameMain.renderer.getTile(tileset, x1, y1, x2, y2);
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getTileSet()
	{
		return tileset;
	}
	
	public BufferedImage getImage()
	{
		return image;
	}
	
	public void forceSize(int width, int height)
	{
		// Record original Width and Height (no negatives)
		int w = Math.abs(x2 - x1);
		int h = Math.abs(y2 - y1);
		
		// Create new Image
		BufferedImage tmp = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics g = tmp.getGraphics();
		
		// Set Background to transparent
		g.setColor(new Color(0, 0, 0, 0));
		g.fillRect(0, 0, width, height);
		
		// Draw original image to the bottom left corner of new image
		g.drawImage(image, 0, (height - h), w, h, null);
		
		// Set the new image
		image = tmp;
		
		return;
	}
	
	public int getX1()
	{
		return x1;
	}
	
	public int getX2()
	{
		return x2;
	}
	
	public int getY1()
	{
		return y1;
	}
	
	public int getY2()
	{
		return y2;
	}
}
