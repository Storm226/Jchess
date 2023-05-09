import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This class is going to help us build our GameBoard Object
 * @Author Alex House
 */

public class GameBoard extends GameObject {

    private Control control;
    private GameState state;

    /**
     * Constructor
     */
    public GameBoard(Control control, GameState state){
        super();
        this.control = control;
        this.state = state;
        System.out.println("GameBoard Built");
    }

    @Override
    public void update(double timeElapsed) {

    }

    @Override
    public void draw(Graphics g) {
        BufferedImage GameBoard = control.getImage("board.png");
        drawCenteredImage(g, GameBoard, 400, 400, .75);
    }
}
