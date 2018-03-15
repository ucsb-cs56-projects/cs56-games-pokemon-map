package main.java.edu.ucsb.cs56.projects.games.pokemon;

import main.java.edu.ucsb.cs56.projects.games.pokemon.graphics.Animation;
import main.java.edu.ucsb.cs56.projects.games.pokemon.graphics.AnimationFrame;
import main.java.edu.ucsb.cs56.projects.games.pokemon.graphics.Texture;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

/**
 * Contains all Assets and initializes them
 *
 * @author Steven Fields
 */
public class Assets {
    public static Texture
	    workingTree,
	    workingTree2,
	    workingTree3,
            grass_Default,
            grass_Wild,
            flower,
            flower2,
            flower3,
            snow,
            bigPokemon,
            pokeball,
            pokecenter,
            pokemart,
            smallHouse,
            tree,
            mediumHouse,
            largeHouse,
            bigFish,
            door,
            bigBuildingLeft,
            bigBuildingRight,
            bigBuilding2Left,
            bigBuilding2Right,
            bigRock,
            water1,
            water2,
            water3,
            water4,
            water5,
            water6,
            water7,
            water8,
            water9,
            rock,
            niceTree,
            god,
	    textBox;
	   

    public static Texture [] players  = new Texture [12];
    public static Texture [] pikachus  = new Texture [12];
    

   
           
    public static AnimationFrame[] playerAnimation;
    public static AnimationFrame[] pikachuAnimation;



    /**
     * Initializes the assets
     */
    public static void initAssets() {
        BufferedImage TileSet_Main = addImage("images/TilesetMain.bmp");
        BufferedImage TileSet_Characters = addImage("images/NPC_frlg.bmp");
        BufferedImage TileSet_Pkmn = addImage("images/pkmn.bmp");
        BufferedImage TileSet_Characters_Flipped = addImage("images/NPC_frlg.bmp");
        TileSet_Main = imageToBufferedImage(makeColorTransparent(TileSet_Main, Color.black));
        TileSet_Characters = imageToBufferedImage(makeColorTransparent(TileSet_Characters, new Color(255, 0, 255)));
        TileSet_Characters_Flipped = imageToBufferedImage(makeColorTransparent(TileSet_Characters_Flipped,
                                                                                new Color(255, 0, 255)));
        TileSet_Pkmn = imageToBufferedImage(makeColorTransparent(TileSet_Pkmn, Color.white));

        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-TileSet_Characters_Flipped.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx,
                AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        TileSet_Characters_Flipped = op.filter(TileSet_Characters_Flipped, null);

        grass_Default = new Texture(TileSet_Main, 16, 0, 16, 16);
        grass_Wild = new Texture(TileSet_Main, 0, 16, 16, 16);
        flower = new Texture(TileSet_Main, 16 * 0, 16 * 36, 16, 16);
        flower2 = new Texture(TileSet_Main, 16 * 13, 16 * 39, 16, 16);
        flower3 = new Texture(TileSet_Main, 16 * 14, 16 * 189, 16, 16);
        snow = new Texture(TileSet_Main, 16 * 1, 16 * 351, 16, 16);
        
        //tree borders
        workingTree = new Texture(TileSet_Main, 64, 0, 32, 32);
        workingTree2 = new Texture(TileSet_Main, 64, 32, 32, 16);
        workingTree3 = new Texture(TileSet_Main, 96, 0, 32, 48);





	// //try to add pikachu
	pikachus[0] = new Texture(TileSet_Pkmn, 151, 153, 17, 20);
	pikachus[1] = new Texture(TileSet_Pkmn, 130, 153, 17, 20);
	pikachus[2] = new Texture(TileSet_Pkmn, 174, 153, 17, 20);
	pikachus[3] = new Texture(TileSet_Pkmn, 151, 178, 17, 20);
	pikachus[4] = new Texture(TileSet_Pkmn, 172, 178, 17, 20);
	pikachus[5] = new Texture(TileSet_Pkmn, 130, 178, 17, 20);
	pikachus[6] = new Texture(TileSet_Pkmn, 149, 200, 18, 20);
	pikachus[7] = new Texture(TileSet_Pkmn, 171, 200, 19, 20);
	pikachus[8] = new Texture(TileSet_Pkmn, 126, 200, 19, 20);
	pikachus[9] = new Texture(TileSet_Pkmn, 150, 221, 19, 20);
	pikachus[10] = new Texture(TileSet_Pkmn, 173, 222, 19, 20);
	pikachus[11] = new Texture(TileSet_Pkmn, 128, 223, 19, 20);


	pikachuAnimation = new AnimationFrame[12];

	for (int i = 0; i < pikachuAnimation.length; i++ ) {
	    pikachuAnimation[i] = new AnimationFrame(pikachus[i]);
	}







	
	//refered graphic/texture.java
	//init: 4 entries- x,y,width,heigth
        bigPokemon = new Texture(TileSet_Pkmn, 16 * 31, 16 * 17, 16*4, 16 * 4);
        pokeball = new Texture(TileSet_Main, 16 * 5, 16 * 3, 16, 16);
        pokecenter = new Texture(TileSet_Main, new Rectangle(0, 720, 80, 80));
        pokemart = new Texture(TileSet_Main, new Rectangle(0, 656, 64, 64));
        smallHouse = new Texture(TileSet_Main, 0, 1840, 80, 48);
        tree = new Texture(TileSet_Main, 240, 3632, 16, 32);
        mediumHouse = new Texture(TileSet_Main, 0, 1888, 80, 80);
        largeHouse = new Texture(TileSet_Main, 16, 1968, 112, 80);
        bigFish = new Texture(TileSet_Main, 16 * 8, 16 * 359, 16 * 6, 16 * 14);
        door = new Texture(TileSet_Main, 16 * 8, 16 * 401, 16 * 5, 16 * 5);
        bigBuildingLeft = new Texture(TileSet_Main, 16 * 8, 16 * 373, 16*7, 16*14);
        bigBuildingRight = new Texture(TileSet_Main, 16 * 8, 16 * 387, 16*6, 16*14);
        bigBuilding2Left = new Texture(TileSet_Main, 0, 16 * 469, 16*8, 16*13);
        bigBuilding2Right = new Texture(TileSet_Main, 16, 16 * 482, 16*7, 16*13);
        bigRock = new Texture(TileSet_Main, 160, 16 * 21, 48, 48);
        god = new Texture(TileSet_Pkmn, 16 * 22, 16 * 24, 16*3, 16*4);
        niceTree = new Texture(TileSet_Main, 192, 3696, 224 - 192, 3728 - 3696);
        rock = new Texture(TileSet_Main, 48, 16, 16, 16);
        //textBox = new Texture(imageToBufferedImage(addImage("images/textbox.bmp")), 0, 0, 252, 47);
        water1 = new Texture(TileSet_Main, 16*5, 16*26, 16, 16);
        water2 = new Texture(TileSet_Main, 16*6, 16*26, 16, 16);
        water3 = new Texture(TileSet_Main, 16*7, 16*26, 16, 16);
        water4 = new Texture(TileSet_Main, 16*5, 16*27, 16, 16);
        water5 = new Texture(TileSet_Main, 16*6, 16*27, 16, 16);
        water6 = new Texture(TileSet_Main, 16*7, 16*27, 16, 16);
        water7 = new Texture(TileSet_Main, 16*5, 16*28, 16, 16);
        water8 = new Texture(TileSet_Main, 16*6, 16*28, 16, 16);
        water9 = new Texture(TileSet_Main, 16*7, 16*28, 16, 16);

        players[3] = new Texture(TileSet_Characters, 510, 194, 14, 20);
        players[0] = new Texture(TileSet_Characters, 525, 194, 14, 20);
        players[9] = new Texture(TileSet_Characters, 539, 194, 14, 20);
        players[4] = new Texture(TileSet_Characters, 553, 194, 15, 20);
        players[1] = new Texture(TileSet_Characters, 569, 194, 14, 20);
        players[10] = new Texture(TileSet_Characters, 584, 194, 14, 20);
        players[11] = new Texture(TileSet_Characters, 598, 194, 14, 20);

        players[7] = new Texture(TileSet_Characters_Flipped, 27, 194, 14, 20);
        players[8] = new Texture(TileSet_Characters_Flipped, 41, 194, 14, 20);
        players[6] = new Texture(TileSet_Characters_Flipped, 85, 194, 14, 20);

        players[5] = new Texture(TileSet_Characters_Flipped, 71, 194, 15, 20);
        players[2] = new Texture(TileSet_Characters_Flipped, 55, 194, 14, 20);

       

        playerAnimation = new AnimationFrame[12];

	for (int i = 0; i < playerAnimation.length; i++ ) {
	    playerAnimation[i] = new AnimationFrame(players[i]);
	}
       
    }

    /**
     * Creates a BufferedImage from a file in the src/edu/ucsb/cs56/S12/sbaldwin/pokemon directory
     *
     * @param name the name of the file
     * @return a BufferedImage of said image file
     */
    private static BufferedImage addImage(String name) {
        BufferedImage img = null;
        try {
            File f = new File("src/main/java/edu/ucsb/cs56/projects/games/pokemon/" + name);
            System.out.println(f.getAbsolutePath());
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        return img;
    }

    /**
     * Creates a BufferedImage from a Image object
     *
     * @param image the Image
     * @return the BufferedImage
     */
    private static BufferedImage imageToBufferedImage(Image image) {

        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return bufferedImage;
    }

    /**
     * Makes a specific color transparent
     * 
     * @param im the BufferedImage
     * @param color the Color
     * @return an Image where color is made transparent
     */
    private static Image makeColorTransparent(BufferedImage im, final Color color) {
        ImageFilter filter = new RGBImageFilter() {

            // the color we are looking for... Alpha bits are set to opaque
            public int markerRGB = color.getRGB() | 0xFF000000;

            public final int filterRGB(int x, int y, int rgb) {
                if ((rgb | 0xFF000000) == markerRGB) {
                    // Mark the alpha bits as zero - transparent
                    return 0x00FFFFFF & rgb;
                } else {
                    // nothing to do
                    return rgb;
                }
            }
        };

        ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(ip);
    }

    public static Texture getTexture(String texture) {
        switch (texture) {
            case "pokemart": return Assets.pokemart;
            case "pokecenter": return Assets.pokecenter;
            case "smallHouse": return Assets.smallHouse;
            case "mediumHouse": return Assets.mediumHouse;
            case "largeHouse": return Assets.largeHouse;
	    case "workingTree": return Assets.workingTree;
	    case "workingTree2": return Assets.workingTree2;
	    case "workingTree3": return Assets.workingTree3;
	    case "grass_Wild": return Assets.grass_Wild;
	    default: return null;
        }
    }
}
