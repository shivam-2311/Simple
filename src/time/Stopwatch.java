package time;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Stopwatch extends JFrame
{
    private static final long serialVersionUID = 1L;
    JLabel timelabel, startlabel, resetlabel, exitlabel;
    int xMouse, yMouse, x, y;
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    Timer timer = new Timer(1000,new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            elapsedTime=elapsedTime+1000;
	        hours = (elapsedTime/3600000);
	        minutes = (elapsedTime/60000) % 60;
	        seconds = (elapsedTime/1000) % 60;
	        seconds_string = String.format("%02d", seconds);
	        minutes_string = String.format("%02d", minutes);
	        hours_string = String.format("%02d", hours);
	        timelabel.setText(hours_string+" : "+minutes_string+" : "+seconds_string);
        }
    });

    public Stopwatch()
    {
        this.setSize(150, 71);
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
        
        startlabel = new JLabel("Start");
        startlabel.setBounds(5, 46, 65, 20);
        startlabel.setFont(new Font("Verdana", Font.BOLD, 15));
        startlabel.setForeground(new Color(0x00FF00));
        startlabel.setHorizontalAlignment(JLabel.CENTER);
        startlabel.setBorder(new LineBorder(new Color(0x00FF00), 1, true));
        startlabel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent evt)
            {
                if (!started)
                {
                    started = true;
                    timer.start();
                    startlabel.setText("Stop");
                }
                else
                {
                    started = false;
                    timer.stop();
                    startlabel.setText("Start");
                }
            }
        });

        resetlabel = new JLabel("Reset");
        resetlabel.setBounds(80, 46, 65, 20);
        resetlabel.setFont(new Font("Verdana", Font.BOLD, 15));
        resetlabel.setForeground(new Color(0x00FF00));
        resetlabel.setHorizontalAlignment(JLabel.CENTER);
        resetlabel.setBorder(new LineBorder(new Color(0x00FF00), 1, true));
        resetlabel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                timer.stop();
                startlabel.setText("Start");
                elapsedTime = 0;
                hours = 0;
                minutes = 0;
                seconds = 0;
                started = false;
                seconds_string = String.format("%02d", seconds);
                minutes_string = String.format("%02d", minutes);
                hours_string = String.format("%02d", hours);
                timelabel.setText(hours_string+" : "+minutes_string+" : "+seconds_string);
            }
        });

        add(timelabel);
        add(exitlabel);
        add(startlabel);
        add(resetlabel);

        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timelabel.setText(hours_string+" : "+minutes_string+" : "+seconds_string);

        this.setVisible(true);
    }
}