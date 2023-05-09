import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

/**
 * Controls the game, does loading, saving, reading, writing, etc.
 * @ Author William House
 * @Date 4/29/2023
 */
public class Control implements Runnable, ActionListener, MouseListener, MouseMotionListener {

    private View view;
    private GameState state;
    private TreeMap<String, BufferedImage> imageCache;
    private Timer time;


    public void run(){
        imageCache = new TreeMap<String, BufferedImage>();
        view = new View (this, state);
        state = new GameState();
        view = new View(this, state);
        view.addMouseListener(this);
        view.addMouseMotionListener(this);

        state.startFrame();


        state.addGameObject(new GameBoard(this, state));

        state.finishFrame();

        time = new Timer(16,this);
        time.start();
    }

    /**
     * Loads an image as named in paramaters, if image can not be loaded null is returned.
     * @param filename
     * @return Buffered image, or null
     */
    private BufferedImage loadImage (String filename){
        System.out.println("Loading " + filename);
        try {
            return javax.imageio.ImageIO.read(new File(filename));
        }
        catch (IOException e){
            System.out.println("Could not read " + filename);
            return null;
        }
    }

    /**
     * Loads indicated image from cache if possible, otherwise puts image into cache.
     * @param filename
     * @return Buffered Image
     */
    public BufferedImage getImage (String filename){
        if ( ! imageCache.containsKey(filename)) {
            BufferedImage image = loadImage(filename);
            imageCache.put(filename, image);
        }
        return imageCache.get(filename);
    }

    /**
     * This method gives each game object the opportunity to update, consume a click, and then clears mouse pressed
     * so it can all happen again. When the game is over, the game stops updating and the GameOver screen is invoked.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Main update loop

        state.startFrame();

            for (Animatable a : state.getCurrentObjects())
                a.update(state.getElapsedTime());


        state.finishFrame();

        view.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
