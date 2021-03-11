package working;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class Work extends JFrame{

    private static final long serialVersionUID = 1L;

    int xMouse, yMouse, x, y;

    JLabel exitlabel;
    Icon image;
    JLabel mainLabel;

    public Work() {
        
        setUndecorated(true);
        setAlwaysOnTop(true);
        setSize(608, 352);
        setLocationRelativeTo(null);
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
        exitlabel.setBounds(596, 0, 12, 12);
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

        image = new ImageIcon(this.getClass().getResource("working.gif"));
        mainLabel = new JLabel(image);
        mainLabel.add(exitlabel);
        add(mainLabel);

        setVisible(true);
    }
}
