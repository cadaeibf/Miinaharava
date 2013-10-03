
package main;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import napinPainamiset.AsetustenLahettaminen;

/**
 *
 * @author Cadaei
 */
public class AsetuksetRuutu implements Runnable {
    private JFrame frame;

    public AsetuksetRuutu() {
    }

    @Override
    public void run() {
        frame = new JFrame("Asetukset");
        frame.setPreferredSize(new Dimension(200, 100));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(4, 2));
        
        JTextArea x = new JTextArea("20");
        JTextArea y = new JTextArea("16");
        JTextArea miinoja = new JTextArea("100");
        JButton valmis = new JButton("Valmis");
        valmis.addActionListener(new AsetustenLahettaminen(x, y, miinoja));
        
        container.add(new JLabel("X:"));
        container.add(x);
        container.add(new JLabel("Y:"));
        container.add(y);
        container.add(new JLabel("Miinoja:"));
        container.add(miinoja);
        container.add(new JLabel());
        container.add(valmis);
    }
    
}
