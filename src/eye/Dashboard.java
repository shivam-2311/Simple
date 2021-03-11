package eye;

import java.net.URL;
import time.*;
import games.*;
import notes.Notes;
import text.*;
import spec.*;
import audio.Audio;
import audio.AudioList;
import syntax.Syntax;
import anime.Anime;
import working.Work;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.border.LineBorder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Dashboard extends JFrame
{
    private static final long serialVersionUID = 1L;

    Random random = new Random();

    JTextField mainTextField;

    int xMouse, yMouse, x, y;
    String mainString;

    Dashboard(int xMousepassed, int yMousepassed, int xpassed, int ypassed)
    {       
        xMouse = xMousepassed;
        yMouse = yMousepassed;
        x = xpassed;
        y = ypassed;

        this.setLayout(null);
        this.setSize(210, 30);
        this.setUndecorated(true);
        this.setOpacity(0.85f);
        this.setAlwaysOnTop(true);
        if (xMouse == 0 && yMouse == 0 && x == 0 && y == 0)
            this.setLocationRelativeTo(null);
        else
            this.setLocation(x-xMouse, y-yMouse);
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

        mainTextField = new JTextField();
        mainTextField.setBounds(5, 5, 200, 21);
        mainTextField.setBackground(Color.BLACK);
        mainTextField.setForeground(new Color(0x00FF00));
        mainTextField.setCaretColor(new Color(0x00FF00));
        mainTextField.setFont(new Font("Verdana", Font.BOLD, 12));
        mainTextField.setBorder(new LineBorder(new Color(0x00FF00), 1, true)); 
        mainTextField.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent evt)
            {
                mainString = mainTextField.getText();
                if (evt.getKeyCode() == KeyEvent.VK_ENTER)
                {                          
                    main_functions(mainString);
                }                       
                    
            }
        });

        add(mainTextField);

        this.setVisible(true);
    }

    void main_functions(String mainString)
    {
        if (mainString.substring(0,4).compareToIgnoreCase("toss") == 0)
            Toss();
        else if (mainString.substring(0,4).compareToIgnoreCase("web ") == 0)
            web_action(mainString);
        else if (mainString.substring(0,4).compareToIgnoreCase("cal ") == 0)
            calculator(mainString.substring(4));
        else if (mainString.substring(0,4).compareToIgnoreCase("exit") == 0)
            System.exit(0);  
        else if (mainString.substring(0,4).compareToIgnoreCase("gdgu") == 0)
            gdguPortal();
        else if (mainString.substring(0,4).compareToIgnoreCase("text") == 0)
            new ReaderText();   
        else if (mainString.substring(0,5).compareToIgnoreCase("anime") == 0)
            new Anime();
        else if (mainString.substring(0, 5).compareToIgnoreCase("info ") == 0)
            infoMethod();
        else if (mainString.substring(0,5).compareToIgnoreCase("open ") == 0)
            opener(mainString);  
        else if (mainString.substring(0, 5).compareToIgnoreCase("clock") == 0)
            new Clock();
        else if (mainString.substring(0, 5).compareToIgnoreCase("notes") == 0)
            new Notes();
        else if (mainString.substring(0, 6).compareToIgnoreCase("system") == 0)
            new Specification();
        else if (mainString.substring(0, 6).compareToIgnoreCase("random") == 0)
            generateRandom();
        else if (mainString.substring(0, 6).compareToIgnoreCase("mclock") == 0)
            new Mclock();  
        else if (mainString.substring(0, 6).compareToIgnoreCase("syntax") == 0)
            new Syntax(); 
        else if (mainString.substring(0, 6).compareToIgnoreCase("music ") == 0)
            new Audio(mainString.substring(6));
        else if (mainString.substring(0, 7).compareToIgnoreCase("google ") == 0)
            searchGoogle();
        else if (mainString.substring(0, 8).compareToIgnoreCase("windows ") == 0)
            shutdownWindows();      
        else if (mainString.substring(0, 8).compareToIgnoreCase("add text") == 0)
            new WriterText();
        else if(mainString.substring(0, 8).compareToIgnoreCase("meaning ") == 0)
            wordMeaning();
        else if (mainString.substring(0,8).compareToIgnoreCase("weather ") == 0)
            weather();
        else if (mainString.substring(0, 8).compareToIgnoreCase("youtube ") == 0)
            searchYoutube();
        else if (mainString.substring(0, 9).compareToIgnoreCase("add note ") == 0)
            add_note();
        else if (mainString.substring(0, 9).compareToIgnoreCase("stopwatch") == 0)
            new Stopwatch();
        else if (mainString.substring(0, 9).compareToIgnoreCase("tictactoe") == 0)
            new Tictactoe();
        else if (mainString.substring(0, 9).compareToIgnoreCase("musiclist") == 0)
            new AudioList();
        else if (mainString.substring(0, 9).compareToIgnoreCase("customize") == 0)
            new Customize(this);
        else if (mainString.substring(0, 9).compareToIgnoreCase("synonyms ") == 0)
            synonyms();
        else if (mainString.substring(0, 9).compareToIgnoreCase("gen pass ") == 0)
            passwordGenerator(Integer.parseInt(mainString.substring(9)));
        else if (mainString.substring(0, 10).compareToIgnoreCase("deactivate") == 0)
        {
            dispose();
            new Activate(xMouse, yMouse, x, y);
        }  
        else if (mainString.substring(0, 10).compareToIgnoreCase("set timer ") == 0)
            new Timetimer(mainString);
        else if (mainString.substring(0, 11).compareToIgnoreCase("delete text") == 0)
            deleteText();
        else if (mainString.substring(0, 12).compareToIgnoreCase("delete notes") == 0)
            delete_notes();
        else if (mainString.substring(0, 12).compareToIgnoreCase("set Reminder") == 0)
            new SetReminder();
        else if (mainString.substring(0, 20).compareToIgnoreCase("explain the working?") == 0)
            new Work();
    }

    void Toss()
    {
        if (random.nextInt(2) == 0)
            mainTextField.setText("Heads");
        else
            mainTextField.setText("Tails");
    }

    void web_action(String mainString)
    {
        if (link_isValid(mainString.substring(4)))
        {
            try{
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(mainString.substring(4)));
            }
            catch(Exception e) {
                System.out.println(e);
            }    
        }
        else
        {
            if (mainString.contains("www."))
            {
                try{
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(mainString.substring(4)));
                }
                catch(Exception e) {
                    System.out.println(e);
                } 
            }
            else
            {
                if (mainString.contains("."))
                {
                    try{
                        java.awt.Desktop.getDesktop().browse(java.net.URI.create("www."+mainString.substring(4)));
                    }
                    catch(Exception e) {
                        System.out.println(e);
                    } 
                }
                else
                {
                    try{
                        java.awt.Desktop.getDesktop().browse(java.net.URI.create("www."+mainString.substring(4)+".com"));
                    }
                    catch(Exception e) {
                            System.out.println(e);
                    } 
                } 
            }
        }
    }
    
    void calculator(String mainString)
    {
        String operator[] = mainString.split("[0-9]+");
        String operand[] = mainString.split("[+-]");
        int aggregate = Integer.parseInt(operand[0]);
        for (int i = 1; i < operator.length; i ++)
        {
            if (operator[i].equals("+"))
            {
                aggregate += Integer.parseInt(operand[i]);
            } 
            else 
            {
                aggregate -= Integer.parseInt(operand[i]);
            }
        }
        mainTextField.setText("= " + aggregate);
    }

    public static boolean link_isValid(String url)
    {
        try
        {
            new URL(url).toURI();
            return true;
        }
        catch(Exception eone)
        {
            return false;
        }
    }
    
    void add_note()
    {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gods_eye", "root", "9891774435");
            PreparedStatement st = con.prepareStatement("insert into notes(Notes) values(?)");
            st.setString(1, mainString.substring(9)); 
            st.executeUpdate();
            st.close();
            con.close();
            borderLighter();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    void delete_notes()
    {
       try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gods_eye", "root", "9891774435");
            PreparedStatement st = con.prepareStatement("delete from notes");
            st.executeUpdate();
            st.close();
            con.close();
            borderLighter();  
       } catch(Exception e) {
           System.out.println(e);
       }
    }

    void deleteText()
    {
        try
        {
            FileWriter writer = new FileWriter("src\\text\\text.txt");
            writer.write("");
            writer.close();
            borderLighter();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    void opener(String mainString)
    {
        try
        {
            if (mainString.substring(5, 8).compareToIgnoreCase("cmd") == 0) //3
            {
                java.awt.Desktop.getDesktop().open(new File("src\\eye\\open\\Command Prompt.lnk"));
                borderLighter();
            }
            else if (mainString.substring(5, 8).compareToIgnoreCase("run") == 0) //3
            {
                java.awt.Desktop.getDesktop().open(new File("src\\eye\\open\\Run.lnk"));
                borderLighter();
            }
            else if (mainString.substring(5, 9).compareToIgnoreCase("file") == 0) //4
            {
                java.awt.Desktop.getDesktop().open(new File("src\\eye\\open\\File Explorer.lnk"));
                borderLighter();
            }
            else if (mainString.substring(5, 10).compareToIgnoreCase("my pc") == 0) //5
            {
                java.awt.Desktop.getDesktop().open(new File("src\\eye\\open\\computer.lnk"));
                borderLighter();
            }
            else if (mainString.substring(5, 10).compareToIgnoreCase("paint") == 0) //5
            {
                java.awt.Desktop.getDesktop().open(new File("src\\eye\\open\\Paint.lnk"));
                borderLighter();
            }
            else if (mainString.substring(5, 10).compareToIgnoreCase("mysql") == 0) //5
            {
                java.awt.Desktop.getDesktop().open(new File("src\\eye\\open\\MySQL 8.0 Command Line Client.lnk"));
                borderLighter();
            }
            else if (mainString.substring(5, 12).compareToIgnoreCase("discord") == 0) //7
            {
                java.awt.Desktop.getDesktop().open(new File("src\\eye\\open\\Discord.lnk"));
                borderLighter();
            }
            else if (mainString.substring(5, 12).compareToIgnoreCase("mongoDB") == 0) //7
            {
                java.awt.Desktop.getDesktop().open(new File("src\\eye\\open\\mongo - Shortcut.lnk"));
                borderLighter();
            }
            else if (mainString.substring(5, 13).compareToIgnoreCase("audacity") == 0) //8
            {
                java.awt.Desktop.getDesktop().open(new File("src\\eye\\open\\Audacity.lnk"));
                borderLighter();
            }
            else if (mainString.substring(5, 13).compareToIgnoreCase("netbeans") == 0) //8
            {
                java.awt.Desktop.getDesktop().open(new File("src\\eye\\open\\Apache NetBeans IDE 12.0.lnk"));
                borderLighter();
            }  
            else if (mainString.substring(5, 16).compareToIgnoreCase("eclipse jee") == 0) //11
            {
                java.awt.Desktop.getDesktop().open(new File("src\\eye\\open\\Eclipse JEE.lnk"));
                borderLighter();
            }
            else if (mainString.substring(5, 16).compareToIgnoreCase("eclipse dev") == 0) //11
            {
                java.awt.Desktop.getDesktop().open(new File("src\\eye\\open\\Apache NetBeans IDE 12.0.lnk"));
                borderLighter();
            }
            else if (mainString.substring(5, 18).compareToIgnoreCase("control panel") == 0) //13
            {
                java.awt.Desktop.getDesktop().open(new File("src\\eye\\open\\Control Panel.lnk"));
                borderLighter();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void gdguPortal()
    {
        try
        {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://gd.servergi.com:8089/ISIMGDGU/Login?ReturnUrl=%2fISIMGDGU%2fHome"));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void passwordGenerator(int n)
    {
        String password = "";
        for (int i = 0; i < n; i ++)
        {
            int ascii = random.nextInt(62);
            if (ascii <= 9)
                password = password + (char)(ascii+48);
            else if (ascii <= 35)
                password = password + (char)(ascii+55);
            else
                password = password + (char)(ascii+61);
        }
        mainTextField.setText(password);
    }

    void searchYoutube()
    {
        try
        {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.youtube.com/results?search_query="+URIConvertor(mainString.substring(8))));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void searchGoogle()
    {
        try
        {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.google.com/search?q="+URIConvertor(mainString.substring(7))));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void borderLighter()
    {
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

    String URIConvertor(String URI)
    {
        URI = URI.replace("+", "%2B");
        URI = URI.replace(' ', '+');
        return URI;
    }

    void shutdownWindows() 
    {
        try
        {
            if (mainString.substring(8, 12).compareToIgnoreCase("lock") == 0)
                Runtime.getRuntime().exec("Rundll32.exe user32.dll,LockWorkStation");
            else if (mainString.substring(8, 13).compareToIgnoreCase("sleep") == 0)
                Runtime.getRuntime().exec("Rundll32.exe powrprof.dll,SetSuspendState Sleep");
            else if(mainString.substring(8, 15).compareToIgnoreCase("restart") == 0)
                Runtime.getRuntime().exec("Shutdown.exe -r -t 00");
            else if(mainString.substring(8, 16).compareToIgnoreCase("shutdown") == 0)
                Runtime.getRuntime().exec("Shutdown.exe -s -t 00");

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void generateRandom() {
        String randomArray[] = mainString.substring(7).split(" ");
        int x = random.nextInt(randomArray.length);
        mainTextField.setText(randomArray[x]);
    }

    void wordMeaning() {
        String word = mainString.substring(8);
        try {
            Document document = Jsoup.connect("https://dictionary.cambridge.org/dictionary/english/" + word).get();
            Elements elements = document.getElementsByClass("ddef_h");
            Element element = elements.first();
            mainTextField.setText(element.text());
            mainTextField.setCaretPosition(0);
        }
        catch(Exception e) {
            mainTextField.setText("Error");
        }
    }

    void weather() {
        try {
            String location = mainString.substring(8);
            Document document = Jsoup.connect("https://www.timeanddate.com/weather/india/" + location).get();
            Elements elements = document.getElementsByClass("bk-focus__qlook");
            String data = elements.text();
            String arr[] = data.split("\\.");
            mainTextField.setText(arr[0]);
        }
        catch(Exception e) {
            mainTextField.setText("Error");
        }
    }

    void synonyms() {
        String word = mainString.substring(9);
        try {
            Document doc = Jsoup.connect("https://www.thesaurus.com/browse/" + word).get();
            Element element = doc.getElementById("meanings");
            Elements elements = element.getElementsByTag("li");
            String data[] = elements.text().split(" ");
            String finalData = "";
            for (int  i = 0; i < 8; i ++) {
                if (i < 7)
                    finalData = finalData + data[i] + ", ";
                else
                    finalData = finalData + data[i] + ".";
            } 
            mainTextField.setText(finalData);
        } catch(Exception e) {
            mainTextField.setText("Error");
        }
    }

    void infoMethod() {
        try {
            Document document = Jsoup.connect("https://www.google.com/search?q=" + URIConvertor(mainString.substring(5))).get();
            Element search = document.getElementById("search");
            Elements links = search.select("a[href]");
            String element = links.attr("href");
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(element));
        } catch(Exception e) {
            mainTextField.setText("Error");
        }
    }
}