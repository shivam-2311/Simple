package text;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;

public class ReaderText extends JFrame 
{
    private static final long serialVersionUID = 1L;
    JScrollPane pane;
    JTextArea textArea;
    public ReaderText()
    {
        setTitle("God's Eye");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);

        textArea = new JTextArea();
        textArea.setBackground(new Color(24, 24, 24));
        textArea.setForeground(new Color(0x00FF00));
        textArea.setFont(new Font("Verdena", Font.BOLD, 15));

        pane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        try
        {
            FileReader reader = new FileReader("src\\text\\text.txt");
            textArea.read(reader,"src\\text\\text.txt");
            reader.close();
        }
        catch(Exception e)
        {   
            System.out.println(e);
        }

        add(pane);

        setVisible(true);
    }
}
