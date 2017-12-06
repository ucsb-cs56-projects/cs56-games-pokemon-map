cs56-games-pokemon-map
======================

Website:
* <https://brandontran24.github.io/Pokemon-Project/>
* <https://ucsb-cs56-projects.github.io/cs56-games-pokemon-map/>

Javadoc: 
* <https://brandontran24.github.io/Pokemon-Project/docs>
* <https://ucsb-cs56-projects.github.io/cs56-games-pokemon-map/docs>


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

## F17 Final Remarks

Tell them exactly what you think would be helpful for them to know as they start the project: what the code does, what features could be added, what bugs exist, what opportunities for refactoring you see. Also add any advice you have on working with the code you have left them, for with legacy code in general.

How the code currently constructs a map:
The code first builds a map of tiles from a loaded text file. Each tile is an individual entity, made up of various components. These tiles are stored in an array of tile arrays in World.java. Next, the world builds up interactable entities--the player, and obstacles such as buildings and trees--which are stored in an arrayList of entities. In the code's current form, these entities must be hard-coded, rather than be loaded from files.   

Possible new features:
Pokemon following the player-character could be re-implemented. Loading new maps upon reaching the edge of the current map could also be added or loading a new map when the player "enters" a building. Could also implement a map editor which is currently at 500 points in issues. I would reccommend doing this for the second half of the project or pushing for this being more points as it would probably require a complete refactoring of code and how the game is built up in World.java. You could also implement a movable camera. You might want to look in the game Alva (in CS56 projects category) and see how that game implements it. 

Current Bugs:
No major bugs. Player is able to move around the map at one tilemove per key stroke. Collision doesn't have any issues.

Refactoring Opportunities:
Map tile parser can be refactored to allow for simpler, easier-to-write map files that can also load buildings/other entities. This also goes with possibly creating a map editor in the game. Definitely a lot of points here.
SystemMessenger could be refactored to allow the code to work better, solve the source of memory leaks. (Unsure if memory leaks are still an issue as of F17.)

Our Advice:
This project is built from a lot of different packages that all work together to allow the game to function. To tackle the code, and get a decent understanding of it, I would start by looking at the entity/component classes. Once you understand the entities, understanding how the world loads becomes easier. After that, figuring out how the rendering and movement systems function becomes possible. Work outwards from there, until you have a good understanding of the whole picture, including how systemMessenger, animation, and I/O works. The main files in this game are World.java and Game.java. This is where everything comes together. This project has a lot to it so definitely familiarize yourself with the code early on. A good place to start might be with adding Pikachu back in. The first thing you implement will probably take the longest as this project has quite a bit of confusing code. Another great place to start would be reorganizing the map and making it "pretty". Pretty easy points but takes a bit of time to change values in Pond_map.txt. 


