package mo.boids;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JApplet;
import javax.swing.Timer;
import mo.GenAWidok;

@SuppressWarnings("serial")
public class BoidApplet extends JApplet implements ActionListener {

    /**
     * The canvas where to draw the boids.
     */
    BoidCanvas canvas;

    /**
     * The flock of boids
     */
    Flock flock;

    int step = 250;

    Timer timer = new Timer(step, this);

    /**
     * Self tuning step.
     */
    long prev;


    @Override

    public void init() {

        canvas = new BoidCanvas();
        flock = new Flock();
        canvas.flock = flock;

        for (int n = 0; n < Constants.count; n++) {
            Boid boid = new Boid();
            boid.flock = flock;
            flock.add(boid);
        }

        add(canvas, BorderLayout.CENTER);
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();

        canvas.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    flock.setCooperative(false);
                } else {
                    flock.setScared(true);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                flock.setScared(false);
                flock.setCooperative(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Flock space will resize automatically when resizing the applet.
        flock.size.height = getHeight();
        flock.size.width = getWidth();

        flock.iteration(step);
        canvas.repaint(step / 2);

        long now = System.currentTimeMillis();
        if (now - prev - step < step / 5) {
            if (step > 5) {
                step = step / 2;
            }
            timer.setDelay(step);
        }
        prev = now;
    }

    
}
