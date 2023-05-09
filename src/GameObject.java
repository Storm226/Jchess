import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This class helps us describe all of our game objects
 */
abstract public class GameObject  implements Animatable
{
    protected boolean hasExpired;

    /**
     * Constructor, objects which have been built have not yet expired
     */
    public GameObject ()
    {
        hasExpired = false;
    }

    /**
     * Accessor - returns if an object has expired or not.
     * @return
     */
    public boolean hasExpired ()
    {
        return hasExpired;
    }

    // Helper function

    /**
     * Draws centered images
     * @param k Graphics object
     * @param image Image to draw
     * @param x px
     * @param y py
     * @param scale scale at which image is drawn
     */

    protected void drawCenteredImage (Graphics k, BufferedImage image, int x, int y, double scale)
    {
        int width  = (int)(image.getWidth() * scale);
        int height = (int) (image.getHeight() * scale);
        int nx = x - width/2;
        int ny = y - height/2;

        k.drawImage(image, nx, ny, width, height, null);
    }

}
