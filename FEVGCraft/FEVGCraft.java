import javax.swing.JFrame;

/**
*   This class is developed as a demo for running a Java application.
*
*   @author     Francisco Enrique Vicente G. Castro
*   @version    2.0, 17 March 2013
*/

public class FEVGCraft extends JFrame {

    public FEVGCraft() {

        // Main screen for drawing the differenct components
        this.add( new Board() );

        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setSize( 500, 500 );
        this.setLocationRelativeTo( null );
        this.setTitle( "Spacecraft Demo - FEVGCastro" );
        this.setResizable( false );
        this.setVisible( true );

    }

    public static void main( String[] arguments ) {

        new FEVGCraft();

    }

}