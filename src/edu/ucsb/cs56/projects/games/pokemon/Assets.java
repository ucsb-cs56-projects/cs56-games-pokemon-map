package edu.ucsb.cs56.projects.games.pokemon;

import edu.ucsb.cs56.projects.games.pokemon.graphics.Animation;
import edu.ucsb.cs56.projects.games.pokemon.graphics.AnimationFrame;
import edu.ucsb.cs56.projects.games.pokemon.graphics.Texture;

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
            textBox,
            player0, player1, player2, player3, player4, player5,
            player6, player7, player8, player9, player10, player11;
    public static AnimationFrame
            player0f, player1f, player2f, player3f, player4f, player5f,
            player6f, player7f, player8f, player9f, player10f, player11f;
    public static AnimationFrame[] playerAnimation;



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

        bigPokemon = new Texture(TileSet_Pkmn, 16 * 31, 16 * 17, 16*4, 16 * 3);
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

        player3 = new Texture(TileSet_Characters, 510, 194, 14, 20);
        player0 = new Texture(TileSet_Characters, 525, 194, 14, 20);
        player9 = new Texture(TileSet_Characters, 539, 194, 14, 20);
        player4 = new Texture(TileSet_Characters, 553, 194, 15, 20);
        player1 = new Texture(TileSet_Characters, 569, 194, 14, 20);
        player10 = new Texture(TileSet_Characters, 584, 194, 14, 20);
        player11 = new Texture(TileSet_Characters, 598, 194, 14, 20);

        player7 = new Texture(TileSet_Characters_Flipped, 27, 194, 14, 20);
        player8 = new Texture(TileSet_Characters_Flipped, 41, 194, 14, 20);
        player6 = new Texture(TileSet_Characters_Flipped, 85, 194, 14, 20);

        player5 = new Texture(TileSet_Characters_Flipped, 71, 194, 15, 20);
        player2 = new Texture(TileSet_Characters_Flipped, 55, 194, 14, 20);

        player0f = new AnimationFrame(player0);
        player1f = new AnimationFrame(player1);
        player2f = new AnimationFrame(player2);
        player3f = new AnimationFrame(player3);
        player4f = new AnimationFrame(player4);
        player5f = new AnimationFrame(player5);
        player6f = new AnimationFrame(player6);

        player7f = new AnimationFrame(player7);
        player8f = new AnimationFrame(player8);
        player9f = new AnimationFrame(player9);
        player10f = new AnimationFrame(player10);
        player11f = new AnimationFrame(player11);

        playerAnimation = new AnimationFrame[12];
        playerAnimation[0] = player0f;
        playerAnimation[1] = player1f;
        playerAnimation[2] = player2f;
        playerAnimation[3] = player3f;
        playerAnimation[4] = player4f;
        playerAnimation[5] = player5f;
        playerAnimation[6] = player6f;
        playerAnimation[7] = player7f;
        playerAnimation[8] = player8f;
        playerAnimation[9] = player9f;
        playerAnimation[10] = player10f;
        playerAnimation[11] = player11f;
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
            File f = new File("src/edu/ucsb/cs56/projects/games/pokemon/" + name);
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
            default: return null;
        }
    }
}
