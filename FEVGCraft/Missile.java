import java.awt.Image;
import javax.swing.ImageIcon;

/**
*   This class is developed as a demo for running a Java application.
*
*   @author     Francisco Enrique Vicente G. Castro
*   @version    2.0, 17 March 2013
*/

public class Missile {

    private String missile = "missile.png";

    private int x, y;
    private Image image;
    boolean visible;

    private final int BOARD_WIDTH = 500;
    private final int MISSILE_SPEED = 2;

    public Missile( int x, int y ) {

        // Associate image for missile
        ImageIcon ii = new ImageIcon( this.getClass().getResource( missile ) );
        image = ii.getImage();

        visible = true;

        this.x = x;
        this.y = y;

    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void move() {

        x += MISSILE_SPEED;

        if ( x > BOARD_WIDTH ){
            visible = false;
        }
        
    }

}