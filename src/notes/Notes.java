package notes;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.Font;

public class Notes extends JFrame {
    
    private static final long serialVersionUID = 1L;
    DefaultTableModel model;
    JScrollPane pane;
    JTable table;

    public Notes() 
    {
        this.setTitle("God's Eye");
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);

        model = new DefaultTableModel(new String[]{"Notes"}, 0);
        

        pane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table = new JTable();
        table.setRowHeight(18);
        table.setModel(model);
        table.setFont(new Font("Verdena", Font.PLAIN, 15 ));
        
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gods_eye", "root", "9891774435");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from notes");
            while(rs.next()) {
                String data = rs.getString("notes");
                model.addRow(new Object[]{data});
            }
        } catch(Exception e) {
            System.out.println(e);
        }

        add(pane);
        pane.setViewportView(table);

        this.setVisible(true);
    }
}
