package audio;

import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame
{
    private static final long serialVersionUID = 1L;
    ImageIcon startIcon;
    ImageIcon stopIcon;
    ImageIcon restartIcon;
    ImageIcon closeIcon;

    JLabel startLabel;
    JLabel restartLabel;
    JLabel closeLabel;

    int xMouse, yMouse, x, y;
    Boolean startBoolean = false;

    Frame(Clip clip)
    {
        setUndecorated(true);
        setAlwaysOnTop(true);
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.BLACK);
        setSize(75, 25);
        setLocationRelativeTo(null);
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder());
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent evt)
            {
                xMouse = evt.getX();
                yMouse = evt.getY();
            }
        });
        this.addMouseMotionListener(new MouseAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent evt)
            {
                x = evt.getXOnScreen();
                y = evt.getYOnScreen();
                setLocation(x-xMouse, y-yMouse);
            }
        });
        
        startIcon = new ImageIcon("src\\audio\\Images\\play-16.png");
        stopIcon = new ImageIcon("src\\audio\\Images\\pause-16.png");
        restartIcon = new ImageIcon("src\\audio\\Images\\skip-to-start-16.png");
        closeIcon = new ImageIcon("src\\audio\\Images\\close-window-16.png");

        startLabel = new JLabel(startIcon);
        startLabel.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                if (startBoolean == false)
                {
                    startBoolean = true;
                    startLabel.setIcon(stopIcon);
                    clip.start();
                    ((JComponent) getContentPane()).setBorder(new LineBorder(new Color(0x00FF00), 1, true));
                }
                else
                {
                    startBoolean = false;
                    startLabel.setIcon(startIcon);
                    clip.stop();
                    ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder());
                }
            }
        });

        restartLabel = new JLabel(restartIcon);
        restartLabel.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                clip.setMicrosecondPosition(0);
            }
        });

        closeLabel = new JLabel(closeIcon);
        closeLabel.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                clip.close();
                dispose();
            }
        });

        add(startLabel);
        add(restartLabel);
        add(closeLabel);

        setVisible(true);
    }  
}
