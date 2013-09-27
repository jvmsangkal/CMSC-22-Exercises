import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
*   This class is developed as a demo for running a Java application.
*
*   @author     Francisco Enrique Vicente G. Castro
*   @version    2.0, 17 March 2013
*/

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Craft craft;

    public Board() {

        // Pass a KeyAdapter object (TAdapter) to listen for keyboard events
        // Extending KeyAdapter allows to override only the methods of interest
        this.addKeyListener( new TAdapter() );

        this.setFocusable( true );
        this.setBackground( Color.BLACK );

        // Drawing for this component to be done in an offscreen painting buffer
        // For smoother effects
        this.setDoubleBuffered( true );

        // Instantiate Craft object
        this.craft = new Craft();

        // Instantiate Timer object and start Timer thread
        this.timer = new Timer( 5, this );
        this.timer.start();

    }

    public void actionPerformed( ActionEvent event ) {

        // Retrieve Missile objects of spacecraft
        ArrayList ms = craft.getMissiles();

        for (int i = 0; i < ms.size(); i++) {

            Missile m = (Missile) ms.get( i );

            // Update positional status of each missile
            if ( m.isVisible() ){ 
                m.move();
            }
            else{ 
                // Remove missile from ArrayList if missile has reached edge
                ms.remove(i);
            }

        }

        // Update positional status of spacecraft
        craft.move();

        repaint();

    }

    public void paint( Graphics g ) {

        super.paint( g );

        // Use Graphics2D class: fundamental class for rendering 2-dimensional shapes
        Graphics2D g2d = ( Graphics2D )g;

        // Re-draw spacecraft in a new position
        g2d.drawImage( craft.getImage(), craft.getX(), craft.getY(), this );

        // Retrieve Missile objects of spacecraft
        ArrayList ms = craft.getMissiles();

        // Do for each Missile object in the ArrayList
        for (int i = 0; i < ms.size(); i++ ) {

            // Get a Missile item from the ArrayList
            Missile m = ( Missile ) ms.get(i);

            // Re-draw each missile in a new position
            g2d.drawImage( m.getImage(), m.getX(), m.getY(), this );
        }

        // Synchronizes toolkit's graphics state
        // Ensures that the display is up-to-date
        Toolkit.getDefaultToolkit().sync();

        // Release system resources
        g.dispose();

    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased( KeyEvent event ) {
            craft.keyReleased( event );
        }

        public void keyPressed( KeyEvent event ) {
            craft.keyPressed( event );
        }

    }

}