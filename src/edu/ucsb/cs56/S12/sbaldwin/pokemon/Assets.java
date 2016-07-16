package edu.ucsb.cs56.S12.sbaldwin.pokemon;

import edu.ucsb.cs56.S12.sbaldwin.pokemon.graphics.Texture;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class Assets {
    public static Texture
            grass_Default,
            grass_Wild,
            flower,
            flower2,
            flower3,
            snow,
            bigPokemon,
            pikachu, // TODO
            player,  // TODO
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


    public static void initAssets() {
        BufferedImage TileSet_Main = addImage("images/TilesetMain.bmp");
        BufferedImage TileSet_Characters = addImage("images/NPC_frlg.bmp");
        BufferedImage TileSet_Pkmn = addImage("images/pkmn.bmp");
        TileSet_Main = imageToBufferedImage(makeColorTransparent(TileSet_Main, Color.black));
        TileSet_Characters = imageToBufferedImage(makeColorTransparent(TileSet_Characters, new Color(255, 0, 255)));
        TileSet_Pkmn = imageToBufferedImage(makeColorTransparent(TileSet_Pkmn, Color.white));



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
        textBox = new Texture(imageToBufferedImage(addImage("images/textbox.bmp")), 0, 0, 252, 47);
        water1 = new Texture(TileSet_Main, 16*5, 16*26, 16, 16);
        water2 = new Texture(TileSet_Main, 16*6, 16*26, 16, 16);
        water3 = new Texture(TileSet_Main, 16*7, 16*26, 16, 16);
        water4 = new Texture(TileSet_Main, 16*5, 16*27, 16, 16);
        water5 = new Texture(TileSet_Main, 16*6, 16*27, 16, 16);
        water6 = new Texture(TileSet_Main, 16*7, 16*27, 16, 16);
        water7 = new Texture(TileSet_Main, 16*5, 16*28, 16, 16);
        water8 = new Texture(TileSet_Main, 16*6, 16*28, 16, 16);
        water9 = new Texture(TileSet_Main, 16*7, 16*28, 16, 16);



    }

    private static BufferedImage addImage(String name) {
        BufferedImage img = null;
        try {
            File f = new File("src/edu/ucsb/cs56/S12/sbaldwin/pokemon/" + name);
            System.out.println(f.getAbsolutePath());
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        return img;
    }

    private static BufferedImage imageToBufferedImage(Image image) {

        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return bufferedImage;
    }

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
}
