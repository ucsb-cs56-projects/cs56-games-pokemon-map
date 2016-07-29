cs56-games-pokemon-map
======================

The goal of the program is to create a 2D Rendering engine in the style of the Pokemon games for Gameboy Advance. The engine will render the exact tileset from the actual games.

Currently, after a massive architectural rewrite, the player can control Professor Oak walking around on a map. It should be relatively easy to add new features in a non-coupling way.

###Features missing due to the rewrite:
1. A full map. There exists infrastructure to load maps from a file, however
2. Pikachu following the player
3. "Events", where the map changes because of player actions


![](http://i.imgur.com/MaKaaHD.png)

project history
===============
```
 W14 | bkiefer13 5pm | mliou, alecharrell |  Pokemon Map Renderer
```

## Project Structure
The source directory has 7 packages (commands, components, framework, graphics, IO, systems, and tests), along with 7 Java files in the main package (edu.ucsb.cs56.S12.sbaldwin.pokemon). The code is organized with the Entity-Component-System design pattern (see http://gameprogrammingpatterns.com/component.html for an overview), where discrete objects in the game world are represented by an Entity, each of which owns a number of Components. Entities and Components have *no* behavior; entities merely own components, and components are bags of data (state). All game behavior goes into Systems, each of which is run once per update. Systems only use and modify components directly related to their domain. For example, the RenderSystem iterates through all entities once per frame, and for each entity that has both a GraphicsComponent and a PositionComponent, draws it to the screen. 



## How to Extract from Bitmaps
In order to get the tileset from the actual games, you need to get the images of the sprites you want. These images must be bmp files; any png file can be converted into bmp files via an online converter. Put the image in the images file, and simply read that image in Renderer.java. When the images are read in, the first two coordinates are the x and y coordinates of the top left corner of the image, and the last two coordinates are the bottom right x and y coordinates of the image(respectively). Harvest textures in Renderer.java, buildings in Building.java and characters in Character.java.

## How to Run
To start the game, use ant run. It will compile automatically for you.

## How to Play
To move, use the WASD keys. To interact with objects, press the H key (currently does nothing).

