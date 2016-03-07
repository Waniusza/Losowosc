/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package losowosc;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;



class Los extends JPanel implements ActionListener {

    private final int DELAY = 150;
    private Timer timer;
    private static long MOD = (Long.MAX_VALUE/2);
        
    public Los() {

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

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.blue);
        g2d.setStroke(new BasicStroke(2));
        
        
        Generator generator = new Generator(MOD);
        
        int[] statsX = new int[10];
        int[] statsY = new int[10];
        
        int w = getWidth();
        int h = getHeight();

        
        
        for (int i=0 ; i<3000 ; i++) {
            long[] coordinates = generator.getCoordinates();
                    
            float x = (float) coordinates[0] / MOD % w;
            float y = (float) coordinates[1] / MOD % h;
             
            statsX[(int)(x*10)]++;
            statsY[(int)(y*10)]++;
            System.out.println("Wygenerowalem punkt : (" + x + " | " + y + ")");
          /*
          * wype�nienie punktu (x|y) kolorem
           */
            g2d.drawLine((int)Math.abs(x*1000), (int)Math.abs(y*1000), (int)Math.abs(x*1000), (int)Math.abs(y*1000));
        
            
        }
        
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      //repaint();
    }

    
}