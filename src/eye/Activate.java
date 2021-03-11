package eye;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.awt.*;

public class Activate extends JFrame{

    private static final long serialVersionUID = 1L;

    JPasswordField mainpasswordfield;
    JLabel exitlabel;

    int xMouse, yMouse, x, y;
    String mainstring;

    Activate(int xMousepassed, int yMousepassed, int xpassed, int ypassed)
    {
        xMouse = xMousepassed;
        yMouse = yMousepassed;
        x = xpassed;
        y = ypassed;
    
        this.setLayout(null);
        this.setSize(210, 30);
        this.setUndecorated(true);
        this.setOpacity(0.85f);
        this.setAlwaysOnTop(true);
        if (xMouse == 0 && yMouse == 0 && x == 0 && y == 0)
            this.setLocationRelativeTo(null);
        else
            this.setLocation(x-xMouse, y-yMouse);
        this.getContentPane().setBackground(Color.BLACK);
        this.addMouseListener(new MouseAdapter() 
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

        mainpasswordfield = new JPasswordField();
        mainpasswordfield.setBounds(5, 5, 200, 21);
        mainpasswordfield.setBackground(Color.BLACK);
        mainpasswordfield.setCaretColor(new Color(0xFF0000));
        mainpasswordfield.setForeground(new Color(0xFF0000));
        mainpasswordfield.setFont(new Font("Verdana", Font.BOLD, 13));
        mainpasswordfield.setBorder(new LineBorder(new Color(0xFF0000), 1, true));  
        mainpasswordfield.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent evt)
            {
                setOpacity(0.85f);
            }
        });
        mainpasswordfield.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent evt)
            {
                mainstring = String.valueOf(mainpasswordfield.getPassword());
                if (evt.getKeyCode() == KeyEvent.VK_ENTER)
                {                          
                    if (mainstring.equals("simple"))
                    {
                        new Dashboard(xMouse, yMouse, x, y);
                        dispose();
                    }
                }                              
            }
        });

        exitlabel = new JLabel("x");
        exitlabel.setBounds(188, 0, 12, 12);
        exitlabel.setBorder(new LineBorder(new Color(0xFF0000), 1, true));
        exitlabel.setFont(new Font("Verdana", Font.BOLD, 10));
        exitlabel.setForeground(new Color(0xFF0000));
        exitlabel.setHorizontalAlignment(JLabel.CENTER);
        exitlabel.setVerticalAlignment(JLabel.CENTER);
        exitlabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        exitlabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) 
            {
                dispose();
            }    
        });

        add(mainpasswordfield);
        mainpasswordfield.add(exitlabel);
        

        this.setVisible(true);  
    }

    public static void main(String args[])
    {
        new Activate(0, 0, 0, 0);
    }
}