package spec;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.InetAddress;

import javax.swing.border.LineBorder;

public class Specification extends JFrame
{
    private static final long serialVersionUID = 1L;
    int xMouse, yMouse, x, y;

    InetAddress ip;

    JLabel exitLabel;
    JLabel osName;
    JLabel processorName;
    JLabel processorCore;

    JLabel hostName;
    JLabel hostAddress;

    JLabel cDrive;
    JLabel cTotalSpace;
    JLabel cOccupiedSpace;
    JLabel cUsableSpace;

    JLabel dDrive;
    JLabel dTotalSpace;
    JLabel dOccupiedSpace;
    JLabel dUsableSpace;

    public Specification()
    {
        this.setSize(480, 300);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.black);
        this.setLayout(null);
        ((JComponent) this.getContentPane()).setBorder(new LineBorder(new Color(0x00FF00), 1, true));
        this.setUndecorated(true);
        this.setOpacity(0.85f);
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

        exitLabel = new JLabel("x");
        exitLabel.setBounds(468, 0, 12, 12);
        exitLabel.setBorder(new LineBorder(new Color(0x00FF00), 1, true));
        exitLabel.setFont(new Font("Verdana", Font.BOLD, 10));
        exitLabel.setForeground(new Color(0x00FF00));
        exitLabel.setHorizontalAlignment(JLabel.CENTER);
        exitLabel.setVerticalAlignment(JLabel.CENTER);
        exitLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) 
            {
                dispose();
            }    
        });

        osName = new JLabel("OS: " + System.getProperty("os.name"));
        osName.setBounds(10, 10, 480, 15);
        osName.setFont(new Font("Verdana", Font.BOLD, 12));
        osName.setForeground(Color.green);

        processorName = new JLabel("Processor: " + System.getenv("PROCESSOR_IDENTIFIER"));
        processorName.setBounds(10, 30, 480, 15);
        processorName.setFont(new Font("Verdana", Font.BOLD, 12));
        processorName.setForeground(Color.green);

        processorCore = new JLabel("Core: " + System.getenv("NUMBER_OF_PROCESSORS") + " core");
        processorCore.setBounds(10, 50, 480, 15);
        processorCore.setFont(new Font("Verdana", Font.BOLD, 12));
        processorCore.setForeground(Color.green);

        try
        {
            ip = InetAddress.getLocalHost();

            hostName = new JLabel("Host Name: " + ip.getHostName());
            hostName.setBounds(10, 80, 480, 15);
            hostName.setFont(new Font("Verdana", Font.BOLD, 12));
            hostName.setForeground(Color.green);

            hostAddress = new JLabel("Host Address: " + ip.getHostAddress());
            hostAddress.setBounds(10, 100, 480, 15);
            hostAddress.setFont(new Font("Verdana", Font.BOLD, 12));
            hostAddress.setForeground(Color.green);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        File cFile = new File("C:\\");

        double cTotalSize = cFile.getTotalSpace() / (1024*1024*1024);
        double cUsableSize = cFile.getUsableSpace() / (1024*1024*1024);
        double cOccupiedSize = cTotalSize-cUsableSize;

        cDrive = new JLabel("<HTML><u>C Drive:</u></HTML>");
        cDrive.setBounds(10, 130, 480, 15);
        cDrive.setFont(new Font("Verdana", Font.BOLD, 12));
        cDrive.setForeground(Color.green);

        cTotalSpace = new JLabel("Total: " + String.format("%.0f ", cTotalSize) + " GB");
        cTotalSpace.setBounds(10, 150, 480, 15);
        cTotalSpace.setFont(new Font("Verdana", Font.BOLD, 12));
        cTotalSpace.setForeground(Color.green);

        cOccupiedSpace = new JLabel("Occupied: " + String.format("%.0f", cOccupiedSize) + " GB");
        cOccupiedSpace.setBounds(10, 170, 480, 15);
        cOccupiedSpace.setFont(new Font("Verdana", Font.BOLD, 12));
        cOccupiedSpace.setForeground(Color.green);
        
        cUsableSpace = new JLabel("Free: " + String.format("%.0f ", cUsableSize) + " GB");
        cUsableSpace.setBounds(10, 190, 480, 15);
        cUsableSpace.setFont(new Font("Verdana", Font.BOLD, 12));
        cUsableSpace.setForeground(Color.green);

        File dFile = new File("D:\\");

        dDrive = new JLabel("<HTML><u>D Drive:</HTML></u>");
        dDrive.setBounds(10, 220, 480, 15);
        dDrive.setFont(new Font("Verdana", Font.BOLD, 12));
        dDrive.setForeground(Color.green);
       

        double dTotalSize = dFile.getTotalSpace() / (1024*1024*1024);
        double dUsableSize = dFile.getUsableSpace() / (1024*1024*1024);
        double dOccupiedSize = dTotalSize-dUsableSize;

        dTotalSpace = new JLabel("Total: " + String.format("%.0f ", dTotalSize) + " GB");
        dTotalSpace.setBounds(10, 240, 480, 15);
        dTotalSpace.setFont(new Font("Verdana", Font.BOLD, 12));
        dTotalSpace.setForeground(Color.green);

        dOccupiedSpace = new JLabel("Occupied: " + String.format("%.0f", dOccupiedSize) + " GB");
        dOccupiedSpace.setBounds(10, 260, 480, 15);
        dOccupiedSpace.setFont(new Font("Verdana", Font.BOLD, 12));
        dOccupiedSpace.setForeground(Color.green);
        
        dUsableSpace = new JLabel("Free: " + String.format("%.0f ", dUsableSize) + " GB");
        dUsableSpace.setBounds(10, 280, 480, 15);
        dUsableSpace.setFont(new Font("Verdana", Font.BOLD, 12));
        dUsableSpace.setForeground(Color.green);
        

        add(exitLabel);
        add(osName);
        add(processorName);
        add(processorCore);
        add(hostName);
        add(hostAddress);

        add(cDrive);
        add(cTotalSpace);
        add(cOccupiedSpace);
        add(cUsableSpace);

        add(dDrive);
        add(dTotalSpace);
        add(dOccupiedSpace);
        add(dUsableSpace);

        setVisible(true);
    }

    public static void main(String args[])
    {
        new Specification();
    }    
}
