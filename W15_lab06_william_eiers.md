Lab06
=====
William Eiers
-------------
### Assessment:
The idea of this project is to emulate the pokemon-map from the original Pokemon yellow version
from the old GameBoy system. Overall, the authors did a good job in their attempt, but there
are many issues that need to be addressed, some major, others somewhat minor. The biggest
issue that I looked was that most of the code was hard coded; that is, there is not much room
for adding onto the project, without having to hard code every little detail. It would seem that
the authors didnt have a fully fleshed out outline of what they wanted to achieve when the project
was started, and thus a lot of the classes/files are quite wonky and somewhat difficult to
understand.  

One of my main concerns with this project is that there doesnt seem to be a real end goal in mind.
There are places in the code where there is room for multiple characters, multiple pokemon, added
maps, possibility of entering buildings, and maybe even room for fighting. Judging from what Ive
seen from the code, the project is trying to reach too far; that is, it is trying to be a full-
fledged game, when the original intention was much more restrictive (just emulate the mapping).

As it stands, there is a lot of work to be done on this project. How the work proceeds, however,
must be determined from what the intended goal of the project is. If the goal is to flesh out a
reenacting of the original game, complete with battles, storyline, dialogue, etc..., then the
project should be rebooted, with the new authors making a very clear outline of what they want
to do, how it should be done, and they should create the new infrastructure on how future authors
can proceed. If, however, the goal is to simply emulate the mapping/walking capabilities of the
pokemon games, and nothing else, then there are a few clear changes that should be made first:
 1. A clear outline of what capabilities the project will have at the end (how far to reach)
 2. Refactoring of the code (including GameLogic, and Character.java) accordingly, so that
    new characters and logic can be easily added, as well as correcting all indentation flaws
    (including the hard coding involved with collisions & pikachu)
 3. Easier implementation of adding new maps/texture. i.e., load a map and automatically recognize
    where any collisions occur, etc...

The issues part of the project involve some good ideas, although adding a talking ability to pikachu
or any others seem a bit far fetched at the moment. At least in any way aside from a wonky hard-coded
way.

Fixes/additions that I could accomplish in 2-3 hours would include:
 1. Running capabilities. Let professor oak run instead of walk (minor)
 2. Add the ability to walk inside of a building. (major implementation) 
    * My plan would be to simply create the infrastructure to do so, which would involve changing
      scenes, loading the inside map, etc...
 3. Add the infrastructure for dialogue, such that it will be easy to add new dialogue later in the
    project history (moderate implementation)
 4. Give professor oak a bike to ride around on (moderate implementation)
 5. Add some more graphical elements to the current map, extracting from the bitmap images. These will
    have no collision detection (minor).
