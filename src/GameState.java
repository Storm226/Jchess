import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

/**
 * This class enables us to keep track of a list of objects frame by frame
 * for our use elsewhere in the TowerDefense Project
 */
public class GameState
{
    private List<GameObject> currentFrameObjects;
    private List<GameObject> nextFrameObjects;
    private Point mouseLocation;
    private Boolean gameIsOver;
    private long lastFrameStartTime;
    private double elapsedTime;

    /**
     *Constructor - Creates an empty Arraylist of GameObject objects and initializes our fields.
     */
    public GameState ()
    {
        System.out.println("State has been built");
        currentFrameObjects = new ArrayList<GameObject>();
        lastFrameStartTime = System.currentTimeMillis();
        elapsedTime = 0;
        this.gameIsOver = false;
    }

    /**
     * Returns current mouse location
     * @return MouseLoc
     */
    public Point getMouseLoc()
    {
        return mouseLocation;
    }

    /**
     * Mutator - sets mouse location
     * @param mouseLoc
     */

    public void setMouseLocation(Point mouseLoc)
    {
        this.mouseLocation = mouseLoc;
    }

    /**
     * Returns list of current game objects
     * @return List <GameObject>
     */
    public List<GameObject> getCurrentObjects ()
    {
        return currentFrameObjects;
    }

    /**
     * Accessor - returns elapsed time
     * @return
     */

    public double getElapsedTime()
    {
        return elapsedTime;
    }

    /**
     * This method prepares the next frame's objects to be a list of our current frame's objects
     */

    public void startFrame ()
    {
        // Calculate how much time has elapsed since the previous start frame
        long currentFrameStartTime = System.currentTimeMillis();
        elapsedTime = (currentFrameStartTime - lastFrameStartTime)/1000.0;
        lastFrameStartTime = currentFrameStartTime;
        nextFrameObjects = new ArrayList<GameObject>();    // Creates empty list
        nextFrameObjects.addAll(currentFrameObjects);      // Add all the current ones to the new list.

    }

    /**
     * This method enables us to add an GameObject oject to our next frame's list of game objects
     *
     * @param a GameObject object
     */
    public void addGameObject (GameObject a)
    {
        nextFrameObjects.add(a);
    }
    /**
     * This method sets our current frame's objects to be a copy of the next frame's objects
     */
    public void finishFrame ()
    {
        // Remove any current objects that are expired from the
        // next frame.
        for (GameObject go : currentFrameObjects)
            if (go.hasExpired())
                nextFrameObjects.remove(go);

        currentFrameObjects = nextFrameObjects;
        nextFrameObjects = null;  // This makes it clear there is only a current list now.
    }
}
