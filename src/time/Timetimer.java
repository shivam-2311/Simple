package time;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Timetimer extends JFrame
{
	private static final long serialVersionUID = 1L;
  
    int xMouse, yMouse, x, y;
    int  elapsed, hours, minutes, seconds;

    JLabel timelabel, exitlabel;

    Timer timer = new Timer(1000,new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            elapsed = elapsed - 1000;
            hours = (elapsed/3600000);
            minutes = (elapsed/60000) % 60;
            seconds = (elapsed/1000) % 60;
            timelabel.setText(String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds));
            if (hours == 0 && minutes == 0 && seconds == 0)
            {
                timer.stop();
                setLocationRelativeTo(null);
                timelabel.setText("Timer Ended");
            }
        }
    });

    public Timetimer(String mainstring)
    {
        this.setSize(150, 46);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.black);
        this.setLayout(null);
        ((JComponent) this.getContentPane()).setBorder(new LineBorder(new Color(0x00FF00), 1, true));
        this.setUndecorated(true);
        this.setOpacity(0.85f);
        this.setAlwaysOnTop(true);
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

        timelabel = new JLabel();
        timelabel.setBounds(5, 5, 140, 36);
        timelabel.setFont(new Font("Verdana", Font.BOLD, 18));
        timelabel.setForeground(new Color(0x00FF00));
        timelabel.setHorizontalAlignment(JLabel.CENTER);
        timelabel.setBorder(new LineBorder(new Color(0x00FF00), 1, true));

        exitlabel = new JLabel("x");
        exitlabel.setBounds(133, 5, 12, 12);
        exitlabel.setBorder(new LineBorder(new Color(0x00FF00), 1, true));
        exitlabel.setFont(new Font("Verdana", Font.BOLD, 10));
        exitlabel.setForeground(new Color(0x00FF00));
        exitlabel.setHorizontalAlignment(JLabel.CENTER);
        exitlabel.setVerticalAlignment(JLabel.CENTER);
        exitlabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) 
            {
                timer.stop();
                dispose();
            }    
        });

        hours = Integer.parseInt(mainstring.substring(10, 12));
        minutes = Integer.parseInt(mainstring.substring(13, 15));
        seconds = Integer.parseInt(mainstring.substring(16, 18));
        elapsed = hours*3600000 + minutes*60000 + seconds*1000;

        timelabel.setText(String.format("%02d", hours) + " : " + String.format("%02d", minutes) + " : " + String.format("%02d", seconds));

        add(timelabel);
        add(exitlabel);
        
        timer.start();

        this.setVisible(true);      
    }
}