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
            rockGround,
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
            water, // TODO
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
        rockGround = new Texture(TileSet_Main, 16 * 6, 16 * 10, 16, 16);
        snow = new Texture(TileSet_Main, 16 * 1, 16 * 351, 16, 16);

        bigPokemon = new Texture(TileSet_Main, 16 * 31, 16 * 17, 16 * 32, 16 * 20);
        pokeball = new Texture(TileSet_Main, 16 * 5, 16 * 3, 16 * 6, 16 * 4);
        pokecenter = new Texture(TileSet_Main, new Rectangle(0, 720, 80, 800));
        pokemart = new Texture(TileSet_Main, new Rectangle(0, 656, 64, 720));
        smallHouse = new Texture(TileSet_Main, 0, 1840, 80, 1888);
        tree = new Texture(TileSet_Main, 240, 3632, 256, 3664);
        mediumHouse = new Texture(TileSet_Main, 0, 1888, 80, 1968);
        largeHouse = new Texture(TileSet_Main, 16, 1968, 128, 2048);
        bigFish = new Texture(TileSet_Main, 16 * 8, 16 * 359, 16 * 4, 16 * 373);
        door = new Texture(TileSet_Main, 16 * 8, 16 * 401, 16 * 13, 16 * 406);
        bigBuildingLeft = new Texture(TileSet_Main, 16 * 8, 16 * 373, 16, 16);
        bigBuildingRight = new Texture(TileSet_Main, 16 * 8, 16 * 378, 16, 16);
        bigBuilding2Left = new Texture(TileSet_Main, 0, 16 * 469, 16, 16);
        bigBuilding2Right = new Texture(TileSet_Main, 16, 16 * 482, 16, 16);
        bigRock = new Texture(TileSet_Main, 160, 16 * 21, 16, 16);
        god = new Texture(TileSet_Pkmn, 16 * 22, 16 * 24, 16, 16);

        textBox = new Texture(imageToBufferedImage(addImage("images/textbox.bmp")), 0, 0, 252, 47);


    }

    private static BufferedImage addImage(String name) {
        BufferedImage img = null;
        try {
            File f = new File("assets/" + name);
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
