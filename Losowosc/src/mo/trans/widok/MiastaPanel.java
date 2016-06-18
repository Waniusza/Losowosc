/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mo.trans.widok;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JPanel;
import javax.swing.Timer;
import mo.trans.Connection;
import mo.trans.Track;

/**
 *
 * @author Janusz Sokołow, Student of Gdańsk University of Technology
 */
public class MiastaPanel extends JPanel implements ActionListener  {

    private final int DELAY = 550;
    private Timer timer;
    
    private Track track;

    public MiastaPanel(Track trackList) {
        this.track = trackList;
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
        
        Iterator<Connection> iterator = track.getConnections().iterator();
            System.out.println("mo.trans.MiastaPanel.doDrawing() Rysuję połączenie " + track);
        while (iterator.hasNext()) {
            Connection conn = iterator.next();
            g2d.drawRect(conn.getCity1().getX()-2, conn.getCity1().getY()-2, 4, 4);
            g2d.drawRect(conn.getCity2().getX()-2, conn.getCity2().getY()-2, 4, 4);
            g2d.drawLine(conn.getCity1().getX(), conn.getCity1().getY(), conn.getCity2().getX(), conn.getCity2().getY());
        } 
//
//        int[] statsX = new int[10];
//        int[] statsY = new int[10];
//
//        int w = getWidth();
//        int h = getHeight();
//
//        for (int i = 0; i < 250; i++) {
//            long[] coordinates = generator.getCoordinates();
//
//            double x = (float) coordinates[0] / MOD;
//            double y = (float) coordinates[1] / MOD;
//
//            statsX[(int) (x * 10)]++;
//            statsY[(int) (y * 10)]++;
//            System.out.println("Wygenerowalem punkt : (" + x + " | " + y + ")");
//            /*
//             * wypełnienie punktu (x|y) kolorem
//             */
//            int XX = (int) Math.abs(x * 250);
//            int YY = (int) Math.abs(y * 250);
//            g2d.drawLine(XX, YY, XX, YY);
//        }
//
//        System.out.println("Statystyka podpowiada, że na OX był następujący rozkład: " + Arrays.toString(statsX));
//        System.out.println("Statystyka podpowiada, że na OY był następujący rozkład: " + Arrays.toString(statsY));

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
