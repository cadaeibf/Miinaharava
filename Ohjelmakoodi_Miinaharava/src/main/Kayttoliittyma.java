
package main;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import src.Nappi;

class Kayttoliittyma implements Runnable {
    private JFrame frame;
    
    public Kayttoliittyma() {
        
    }
    
    @Override
    public void run() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(200,300));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(20,20));
        for (int i = 0; i < 200; i++) {
            container.add(new JButton());
        }
    }
    
}
