package eye;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class Customize extends JFrame {
    private static final long serialVersionUID = 1L;

    Dashboard dashboard;

    int xMouse, yMouse, x, y;

    JLabel exitLabel;

    JLabel backLabHead;
    JLabel backLabRed;
    JLabel backLabGreen;
    JLabel backLabBlue;
    JTextField backTextRed;
    JTextField backTextGreen;
    JTextField backTextBlue;

    JLabel foreLabHead;
    JLabel foreLabRed;
    JLabel foreLabGreen;
    JLabel foreLabBlue;
    JTextField foreTextRed;
    JTextField foreTextGreen;
    JTextField foreTextBlue;

    JLabel bordLabHead;
    JLabel bordLabRed;
    JLabel bordLabGreen;
    JLabel bordLabBlue;
    JTextField bordTextRed;
    JTextField bordTextGreen;
    JTextField bordTextBlue;

    JLabel slidLab;
    JSlider slider;

    JLabel fontLab;
    JTextField fontText;

    JLabel styleLab;
    JRadioButton plainButton;
    JRadioButton boldButton;

    JLabel sizeLab;
    JTextField sizeText;

    JLabel regeLab;
    JSlider regeSlidLength;
    JSlider regeSlidBreadth;

    JLabel caretLabHead;
    JLabel caretLabRed;
    JLabel caretLabGreen;
    JLabel caretLabBlue;
    JTextField caretTextRed;
    JTextField caretTextGreen;
    JTextField caretTextBlue;

    Customize(Dashboard dashboard) {
        this.dashboard = dashboard;

        setSize(480, 400);
        setUndecorated(true);
        setOpacity(0.85f);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.black);
        ((JComponent) getContentPane()).setBorder(new LineBorder(new Color(0x00FF00), 1));
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                xMouse = evt.getX();
                yMouse = evt.getY();
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent evt) {
                x = evt.getXOnScreen();
                y = evt.getYOnScreen();
                setLocation(x - xMouse, y - yMouse);
            }
        });

        exitLabel = new JLabel("x");
        exitLabel.setBounds(468, 0, 12, 12);
        exitLabel.setBorder(new LineBorder(new Color(0x00FF00), 1, true));
        exitLabel.setFont(new Font("Verdana", Font.BOLD, 10));
        exitLabel.setForeground(new Color(0x00FF00));
        exitLabel.setHorizontalAlignment(JLabel.CENTER);
        exitLabel.setVerticalAlignment(JLabel.CENTER);
        exitLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        exitLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });

        add(exitLabel);

        background();
        foreground();
        border();
        dashOpacity();
        dashFont();
        dashStyle();
        dashSize();
        resizeGodsEye();
        caretColor();

        setVisible(true);
    }

    void background() {
        backLabHead = new JLabel("Background");
        backLabHead.setBounds(10, 10, 105, 30);
        backLabHead.setOpaque(true);
        backLabHead.setFont(new Font("Verdena", Font.BOLD, 15));
        backLabHead.setBackground(Color.black);
        backLabHead.setForeground(new Color(0x00FF00));
        backLabHead.setBorder(new LineBorder(new Color(0x00FF00), 1));
        backLabHead.setHorizontalAlignment(JLabel.CENTER);
        backLabHead.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                String backTextRedString = backTextRed.getText();
                String backTextGreenString = backTextGreen.getText();
                String backTextBlueString = backTextBlue.getText();

                int backTextRedInt = Integer.parseInt(backTextRedString);
                int backTextGreenInt = Integer.parseInt(backTextGreenString);
                int backTextBlueInt = Integer.parseInt(backTextBlueString);

                dashboard.getContentPane().setBackground(new Color(backTextRedInt, backTextGreenInt, backTextBlueInt));
                dashboard.mainTextField.setBackground(new Color(backTextRedInt, backTextGreenInt, backTextBlueInt));
            }
        });
        backLabHead.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                backLabHead.setForeground(Color.WHITE);
                backLabHead.setBackground(new Color(0x00FF00));
            }
        });
        backLabHead.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                backLabHead.setForeground(new Color(0x00FF00));
                backLabHead.setBackground(Color.black);
            }
        });

        backLabRed = new JLabel("Red :");
        backLabRed.setBounds(10, 50, 50, 20);
        backLabRed.setFont(new Font("Verdena", Font.BOLD, 12));
        backLabRed.setForeground(new Color(0x00FF00));

        backLabGreen = new JLabel("Green :");
        backLabGreen.setBounds(10, 75, 50, 20);
        backLabGreen.setFont(new Font("Verdena", Font.BOLD, 12));
        backLabGreen.setForeground(new Color(0x00FF00));

        backLabBlue = new JLabel("Blue :");
        backLabBlue.setBounds(10, 100, 50, 20);
        backLabBlue.setFont(new Font("Verdena", Font.BOLD, 12));
        backLabBlue.setForeground(new Color(0x00FF00));

        backTextRed = new JTextField();
        backTextRed.setBounds(65, 50, 50, 20);
        backTextRed.setCaretColor(new Color(0x00FF00));
        backTextRed.setBackground(Color.black);
        backTextRed.setForeground(new Color(0x00FF00));
        backTextRed.setFont(new Font("Verdena", Font.BOLD, 12));
        backTextRed.setBorder(new LineBorder(new Color(0x00FF00), 1));

        backTextGreen = new JTextField();
        backTextGreen.setBounds(65, 75, 50, 20);
        backTextGreen.setCaretColor(new Color(0x00FF00));
        backTextGreen.setBackground(Color.black);
        backTextGreen.setForeground(new Color(0x00FF00));
        backTextGreen.setFont(new Font("Verdena", Font.BOLD, 12));
        backTextGreen.setBorder(new LineBorder(new Color(0x00FF00), 1));

        backTextBlue = new JTextField();
        backTextBlue.setBounds(65, 100, 50, 20);
        backTextBlue.setCaretColor(new Color(0x00FF00));
        backTextBlue.setBackground(Color.black);
        backTextBlue.setForeground(new Color(0x00FF00));
        backTextBlue.setFont(new Font("Verdena", Font.BOLD, 12));
        backTextBlue.setBorder(new LineBorder(new Color(0x00FF00), 1));

        add(backLabHead);
        add(backLabRed);
        add(backLabBlue);
        add(backLabGreen);
        add(backTextRed);
        add(backTextGreen);
        add(backTextBlue);
    }

    void foreground() {
        foreLabHead = new JLabel("Foreground");
        foreLabHead.setBounds(125, 10, 105, 30);
        foreLabHead.setOpaque(true);
        foreLabHead.setFont(new Font("Verdena", Font.BOLD, 15));
        foreLabHead.setBackground(Color.black);
        foreLabHead.setForeground(new Color(0x00FF00));
        foreLabHead.setBorder(new LineBorder(new Color(0x00FF00), 1));
        foreLabHead.setHorizontalAlignment(JLabel.CENTER);
        foreLabHead.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent evt) 
            {
                String foreTextRedString = foreTextRed.getText();
                String foreTextGreenString = foreTextGreen.getText();
                String foreTextBlueString = foreTextBlue.getText();

                int foreTextRedInt = Integer.parseInt(foreTextRedString);
                int foreTextGreenInt = Integer.parseInt(foreTextGreenString);
                int foreTextBlueInt = Integer.parseInt(foreTextBlueString);

                dashboard.mainTextField.setForeground(new Color(foreTextRedInt, foreTextGreenInt, foreTextBlueInt));
            }
        });
        foreLabHead.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                foreLabHead.setForeground(Color.WHITE);
                foreLabHead.setBackground(new Color(0x00FF00));
            }
        });
        foreLabHead.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                foreLabHead.setForeground(new Color(0x00FF00));
                foreLabHead.setBackground(Color.black);
            }
        });

        foreLabRed = new JLabel("Red :");
        foreLabRed.setBounds(125, 50, 50, 20);
        foreLabRed.setFont(new Font("Verdena", Font.BOLD, 12));
        foreLabRed.setForeground(new Color(0x00FF00));

        foreLabGreen = new JLabel("Green :");
        foreLabGreen.setBounds(125, 75, 50, 20);
        foreLabGreen.setFont(new Font("Verdena", Font.BOLD, 12));
        foreLabGreen.setForeground(new Color(0x00FF00));

        foreLabBlue = new JLabel("Blue :");
        foreLabBlue.setBounds(125, 100, 50, 20);
        foreLabBlue.setFont(new Font("Verdena", Font.BOLD, 12));
        foreLabBlue.setForeground(new Color(0x00FF00));

        foreTextRed = new JTextField();
        foreTextRed.setBounds(180, 50, 50, 20);
        foreTextRed.setCaretColor(new Color(0x00FF00));
        foreTextRed.setBackground(Color.black);
        foreTextRed.setForeground(new Color(0x00FF00));
        foreTextRed.setFont(new Font("Verdena", Font.BOLD, 12));
        foreTextRed.setBorder(new LineBorder(new Color(0x00FF00), 1));

        foreTextGreen = new JTextField();
        foreTextGreen.setBounds(180, 75, 50, 20);
        foreTextGreen.setCaretColor(new Color(0x00FF00));
        foreTextGreen.setBackground(Color.black);
        foreTextGreen.setForeground(new Color(0x00FF00));
        foreTextGreen.setFont(new Font("Verdena", Font.BOLD, 12));
        foreTextGreen.setBorder(new LineBorder(new Color(0x00FF00), 1));

        foreTextBlue = new JTextField();
        foreTextBlue.setBounds(180, 100, 50, 20);
        foreTextBlue.setCaretColor(new Color(0x00FF00));
        foreTextBlue.setBackground(Color.black);
        foreTextBlue.setForeground(new Color(0x00FF00));
        foreTextBlue.setFont(new Font("Verdena", Font.BOLD, 12));
        foreTextBlue.setBorder(new LineBorder(new Color(0x00FF00), 1));

        add(foreLabHead);
        add(foreLabRed);
        add(foreLabBlue);
        add(foreLabGreen);
        add(foreTextRed);
        add(foreTextGreen);
        add(foreTextBlue);
    }

    void border() 
    {
        bordLabHead = new JLabel("Border");
        bordLabHead.setBounds(240, 10, 105, 30);
        bordLabHead.setOpaque(true);
        bordLabHead.setFont(new Font("Verdena", Font.BOLD, 15));
        bordLabHead.setBackground(Color.black);
        bordLabHead.setForeground(new Color(0x00FF00));
        bordLabHead.setBorder(new LineBorder(new Color(0x00FF00), 1));
        bordLabHead.setHorizontalAlignment(JLabel.CENTER);
        bordLabHead.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                String bordTextRedString = bordTextRed.getText();
                String bordTextGreenString = bordTextGreen.getText();
                String bordTextBlueString = bordTextBlue.getText();

                int bordTextRedInt = Integer.parseInt(bordTextRedString);
                int bordTextGreenInt = Integer.parseInt(bordTextGreenString);
                int bordTextBlueInt = Integer.parseInt(bordTextBlueString);

                dashboard.mainTextField
                        .setBorder(new LineBorder(new Color(bordTextRedInt, bordTextGreenInt, bordTextBlueInt), 1));
            }
        });
        bordLabHead.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                bordLabHead.setForeground(Color.WHITE);
                bordLabHead.setBackground(new Color(0x00FF00));
            }
        });
        bordLabHead.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                bordLabHead.setForeground(new Color(0x00FF00));
                bordLabHead.setBackground(Color.black);
            }
        });

        bordLabRed = new JLabel("Red :");
        bordLabRed.setBounds(240, 50, 50, 20);
        bordLabRed.setFont(new Font("Verdena", Font.BOLD, 12));
        bordLabRed.setForeground(new Color(0x00FF00));

        bordLabGreen = new JLabel("Green :");
        bordLabGreen.setBounds(240, 75, 50, 20);
        bordLabGreen.setFont(new Font("Verdena", Font.BOLD, 12));
        bordLabGreen.setForeground(new Color(0x00FF00));

        bordLabBlue = new JLabel("Blue :");
        bordLabBlue.setBounds(240, 100, 50, 20);
        bordLabBlue.setFont(new Font("Verdena", Font.BOLD, 12));
        bordLabBlue.setForeground(new Color(0x00FF00));

        bordTextRed = new JTextField();
        bordTextRed.setBounds(295, 50, 50, 20);
        bordTextRed.setCaretColor(new Color(0x00FF00));
        bordTextRed.setBackground(Color.black);
        bordTextRed.setForeground(new Color(0x00FF00));
        bordTextRed.setFont(new Font("Verdena", Font.BOLD, 12));
        bordTextRed.setBorder(new LineBorder(new Color(0x00FF00), 1));

        bordTextGreen = new JTextField();
        bordTextGreen.setBounds(295, 75, 50, 20);
        bordTextGreen.setCaretColor(new Color(0x00FF00));
        bordTextGreen.setBackground(Color.black);
        bordTextGreen.setForeground(new Color(0x00FF00));
        bordTextGreen.setFont(new Font("Verdena", Font.BOLD, 12));
        bordTextGreen.setBorder(new LineBorder(new Color(0x00FF00), 1));

        bordTextBlue = new JTextField();
        bordTextBlue.setBounds(295, 100, 50, 20);
        bordTextBlue.setCaretColor(new Color(0x00FF00));
        bordTextBlue.setBackground(Color.black);
        bordTextBlue.setForeground(new Color(0x00FF00));
        bordTextBlue.setFont(new Font("Verdena", Font.BOLD, 12));
        bordTextBlue.setBorder(new LineBorder(new Color(0x00FF00), 1));

        add(bordLabHead);
        add(bordLabRed);
        add(bordLabBlue);
        add(bordLabGreen);
        add(bordTextRed);
        add(bordTextGreen);
        add(bordTextBlue);
    }

    void dashOpacity() 
    {
        float a = dashboard.getOpacity() * 100;
        int b = (int)a;

        slidLab = new JLabel("Opacity: " + b + "%");
        slidLab.setBounds(168, 135, 115, 30);
        slidLab.setOpaque(true);
        slidLab.setFont(new Font("Verdena", Font.BOLD, 15));
        slidLab.setBackground(Color.black);
        slidLab.setForeground(new Color(0x00FF00));
        slidLab.setBorder(new LineBorder(new Color(0x00FF00), 1));
        slidLab.setHorizontalAlignment(JLabel.CENTER);

        slider = new JSlider(0, 100, b);
        slider.setSize(400, 30);
        slider.setLocation(40, 175);
        slider.setBackground(Color.black);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(10);
        slider.setForeground(new Color(0x00FF00));
        slider.addChangeListener(new ChangeListener() 
        {
            @Override
            public void stateChanged(ChangeEvent e) 
            {
                float n = slider.getValue();
                slidLab.setText("Opacity: " + String.format("%.0f", n) + "%");
                n = n/100;
                dashboard.setOpacity(n);
            }  
        });

        add(slidLab);
        add(slider);
    }

    void dashFont()
    {
        fontLab = new JLabel("Font :");
        fontLab.setBounds(10, 220, 50, 20);
        fontLab.setOpaque(true);
        fontLab.setFont(new Font("Verdena", Font.BOLD, 15));
        fontLab.setBackground(Color.black);
        fontLab.setForeground(new Color(0x00FF00));
        fontLab.setBorder(new LineBorder(new Color(0x00FF00), 1));
        fontLab.setHorizontalAlignment(JLabel.CENTER);
        fontLab.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) 
            {
                String fontName = fontText.getText();
                int fontStyle = dashboard.mainTextField.getFont().getStyle();
                int fontSize = dashboard.mainTextField.getFont().getSize();
                dashboard.mainTextField.setFont(new Font(fontName, fontStyle, fontSize)); 
            }
        });
        fontLab.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered(MouseEvent evt) 
            {
                fontLab.setForeground(Color.WHITE);
                fontLab.setBackground(new Color(0x00FF00));
            }
        });
        fontLab.addMouseListener(new MouseAdapter() 
        {
            public void mouseExited(MouseEvent evt) 
            {
                fontLab.setForeground(new Color(0x00FF00));
                fontLab.setBackground(Color.black);
            }
        });

        fontText = new JTextField(dashboard.mainTextField.getFont().getFamily());
        fontText.setBounds(65, 220, 100, 20);
        fontText.setCaretColor(new Color(0x00FF00));
        fontText.setBackground(Color.black);
        fontText.setBorder(new LineBorder(new Color(0x00FF00), 1));
        fontText.setFont(new Font("Verdena", Font.BOLD, 12));
        fontText.setForeground(new Color(0x00FF00));

        add(fontLab);
        add(fontText);
    }

    void dashStyle()
    {
        styleLab = new JLabel("Style :");
        styleLab.setBounds(275, 220, 60, 20);
        styleLab.setOpaque(true);
        styleLab.setFont(new Font("Verdena", Font.BOLD, 15));
        styleLab.setBackground(Color.black);
        styleLab.setForeground(new Color(0x00FF00));
        styleLab.setBorder(new LineBorder(new Color(0x00FF00), 1));
        styleLab.setHorizontalAlignment(JLabel.CENTER);
        styleLab.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent evt) 
            {
                if (plainButton.isSelected())
                {
                    Font font = dashboard.mainTextField.getFont().deriveFont(0);
                    dashboard.mainTextField.setFont(font);
                }
                if (boldButton.isSelected())
                {
                    Font font = dashboard.mainTextField.getFont().deriveFont(1);
                    dashboard.mainTextField.setFont(font);
                }
            }
        });
        styleLab.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered(MouseEvent evt) 
            {
                styleLab.setForeground(Color.WHITE);
                styleLab.setBackground(new Color(0x00FF00));
            }
        });
        styleLab.addMouseListener(new MouseAdapter() 
        {
            public void mouseExited(MouseEvent evt) 
            {
                styleLab.setForeground(new Color(0x00FF00));
                styleLab.setBackground(Color.black);
            }
        });

        plainButton = new JRadioButton("Plain");
        plainButton.setBackground(Color.black);
        plainButton.setForeground(new Color(0x00FF00));
        plainButton.setFont(new Font("Verdana", Font.BOLD, 12));
        plainButton.setSize(60, 20);
        plainButton.setLocation(342, 220);

        boldButton = new JRadioButton("Bold");
        boldButton.setBackground(Color.black);
        boldButton.setForeground(new Color(0x00FF00));
        boldButton.setFont(new Font("Verdana", Font.BOLD, 12));
        boldButton.setSize(55, 20);
        boldButton.setLocation(415, 220);

        ButtonGroup group = new ButtonGroup();
        group.add(boldButton);
        group.add(plainButton);

        if (dashboard.mainTextField.getFont().getStyle() == 1)
        { 
            boldButton.setSelected(true);
        }
        else
        {
            plainButton.setSelected(true);
        }
        add(styleLab);
        add(plainButton);
        add(boldButton);
    }

    void dashSize()
    {
        sizeLab = new JLabel("Size :");
        sizeLab.setBounds(175, 220, 60, 20);
        sizeLab.setOpaque(true);
        sizeLab.setFont(new Font("Verdena", Font.BOLD, 15));
        sizeLab.setBackground(Color.black);
        sizeLab.setForeground(new Color(0x00FF00));
        sizeLab.setBorder(new LineBorder(new Color(0x00FF00), 1));
        sizeLab.setHorizontalAlignment(JLabel.CENTER);
        sizeLab.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) 
            {
                float size = Integer.parseInt(sizeText.getText());
                Font font = dashboard.mainTextField.getFont().deriveFont(size);
                dashboard.mainTextField.setFont(font);
            }
        });
        sizeLab.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered(MouseEvent evt) 
            {
                sizeLab.setForeground(Color.WHITE);
                sizeLab.setBackground(new Color(0x00FF00));
            }
        });
        sizeLab.addMouseListener(new MouseAdapter() 
        {
            public void mouseExited(MouseEvent evt) 
            {
                sizeLab.setForeground(new Color(0x00FF00));
                sizeLab.setBackground(Color.black);
            }
        });

        sizeText = new JTextField(dashboard.mainTextField.getFont().getSize()+"");
        sizeText.setBounds(240, 220, 28, 20);
        sizeText.setCaretColor(new Color(0x00FF00));
        sizeText.setBackground(Color.black);
        sizeText.setBorder(new LineBorder(new Color(0x00FF00), 1));
        sizeText.setFont(new Font("Verdena", Font.BOLD, 12));
        sizeText.setForeground(new Color(0x00FF00));

        add(sizeLab);
        add(sizeText);
    }

    void resizeGodsEye()
    {
        regeLab = new JLabel("God's Eye");
        regeLab.setBounds(168, 255, 135, 25);
        regeLab.setOpaque(true);
        regeLab.setFont(new Font("Verdena", Font.BOLD, 15));
        regeLab.setBackground(Color.black);
        regeLab.setForeground(new Color(0x00FF00));
        regeLab.setBorder(new LineBorder(new Color(0x00FF00), 1));
        regeLab.setHorizontalAlignment(JLabel.CENTER);

        regeSlidLength = new JSlider(-100, 100, dashboard.getWidth()-210);
        regeSlidLength.setSize(400, 30);
        regeSlidLength.setLocation(40, 290);
        regeSlidLength.setBackground(Color.black);
        regeSlidLength.setPaintLabels(true);
        regeSlidLength.setMajorTickSpacing(20);
        regeSlidLength.setForeground(new Color(0x00FF00));
        regeSlidLength.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent evt)
            {
                int n = regeSlidLength.getValue();
                dashboard.setSize((210+n), dashboard.getHeight());
                dashboard.mainTextField.setSize(200+n, dashboard.mainTextField.getHeight());
            }
        });

        regeSlidBreadth = new JSlider(-10, 10, dashboard.getHeight()-30);
        regeSlidBreadth.setSize(400, 30);
        regeSlidBreadth.setLocation(40, 330);
        regeSlidBreadth.setBackground(Color.black);
        regeSlidBreadth.setPaintLabels(true);
        regeSlidBreadth.setMajorTickSpacing(2);
        regeSlidBreadth.setForeground(new Color(0x00FF00));
        regeSlidBreadth.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent evt)
            {
                int n = regeSlidBreadth.getValue();
                dashboard.setSize(dashboard.getWidth(), 30+n);
                dashboard.mainTextField.setSize(dashboard.mainTextField.getWidth(), 21+n);
            }
        });

        add(regeLab);
        add(regeSlidLength);
        add(regeSlidBreadth);
    }

    void caretColor()
    {
        caretLabHead = new JLabel("Caret");
        caretLabHead.setBounds(355, 10, 105, 30);
        caretLabHead.setOpaque(true);
        caretLabHead.setFont(new Font("Verdena", Font.BOLD, 15));
        caretLabHead.setBackground(Color.black);
        caretLabHead.setForeground(new Color(0x00FF00));
        caretLabHead.setBorder(new LineBorder(new Color(0x00FF00), 1));
        caretLabHead.setHorizontalAlignment(JLabel.CENTER);
        caretLabHead.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                String caretTextRedString = caretTextRed.getText();
                String caretTextGreenString = caretTextGreen.getText();
                String caretTextBlueString = caretTextBlue.getText();

                int caretTextRedInt = Integer.parseInt(caretTextRedString);
                int caretTextGreenInt = Integer.parseInt(caretTextGreenString);
                int caretTextBlueInt = Integer.parseInt(caretTextBlueString);

                dashboard.mainTextField.setCaretColor(new Color(caretTextRedInt, caretTextGreenInt, caretTextBlueInt));
            }
        });
        caretLabHead.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                caretLabHead.setForeground(Color.WHITE);
                caretLabHead.setBackground(new Color(0x00FF00));
            }
        });
        caretLabHead.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent evt) {
                caretLabHead.setForeground(new Color(0x00FF00));
                caretLabHead.setBackground(Color.black);
            }
        });

        caretLabRed = new JLabel("Red :");
        caretLabRed.setBounds(355, 50, 50, 20);
        caretLabRed.setFont(new Font("Verdena", Font.BOLD, 12));
        caretLabRed.setForeground(new Color(0x00FF00));

        caretLabGreen = new JLabel("Green :");
        caretLabGreen.setBounds(355, 75, 50, 20);
        caretLabGreen.setFont(new Font("Verdena", Font.BOLD, 12));
        caretLabGreen.setForeground(new Color(0x00FF00));

        caretLabBlue = new JLabel("Blue :");
        caretLabBlue.setBounds(355, 100, 50, 20);
        caretLabBlue.setFont(new Font("Verdena", Font.BOLD, 12));
        caretLabBlue.setForeground(new Color(0x00FF00));

        caretTextRed = new JTextField();
        caretTextRed.setBounds(410, 50, 50, 20);
        caretTextRed.setCaretColor(new Color(0x00FF00));
        caretTextRed.setBackground(Color.black);
        caretTextRed.setForeground(new Color(0x00FF00));
        caretTextRed.setFont(new Font("Verdena", Font.BOLD, 12));
        caretTextRed.setBorder(new LineBorder(new Color(0x00FF00), 1));

        caretTextGreen = new JTextField();
        caretTextGreen.setBounds(410, 75, 50, 20);
        caretTextGreen.setCaretColor(new Color(0x00FF00));
        caretTextGreen.setBackground(Color.black);
        caretTextGreen.setForeground(new Color(0x00FF00));
        caretTextGreen.setFont(new Font("Verdena", Font.BOLD, 12));
        caretTextGreen.setBorder(new LineBorder(new Color(0x00FF00), 1));

        caretTextBlue = new JTextField();
        caretTextBlue.setBounds(410, 100, 50, 20);
        caretTextBlue.setCaretColor(new Color(0x00FF00));
        caretTextBlue.setBackground(Color.black);
        caretTextBlue.setForeground(new Color(0x00FF00));
        caretTextBlue.setFont(new Font("Verdena", Font.BOLD, 12));
        caretTextBlue.setBorder(new LineBorder(new Color(0x00FF00), 1));

        add(caretLabHead);
        add(caretLabRed);
        add(caretLabBlue);
        add(caretLabGreen);
        add(caretTextRed);
        add(caretTextGreen);
        add(caretTextBlue);
    }

    public static void main(String args[])
    {
        new Customize(new Dashboard(0, 0, 0, 0));
    }
}
