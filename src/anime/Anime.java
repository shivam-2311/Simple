package anime;

import java.util.Random;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import java.awt.event.*;

public class Anime extends JFrame
{
    private static final long serialVersionUID = 1L;
    Random random;
    Icon image;
    JLabel label;
    JLabel exitlabel;

    int xMouse, yMouse, x, y;

    public Anime()
    {
        setUndecorated(true);
        setAlwaysOnTop(true);
        addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent evt)
            {
                xMouse = evt.getX();
                yMouse = evt.getY();
            }
        });
        addMouseMotionListener(new MouseAdapter()
        {
            public void mouseDragged(MouseEvent evt)
            {
                x = evt.getXOnScreen();
                y = evt.getYOnScreen();
                setLocation(x-xMouse, y-yMouse);
            }
        });

        exitlabel = new JLabel("x");
        exitlabel.setBorder(new LineBorder(new Color(0x00FF00), 1, true));
        exitlabel.setFont(new Font("Verdana", Font.BOLD, 10));
        exitlabel.setForeground(new Color(0x00FF00));
        exitlabel.setHorizontalAlignment(JLabel.CENTER);
        exitlabel.setVerticalAlignment(JLabel.CENTER);
        exitlabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) 
            {
                dispose();
            }    
        });

        randomGenerator();   

        label = new JLabel(image);

        label.add(exitlabel);
        add(label);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    void randomGenerator()
    {
        Random random = new Random();
        switch(random.nextInt(10))
        {
            case 0: setSize(480, 270);
            exitlabel.setBounds(468, 0, 12, 12);
            image = new ImageIcon(this.getClass().getResource("gif0.gif"));
            break;
            case 1: setSize(250, 244);
            exitlabel.setBounds(238, 0, 12, 12);
            image = new ImageIcon(this.getClass().getResource("gif1.gif"));
            break;
            case 2: setSize(312, 350);
            exitlabel.setBounds(300, 0, 12, 12);
            image = new ImageIcon(this.getClass().getResource("gif2.gif"));
            break;
            case 3: setSize(241, 328);
            exitlabel.setBounds(229, 0, 12, 12);
            image = new ImageIcon(this.getClass().getResource("gif3.gif"));
            break;
            case 4: setSize(246, 367);
            exitlabel.setBounds(234, 0, 12, 12);
            image = new ImageIcon(this.getClass().getResource("gif4.gif"));
            break;
            case 5: setSize(462, 280);
            exitlabel.setBounds(450, 0, 12, 12);
            image = new ImageIcon(this.getClass().getResource("gif5.gif"));
            break;
            case 6: setSize(498, 278);
            exitlabel.setBounds(486, 0, 12, 12);
            image = new ImageIcon(this.getClass().getResource("gif6.gif"));
            break;
            case 7: setSize(362, 498);
            exitlabel.setBounds(350, 0, 12, 12);
            image = new ImageIcon(this.getClass().getResource("gif7.gif"));
            break;
            case 8: setSize(284, 498);
            exitlabel.setBounds(272, 0, 12, 12);
            image = new ImageIcon(this.getClass().getResource("gif8.gif"));
            break;
            case 9: setSize(160, 224);
            exitlabel.setBounds(148, 0, 12, 12);
            image = new ImageIcon(this.getClass().getResource("gif9.gif"));
            break;

        }
    }
}
