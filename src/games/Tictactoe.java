package games;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Tictactoe extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    Random random = new Random();
    JPanel labelPanel;
    JPanel buttonPanel;
    JLabel label;
    JLabel exitlabel;
    JButton[] button = new JButton[9];
    Boolean xTurn;
    int xMouse, yMouse, x, y;

    public Tictactoe() 
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250, 250);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setUndecorated(true);
        this.setOpacity(0.85f);
        this.setAlwaysOnTop(true);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                xMouse = evt.getX();
                yMouse = evt.getY();
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                x = evt.getXOnScreen();
                y = evt.getYOnScreen();
                setLocation(x - xMouse, y - yMouse);
            }
        });

        labelPanel = new JPanel();
        labelPanel.setBackground(Color.BLACK);
        labelPanel.setLayout(new BorderLayout());
        labelPanel.setBorder(new LineBorder(new Color(0x00FF00), 1, true));

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(0x00FF00));

        exitlabel = new JLabel("x");
        exitlabel.setFont(new Font("Verdana", Font.BOLD, 12));
        exitlabel.setForeground(new Color(0x00FF00));
        exitlabel.setVerticalAlignment(JLabel.TOP);
        exitlabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });

        label = new JLabel();
        label.setFont(new Font("Verdena", Font.BOLD, 25));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(new Color(0x00FF00));

        for (int i = 0; i < 9; i++) {
            button[i] = new JButton();
            button[i].setBackground(Color.BLACK);
            button[i].setFont(new Font("Verdena", Font.BOLD, 35));
            button[i].setForeground(new Color(0x00FF00));
            button[i].setBorder(new LineBorder(new Color(0x00FF00), 1, true));
            button[i].addActionListener(this);
            buttonPanel.add(button[i]);
        }

        add(buttonPanel);
        labelPanel.add(exitlabel, BorderLayout.EAST);
        labelPanel.add(label);
        add(labelPanel, BorderLayout.NORTH);

        setVisible(true);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        for (int i = 0; i < 9; i++) {
            if (evt.getSource() == button[i]) 
            {
                if (button[i].getText().equals("")) 
                {
                    if (xTurn) 
                    {
                        button[i].setText("X");
                        label.setText("O Turn");
                        xTurn = false;
                        check();
                    } 
                    else
                    {
                        button[i].setText("O");
                        label.setText("X Turn");
                        xTurn = true;
                        check();
                    }
                }
            }
        }
    }

    void firstTurn() {
        if (random.nextInt(2) == 0)
        {
            label.setText("X Turn");
            xTurn = true;
        }
        else
        {
        label.setText("O Turn");
        xTurn = false;
        }
    }

    void check()
    {
        if (button[0].getText().equals("O") && button[1].getText().equals("O") && button[2].getText().equals("O"))
        {
            oWins(0, 1, 2);
        }
        if (button[3].getText().equals("O") && button[4].getText().equals("O") && button[5].getText().equals("O"))
        {
            oWins(3, 4, 5);
        }
        if (button[6].getText().equals("O") && button[7].getText().equals("O") && button[8].getText().equals("O"))
        {
            oWins(6, 7, 8);
        }
        if (button[0].getText().equals("O") && button[3].getText().equals("O") && button[6].getText().equals("O"))
        {
            oWins(0, 3, 6);
        }
        if (button[1].getText().equals("O") && button[4].getText().equals("O") && button[7].getText().equals("O"))
        {
            oWins(1, 4, 7);
        }
        if (button[2].getText().equals("O") && button[5].getText().equals("O") && button[8].getText().equals("O"))
        {
            oWins(2, 5, 8);
        }
        if (button[0].getText().equals("O") && button[4].getText().equals("O") && button[8].getText().equals("O"))
        {
            oWins(0, 4, 8);
        }
        if (button[2].getText().equals("O") && button[4].getText().equals("O") && button[6].getText().equals("O"))
        {
            oWins(2, 4, 6);
        }


        if (button[0].getText().equals("X") && button[1].getText().equals("X") && button[2].getText().equals("X"))
        {
            xWins(0, 1, 2);
        }
        if (button[3].getText().equals("X") && button[4].getText().equals("X") && button[5].getText().equals("X"))
        {
            xWins(3, 4, 5);
        }
        if (button[6].getText().equals("X") && button[7].getText().equals("X") && button[8].getText().equals("X"))
        {
            xWins(6, 7, 8);
        }
        if (button[0].getText().equals("X") && button[3].getText().equals("X") && button[6].getText().equals("X"))
        {
            xWins(0, 3, 6);
        }
        if (button[1].getText().equals("X") && button[4].getText().equals("X") && button[7].getText().equals("X"))
        {
            xWins(1, 4, 7);
        }
        if (button[2].getText().equals("X") && button[5].getText().equals("X") && button[8].getText().equals("X"))
        {
            xWins(2, 5, 8);
        }
        if (button[0].getText().equals("X") && button[4].getText().equals("X") && button[8].getText().equals("X"))
        {
            xWins(0, 4, 8);
        }
        if (button[2].getText().equals("X") && button[4].getText().equals("X") && button[6].getText().equals("X"))
        {
            xWins(2, 4, 6);
        }
    }

    void xWins(int a, int b, int c)
    {
        button[a].setBackground(Color.green);
        button[b].setBackground(Color.green);
        button[c].setBackground(Color.green);

        for (int i = 0; i < 9; i ++)
        {
            button[i].setEnabled(false);
        }

        label.setText("X Wins");
    }

    void oWins(int a, int b, int c)
    {
        button[a].setBackground(Color.green);
        button[b].setBackground(Color.green);
        button[c].setBackground(Color.green);

        for (int i = 0; i < 9; i ++)
        {
            button[i].setEnabled(false);
        }
        label.setText("O Wins");
    }

    public static void main(String args[])
    {
        new Tictactoe();
    }
}