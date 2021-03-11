package audio;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class AudioList extends JFrame
{
    private static final long serialVersionUID = 1L;
    JLabel exitLabel;
    DefaultTableModel model;
    JTable table;
    JScrollPane pane;

    int xMouse, yMouse, x, y;

    public AudioList()
    {
        setSize(400, 150);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.black);
        addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent evt)
            {
                xMouse = evt.getX();
                yMouse = evt.getY();
            }
        });
        addMouseMotionListener(new MouseInputAdapter()
        {
            public void mouseDragged(MouseEvent evt)
            {
                x = evt.getXOnScreen();
                y = evt.getYOnScreen();
                setLocation(x-xMouse, y-yMouse);
            }
        });

        exitLabel = new JLabel("x");
        exitLabel.setBounds(388, 0, 12, 12);
        exitLabel.setOpaque(true);
        exitLabel.setHorizontalAlignment(JLabel.CENTER);
        exitLabel.setBackground(Color.black);
        exitLabel.setForeground(Color.green);
        exitLabel.addMouseListener(new MouseInputAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                dispose();
            }
        });

        model = new DefaultTableModel(new String[]{"Music", "Abbreviation"}, 0);

        table = new JTable();
        table.setModel(model);
        table.setFont(new Font("Verdena", Font.PLAIN, 14));
        table.setRowHeight(18);

        pane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setBounds(15, 15, 370, 120);

        try
        {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gods_eye", "root", "9891774435");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select *from audiolist order by music desc");
            while(rs.next())
            {
                String music = rs.getString("music");
                String Abbreviation = rs.getString("abbreviation");   
                model.addRow(new Object[]{music, Abbreviation});
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        add(exitLabel);
        add(pane);

        setVisible(true);
    }

    public static void main(String args[])
    {
        new AudioList();
    }
}
