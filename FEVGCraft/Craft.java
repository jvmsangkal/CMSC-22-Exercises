import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
*   This class is developed as a demo for running a Java application.
*
*   @author     Francisco Enrique Vicente G. Castro
*   @version    2.0, 17 March 2013
*/

public class Craft {

    private String craft = "craft.png";

    private int dx; // change in x-location
    private int dy; // change in y-location
    private int x;  // current x-location
    private int y;  // current y-location

    private Image image;

    private ArrayList missiles;

    private final int CRAFT_SIZE = 50;

    public Craft() {

        // Associate image for spacecraft
        ImageIcon ii = new ImageIcon( this.getClass().getResource( craft ) );
        image = ii.getImage();

        // Instantiate ArrayList to hold Missile objects
        missiles = new ArrayList();

        x = 40;
        y = 60;

    }


    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public ArrayList getMissiles() {
        return missiles;
    }

    public void fire() {

        // Add to Arraylist a new missile with its respective position
        missiles.add( new Missile( x + ( CRAFT_SIZE * 2 ), y + ( CRAFT_SIZE / 2 ) ) );

    }

    public void keyPressed( KeyEvent event ) {

        int key = event.getKeyCode();

        if ( key == KeyEvent.VK_SPACE ) {
            fire();
        }

        if ( key == KeyEvent.VK_LEFT ) {
            dx = -1;
        }

        if ( key == KeyEvent.VK_RIGHT ) {
            dx = 1;
        }

        if ( key == KeyEvent.VK_UP ) {
            dy = -1;
        }

        if ( key == KeyEvent.VK_DOWN ) {
            dy = 1;
        }

    }

    public void keyReleased( KeyEvent event ) {

        int key = event.getKeyCode();

        if ( key == KeyEvent.VK_LEFT ) {
            dx = 0;
        }

        if ( key == KeyEvent.VK_RIGHT ) {
            dx = 0;
        }

        if ( key == KeyEvent.VK_UP ) {
            dy = 0;
        }

        if ( key == KeyEvent.VK_DOWN ) {
            dy = 0;
        }

    }
    
}