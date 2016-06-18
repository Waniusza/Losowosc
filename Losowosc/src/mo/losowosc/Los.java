/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mo.losowosc;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JPanel;
import javax.swing.Timer;

class Los extends JPanel implements ActionListener {

    private final int DELAY = 550;
    private Timer timer;
    private static long MOD = Long.MAX_VALUE;
    private Generator generator;

    public Los(long a, long b, long n, int generatorNumber) {
        switch (generatorNumber) {
            case 1: // generator pseudolosyw
                generator = new GeneratorPseudo(a, b, n, MOD);
                break;
            case 2: // gausowski
                generator = new GeneratorGausowski(a, b, n, MOD);
                break;
            case 3: // levyego
                generator = new GeneratorLevyego(a, b, n, MOD);
                break;
            default:
                System.out.println("Nie ma takiego generatora!");
        }

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

        int[] statsX = new int[10];
        int[] statsY = new int[10];

        int w = getWidth();
        int h = getHeight();

        for (int i = 0; i < 250; i++) {
            float[] coordinates = generator.getCoordinates();

            int x = (int) (coordinates[0] * w);
            int y = (int) (coordinates[1] * h);

            statsX[((int) (x * 10) / w)]++;
            statsY[((int) (y * 10) / h)]++;
            System.out.println("Wygenerowalem punkt : (" + x + " | " + y + ")");
            /*
             * wypełnienie punktu (x|y) kolorem
             */
            int XX = x;
            int YY = y;
            g2d.drawLine(XX, YY, XX, YY);
        }

        System.out.println("Statystyka podpowiada, że na OX był następujący rozkład: " + Arrays.toString(statsX));
        System.out.println("Statystyka podpowiada, że na OY był następujący rozkład: " + Arrays.toString(statsY));

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
