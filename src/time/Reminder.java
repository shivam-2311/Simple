package time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;

public class Reminder extends JFrame
{
    private static final long serialVersionUID = 1L;
    Calendar calendar;
    SimpleDateFormat secondsFormat;
    SimpleDateFormat minutesFormat;
    SimpleDateFormat hoursFormat;

    JTextField timeField;
    JTextArea reminderText;
    JScrollPane scroll;
    JLabel button;
    JLabel exitlabel;

    int xMouse, yMouse, x, y;

    String reminderHours;
    String reminderMinutes;
    String reminderSeconds;

    String hoursString;
    String minutesString;
    String secondsString;

    Timer timer = new Timer(1000, new ActionListener()
    {
        public void actionPerformed(ActionEvent evt)
        {
            hoursString = hoursFormat.format(Calendar.getInstance().getTime());
            minutesString = minutesFormat.format(Calendar.getInstance().getTime());
            secondsString = secondsFormat.format(Calendar.getInstance().getTime());
            if (hoursString.equals(reminderHours) && minutesString.equals(reminderMinutes) && secondsString.equals(reminderSeconds))
            {
                timer.stop();
                setVisible(true);
            }

        }
    });

    public Reminder(String hours, String minutes, String seconds)
    {
        reminderHours = hours;
        reminderMinutes = minutes;
        reminderSeconds = seconds;

        hoursFormat = new SimpleDateFormat("kk");
        minutesFormat = new SimpleDateFormat("mm");
        secondsFormat = new SimpleDateFormat("ss");

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
        
        timeField = new JTextField("00:00:00");
        timeField.setBounds(10, 5, 280, 25);
        timeField.setOpaque(true);
        timeField.setBackground(Color.BLACK);
        timeField.setFont(new Font("Verdena", Font.BOLD, 16));
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

        button = new JLabel("Reminder Alert");
        button.setBounds(90, 270, 120, 20);
        button.setBackground(Color.black);
        button.setHorizontalAlignment(JLabel.CENTER);
        button.setForeground(new Color(0x00FF00));
        button.setBorder(new LineBorder(new Color(0x00FF00), 1));

        try
        {
            FileReader reader = new FileReader("src\\time\\Reminder.txt");
            reminderText.read(reader, "src\\time\\Reminder.txt");
            reader.close();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        timeField.add(exitlabel);
        add(timeField);
        add(scroll);
        add(button);

        setVisible(false);

        timer.start();
    }
}
