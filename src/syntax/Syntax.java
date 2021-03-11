package syntax;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Syntax extends JFrame
{
    private static final long serialVersionUID = 1L;
    DefaultTableModel model;
    JScrollPane pane;
    JTable table;

    public Syntax()
    {   
        setTitle("Syntax");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        model = new DefaultTableModel(new String[]{"Related", "Example"}, 0);

        pane = new JScrollPane( ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table = new JTable();
        table.setRowHeight(18);
        table.setModel(model);

        try
        {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gods_eye", "root", "9891774435");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select *from syntax order by related desc");

            while(rs.next())
            {
                String Related = rs.getString(1);
                String Example = rs.getString(2);
                model.addRow(new Object[]{Related, Example});
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        add(pane);
        pane.setViewportView(table);

        setVisible(true);
    }
}
