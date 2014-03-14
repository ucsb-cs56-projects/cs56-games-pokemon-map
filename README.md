cs56-games-pokemon-map
======================

W14 Ready! (Brynn Kiefer)

The goal of the program is to create a 2D Rendering engine in the style of the Pokemon games for Gameboy Advance. The engine will render the exact tileset from the actual games.

The project allows the player to walk around a small town as Professor Oak. There is collision detection on everything that should have it. Pikachu will also follow Oak; you can walk through Pikachu. 

![](http://i.imgur.com/MaKaaHD.png)

## Keeping Track of Files

The source directory (src/edu/ucsb/cs56/S12/sbaldwin/pokemon/) has 12 different files, 11 of which are source files, and 1 of which is a directory. 

* images is the directory that holds the files for the bitmaps, i.e. the images that hold the models for all the buildings, trees, and characters.
* GameMain.java holds the main method of the program, and is where the program starts. It starts up the Renderer, GameLogic and MainWindow.
* MainWindow.java contains the JFrame of the program. The JFrame itself does not display the game, rather the GamePanel. The GamePanel is placed in the center region of the BorderLayout in MainWindow.
* GamePanel.java holds the JPanel that actually displays the game. GamePanel receives data from the renderer.
* GameLogic.java holds the methods for deciding how the game should progress. It updates the game when the character moves, and relays the changes to the renderer.
* Renderer.java holds the renderer for the program. The renderer is responsible for loading the buffer and choosing what to display to the GamePanel based on the information it receives from GameLogic.
* GameObject.java holds the class for GameObject. GameObject is the parent class for Character and Building, and basically represents any "object" (not in the programming sense) in the game.
* Building.java holds the class for Building. Building objects represent buildings and trees. 
* Character.java holds the class for Character. Character objects represent people or Pokemon in the game. Character is also the parent class of Player, which is the character you control specifically.
* Player.java holds the class for Player. The Player object is the one you control, which in this current version is Professor Oak.
* Texture.java holds the class for Texture. Texture objects are decorations in the game that don't cause collisions, like the grass on the floor, and the tall grass around the nice tree. Texture also has a method to force sprites harvested from the bitmap into a particular size.
* GameGrid.java holds the grid values for the program. At any given space in the game, there is an object value, a collision value, and a texture value. GameGrid allows you to get and set those values.

## How to Run
To start the game, use ant run. It will compile automatically for you.