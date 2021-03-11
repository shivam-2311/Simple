package time;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class SetReminder extends JFrame
{
    private static final long serialVersionUID = 1L;
    JTextField timeField;
    JTextArea reminderText;
    JScrollPane scroll;
    JLabel button;
    JLabel exitlabel;

    String timeString;

    String seconds;
    String minutes;
    String hours;

    int xMouse, yMouse, x, y;
    public SetReminder()
    {
        setUndecorated(true);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
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
        
        timeField = new JTextField();
        timeField.setBounds(10, 5, 280, 25);
        timeField.setOpaque(true);
        timeField.setFont(new Font("Verdena", Font.BOLD, 16));
        timeField.setBackground(Color.BLACK);
        timeField.setBorder(new LineBorder(new Color(0x00FF00), 1));
        timeField.setForeground(new Color(0x00FF00));


        exitlabel = new JLabel("x");
        exitlabel.setBounds(268, 0, 12, 12);
        exitlabel.setBorder(new LineBorder(new Color(0x00FF00), 1, true));
        exitlabel.setFont(new Font("Verdana", Font.BOLD, 10));
        exitlabel.setForeground(new Color(0x00FF00));
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

        reminderText = new JTextArea();
        reminderText.setBackground(new Color(24, 24, 24));
        reminderText.setForeground(new Color(0x00FF00));
        reminderText.setFont(new Font("Verdena", Font.PLAIN, 15));

        scroll = new JScrollPane(reminderText, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(10, 35, 280, 230);
        scroll.setBorder(new LineBorder(new Color(0x00FF00), 1));

        button = new JLabel("Set Reminder");
        button.setHorizontalAlignment(JLabel.CENTER);
        button.setBounds(90, 270, 120, 20);
        button.setBackground(Color.black);
        button.setForeground(new Color(0x00FF00));
        button.setBorder(new LineBorder(new Color(0x00FF00), 1));
        button.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                try
                {
                    FileWriter writer = new FileWriter("src\\time\\Reminder.txt");
                    BufferedWriter bf = new BufferedWriter(writer);
                    bf.write(reminderText.getText());
                    bf.close();
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                timeString = timeField.getText();
                hours = timeString.substring(0, 2);
                minutes = timeString.substring(3, 5);
                seconds = timeString.substring(6);
                new Reminder(hours, minutes, seconds);
                dispose();
            }
        });

        timeField.add(exitlabel);
        add(timeField);
        add(scroll);
        add(button);

        setVisible(true);
    }

    public static void main(String args[])
    {
        new SetReminder();
    }
}