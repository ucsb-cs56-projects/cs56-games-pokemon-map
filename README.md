cs56-games-pokemon-map
======================

The goal of the program is to create a 2D Rendering engine in the style of the Pokemon games for Gameboy Advance. The engine will render the exact tileset from the actual games.

The project allows the player to walk around a small town as Professor Oak. There is collision detection on everything that should have it. Pikachu will also follow Oak. We specifically implemented it so that Professor Oak will walk through Pikachu, as this is how it is implemented in Yellow Version in the Pokemon series.  Pikachu behaves exactly as he does in that game with regard to following the player. 

![](http://i.imgur.com/MaKaaHD.png)

project history
===============
```
 W14 | bkiefer13 5pm | mliou, alecharrell |  Pokemon Map Renderer
```

## Keeping Track of Files

The source directory (src/edu/ucsb/cs56/S12/sbaldwin/pokemon/) has 12 different files, 11 of which are source files, and 1 of which is a directory. 

* images is the directory that holds the files for the bitmaps, i.e. the images that hold the models for all the buildings, trees, and characters.
* GameMain.java holds the main method of the program, and is where the program starts. It starts up the Renderer, GameLogic and MainWindow.
* MainWindow.java contains the JFrame of the program. The JFrame itself does not display the game, rather the GamePanel. The GamePanel is placed in the center region of the BorderLayout in MainWindow.
* GamePanel.java holds the JPanel that actually displays the game. GamePanel receives data from the renderer.
* GameLogic.java holds the methods for deciding how the game should progress. It updates the game when the character moves, and relays the changes to the renderer.
* Renderer.java holds the renderer for the program. The renderer is responsible for loading the buffer and choosing what to display to the GamePanel based on the information it receives from GameLogic.
* GameObject.java holds the class for GameObject. GameObject is the parent class for Character and Building, and basically represents any "object" (not in the programming sense) in the game. Further, Player extends Character, which means Player also IS-A GameObject
* Building.java holds the class for Building. Building objects represent buildings and trees. 
* Character.java holds the class for Character. Character objects represent people or Pokemon in the game. Character is also the parent class of Player, which is the character you control specifically.
* Player.java holds the class for Player. The Player object is the one you control, which in this current version is Professor Oak. However Pikachu is also a Player, but his motion is dictated by the movement of Professor Oak
* Texture.java holds the class for Texture. Texture objects are decorations in the game that don't cause collisions, like the grass on the floor, and the tall grass around the nice tree. Texture also has a method to force sprites harvested from the bitmap into a particular size.
* GameGrid.java holds the grid values for the program. At any given space in the game, there is an object value, a collision value, and a texture value. GameGrid allows you to get and set those values.

## How to Extract from Bitmaps
In order to get the tileset from the actual games, you need to get the images of the sprites you want. These images must be bmp files; any png file can be converted into bmp files via an online converter. Put the image in the images file, and simply read that image in Renderer.java. When the images are read in, the first two coordinates are the x and y coordinates of the top left corner of the image, and the last two coordinates are the bottom right x and y coordinates of the image(respectively). Harvest textures in Renderer.java, buildings in Building.java and characters in Character.java.

## How to Run
To start the game, use ant run. It will compile automatically for you.

~~~ W16 final remarks ~~~

## How to Play
--to interact with something, press "h"
There are six events in total in the game. The final event is to talk to the big robot in the forest.
1, after we walked in the flowers for some steps (around 20) then go to the grid behind the blue house, there will open a secret path through which we can go through the forest to a new map.
2, if we go into the big fish's mouth, the fish will create some lakes around the map, and there will be another secret path open (in the first map)
3, we need to go through the forest again and will find a secret path opened in the left down corner, we can go inside and when we reach the Pokemon ball, press "h" to interact.
4, then we will find many flowers were created, and another big Pokemon appeared in the town. We need to go around the map, reach that Pokemon, and interact with it, we will see it disappeared and left some red flowers.
5, go to the desert, where there were originally a big door and many big rocks, we will find the big Pokemon has came here. Interact with it, there will be another secret path opened, right beside us.
6, go with a secret path, through the lake and forest, we can finally interact with the big robot in the forest! after we interact with it, the map will become very beautiful, and that is the last event.

## bugs and flaws
1, when walk at the bottom edge of the lake, the lake edge will disappear.
2, there are some misspellings in the code for some function names. For example, misspell "create" as "creat"

