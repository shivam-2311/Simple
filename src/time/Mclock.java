package time;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Mclock extends JFrame 
{
    private static final long serialVersionUID = 1L;
    Calendar calendar;

    SimpleDateFormat hoursFormat, minutesFormat, secondsFormat, ampmFormat;
    SimpleDateFormat mHoursFormat;

    SimpleDateFormat dateFormat, monthFormat, yearFormat;
    SimpleDateFormat dayInYearFormat;

    SimpleDateFormat dayFormat;

    JLabel timeLabel, dateLabel, dayLabel, exitLabel;

    int xMouse, yMouse, x, y;

    String hoursTime, minutesTime, secondsTime, ampmTime;
    String mHoursTime;
    Boolean timeLabelEnter = false;

    String dateTime, monthTime, yearTime;
    String dayInYearTime;
    Boolean dateLabelEnter = false;
    int totalDaysInYear;

    String dayTime;
    Boolean dayLabelEnter = false;
    
    Timer timer = new Timer(1000, ae ->
    {
        if (timeLabelEnter)
        {
            hoursTime = hoursFormat.format(Calendar.getInstance().getTime());
            minutesTime = minutesFormat.format(Calendar.getInstance().getTime());
            secondsTime = secondsFormat.format(Calendar.getInstance().getTime());
            ampmTime = ampmFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(hoursTime + ":" + minutesTime + ":" + secondsTime + ":" + ampmTime);
        }
        else
        {
            mHoursTime = mHoursFormat.format(Calendar.getInstance().getTime());
            minutesTime = minutesFormat.format(Calendar.getInstance().getTime());
            secondsTime = secondsFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(mHoursTime + ":" + minutesTime + ":" + secondsTime);
        }

        if (dateLabelEnter)
        {
            leapYear();
            yearTime = yearFormat.format(Calendar.getInstance().getTime());
            String dayInYearTime = dayInYearFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText("Day/Year:" + dayInYearTime + "/" + totalDaysInYear);
        }
        else
        {
            dateTime = dateFormat.format(Calendar.getInstance().getTime());
            monthTime = monthFormat.format(Calendar.getInstance().getTime());
            yearTime = yearFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(dateTime + ":" + monthTime + ":" + yearTime);
        }

        if(dayLabelEnter)
        {
            dayTime = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(gym());
        }
        else
        {
            dayTime = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(dayTime);
        }
        
    });

    public Mclock() {
        this.setSize(150, 120);
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

        timeLabel = new JLabel();
        timeLabel.setBounds(5, 5, 140, 36);
        timeLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        timeLabel.setForeground(new Color(0x00FF00));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setBorder(new LineBorder(new Color(0x00FF00), 1, true));
        timeLabel.addMouseListener(new MouseListener()
        {

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e)
            {
                timeLabelEnter = true;
            }

            @Override
            public void mouseExited(MouseEvent e) 
            {
               timeLabelEnter = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            
        });

        exitLabel = new JLabel("x");
        exitLabel.setBounds(128, 0, 12, 12);
        exitLabel.setBorder(new LineBorder(new Color(0x00FF00), 1, true));
        exitLabel.setFont(new Font("Verdana", Font.BOLD, 10));
        exitLabel.setForeground(new Color(0x00FF00));
        exitLabel.setHorizontalAlignment(JLabel.CENTER);
        exitLabel.setVerticalAlignment(JLabel.CENTER);
        exitLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) 
            {
                timer.stop();
                dispose();
            }    
        });
        
        dateLabel = new JLabel();
        dateLabel.setBounds(5, 41, 140, 36);
        dateLabel.setFont(new Font("Verdana", Font.BOLD, 13));
        dateLabel.setForeground(new Color(0x00FF00));
        dateLabel.setHorizontalAlignment(JLabel.CENTER);
        dateLabel.setBorder(new LineBorder(new Color(0x00FF00), 1, true));
        dateLabel.addMouseListener(new MouseListener()
        {

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e)
            {
                dateLabelEnter = true;
            }

            @Override
            public void mouseExited(MouseEvent e) 
            {
               dateLabelEnter = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            
        });

        dayLabel = new JLabel();
        dayLabel.setBounds(5, 77, 140, 36);
        dayLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        dayLabel.setForeground(new Color(0x00FF00));
        dayLabel.setHorizontalAlignment(JLabel.CENTER);
        dayLabel.setBorder(new LineBorder(new Color(0x00FF00), 1, true));
        dayLabel.addMouseListener(new MouseListener()
        {

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e)
            {
                dayLabelEnter = true;
            }

            @Override
            public void mouseExited(MouseEvent e) 
            {
               dayLabelEnter = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            
        });

        hoursFormat = new SimpleDateFormat("hh");
        minutesFormat = new SimpleDateFormat("mm");
        secondsFormat = new SimpleDateFormat("ss");
        ampmFormat = new SimpleDateFormat("a");

        mHoursFormat = new SimpleDateFormat("kk");
        
        dateFormat = new SimpleDateFormat("dd");
        monthFormat = new SimpleDateFormat("MMMMM");
        yearFormat = new SimpleDateFormat("yyyy");
        dayInYearFormat = new SimpleDateFormat("D");

        dayFormat = new SimpleDateFormat("EEEE");
        
        timer.start();
        
        add(timeLabel);
        timeLabel.add(exitLabel);
        add(dateLabel);
        add(dayLabel);

        this.setVisible(true);
    }   

    public void leapYear()
    {
        int year = Integer.parseInt(yearTime);
        if ( (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0) )
        {
            totalDaysInYear = 366;
        }
        else
        {
            totalDaysInYear = 365;
        }
    }

    public String gym()
    {
        if (dayTime.equals("Monday"))
        {
            return "Gym-Back";
        }
        else if (dayTime.equals("Tuesday"))
        {
            return "Gym-Shoulder";
        }
        else if (dayTime.equals("Wednesday"))
        {
            return "Gym-Chest";
        }
        else if (dayTime.equals("Thusday"))
        {
            return "Gym-Biceps";
        }
        else if (dayTime.equals("Friday"))
        {
            return "Gym-Legs";
        }
        else if (dayTime.equals("Saturday"))
        {
            return "Gym-Triceps";
        }
        else
        {
            return "No Gym";
        }
    }
}