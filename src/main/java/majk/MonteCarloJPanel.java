package majk;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

/**
 * Przyblizenie liczby PI metoda Monte Carlo
 */
public class MonteCarloJPanel extends JPanel
{
    // model attributes
    private int numExperiments = 100000;
    private int numInCircle;

    // view attributes
    private final static int OFFSET = 5;
    private final static int NUM_PIXELS = 600;

    public MonteCarloJPanel(int liczba) {
        this.numExperiments = liczba;
    }

    @Override
    protected void paintComponent( Graphics graphics )
    {

        super.paintComponent( graphics );
        numInCircle =  0;     // zeruje sie za kazdym zainicjowaniem
        Color color;
        for ( int experimentNum = 0; experimentNum < numExperiments; experimentNum++ )
        {
            double x = Math.random();            // 0.0 <= x < 1.0
            double y = Math.random();            // 0.0 <= y < 1.0
            int xInt = (int) ( x * NUM_PIXELS );
            int yInt = (int) ( y * NUM_PIXELS );
            x = 2 * x - 1;                       // -1.0 <= x < 1.0
            y = 2 * y - 1;                       // -1.0 <= y < 1.0
            if ( x * x + y * y <= 1.0 )
            {
                numInCircle++;
                color = Color.red;
            }
            else
            {
                color = Color.blue;
            }
            graphics.setColor( color );
            graphics.fillRect( OFFSET + xInt, OFFSET + yInt, 1, 1 );
        }

        // rysowanie kola i kwadratu, po wylosowaniu punktow
        graphics.setColor( Color.black );
        graphics.drawRect(OFFSET, OFFSET, NUM_PIXELS, NUM_PIXELS );
        graphics.drawOval(OFFSET, OFFSET, NUM_PIXELS, NUM_PIXELS);
        //wzor na obliczenie liczby pi
        double pi = 4.0 * numInCircle / numExperiments;
        graphics.drawString("PI = " + pi, 2 * OFFSET, NUM_PIXELS + 5 * OFFSET );
    }
}
