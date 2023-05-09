import java.awt.Graphics;

/**
 * Our animatable interface, which enables us to describe our game objects as animatable and then treat them
 * accordingly.
 */
public interface Animatable
{


    public void update(double timeElapsed);
    public void draw(Graphics g);
}
