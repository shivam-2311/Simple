package text;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.TimerTask;
import java.util.Timer;

public class WriterText extends JFrame
{
    private static final long serialVersionUID = 1L;

    JTextArea textArea;
    JLabel enter;
    JLabel exitlabel;
    JScrollPane pane;
    int xMouse, yMouse, x, y;
    public WriterText()
    {
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        this.setSize(300, 240);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
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
        

        textArea = new JTextArea();
        textArea.setForeground(new Color(0x00FF00));
        textArea.setBackground(new Color(24, 24, 24));
        textArea.setFont(new Font("Verdena", Font.PLAIN, 15));

        pane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setBounds(5, 15, 290, 200);
        pane.setBackground(new Color(24, 24, 24));
        pane.setOpaque(true);

        enter = new JLabel("Enter");
        enter.setBounds(120, 218, 60, 20);
        enter.setBorder(new LineBorder(new Color(0x00FF00), 1));
        enter.setHorizontalAlignment(JLabel.CENTER);
        enter.setForeground(new Color(0x00FF00));
        enter.setFont(new Font("Verdena", Font.BOLD, 15));
        enter.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent evt)
            {
                try
                {
                    FileWriter writer = new FileWriter("src\\text\\text.txt", true);
                    BufferedWriter bw = new BufferedWriter(writer);
                    bw.write(textArea.getText());
                    bw.append("\n");
                    bw.append("============================================================================================================================================================================\n");
                    bw.close();
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                ((JComponent) getContentPane()).setBorder(new LineBorder(new Color(0x00FF00), 1));
                Timer timer = new Timer();
                TimerTask task = new TimerTask()
                {
                    public void run()
                    {
                        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder());
                    }
                };
                timer.schedule(task, 1000);
            }
        });

        exitlabel = new JLabel("x");
        exitlabel.setBounds(288, 0, 12, 12);
        exitlabel.setBorder(new LineBorder(new Color(0x00FF00), 1, true));
        exitlabel.setFont(new Font("Verdana", Font.BOLD, 10));
        exitlabel.setForeground(new Color(0x00FF00));
        exitlabel.setHorizontalAlignment(JLabel.CENTER);
        exitlabel.setBackground(Color.black);
        exitlabel.setOpaque(true);
        exitlabel.setVerticalAlignment(JLabel.CENTER);
        exitlabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        exitlabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) 
            {
                dispose();
            }    
        });

        add(pane);
        add(exitlabel);
        add(enter);

        setVisible(true);
    }
}
