/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mo.losowosc;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Point extends JFrame {
    
    private long a,b,n;
    
    public Point(long a, long b, long n, int genNum) {
        this.a = a;
        this.b = b;
        this.n = n;
        initUI(genNum);
    }

    private void initUI(int genNum) {

        final Los surface = new Los(a, b, n, genNum);
        add(surface);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Timer timer = surface.getTimer();
                timer.stop();
            }
        });

        setTitle("Points");
        setSize(250, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

//    public static void main(String[] args) {
//
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//
//                Point ex = new Point();
//                ex.setVisible(true);
//            }
//        });
//    }
}