/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mo;

/**
 *
 * @author Krzysztof
 */
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Krzysztof
 */
public class WindowOpt extends JFrame {
     public WindowOpt() throws HeadlessException {
        setVisible(true);
        setTitle("Generatory");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
            
        setLocation((int) width/3-getWidth()/2,(int) height/3-getHeight()/2);
     }   
}