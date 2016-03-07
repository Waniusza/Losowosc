/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package losowosc;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

class los extends JPanel implements ActionListener {
    
    private static long MOD = (Long.MAX_VALUE/2);
    private final int DELAY = 150;
    private Timer timer;


    public los() {

        initTimer();
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    public Timer getTimer() {
        
        return timer;
    }

    private void doDrawing(Graphics g) {

        Generator generator = new Generator(MOD);
        
        int[] statsX = new int[10];
        int[] statsY = new int[10];
        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.red);
        for (int i=0 ; i<1000 ; i++) {
            long[] coordinates = generator.getCoordinates();
            
            int w = 500; //width
            int h = 500; //height
            
            Random r = new Random();
            
        
            float x = (float) coordinates[0] / MOD;
            float y = (float) coordinates[1] / MOD;
             
            statsX[(int)(x*10)]++;
            statsY[(int)(y*10)]++;
            System.out.println("Wygenerowa�em punkt : (" + x + " | " + y + ")");
            
            int xx = Math.round(x) % w;
            int yy = Math.round(y) % h;
            g2d.drawLine(xx, yy, xx, yy);
           
        //RYSOWANIE
        /* for (int j = 0; j < 1000; j++) {

            int xx = Math.round(x) % w;
            int yy = Math.round(y) % h;
            g2d.drawLine(xx, yy, xx, yy);
        }
        */

        
    }

   
}

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
    }
    
    
}

