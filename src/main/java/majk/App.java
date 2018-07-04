package majk;


import javax.swing.*;

/**
 * Obliczanie liczby PI metoda Monte Carlo
 */
public class App extends JFrame
{

    public static void main( String[] args )
    {

        int liczba=10000;
        MonteCarloJPanel jPanel = new MonteCarloJPanel(liczba);
        JFrame application = new JFrame( "Obliczanie liczby PI metoda Monte Carlo\n" );
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        application.add( jPanel );
        application.setSize( 612, 680 );
        application.setVisible( true );
    }
}