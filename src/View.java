import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This class is resonsible for building our view area for users.
 * @ Author Alex
 * @ Date 4/29/2023
 */
public class View extends JPanel {

    private BufferedImage background;
    private Control control;
    private GameState state;

    public View(Control control, GameState state)
    {
        this.control = control;
        this.state = state;

        JFrame f = new JFrame("ChessGame 2023");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = new Dimension (1200, 800);
        this.setMinimumSize(d);
        this.setPreferredSize(d);
        this.setMaximumSize(d);
        f.setContentPane(this);
        f.pack();
        f.setLocationRelativeTo(null);  // Centers window
        f.setVisible(true);


    }

    public void paint (Graphics g)
    {
        for (Animatable a : state.getCurrentObjects())
            a.draw(g);
    }

}
