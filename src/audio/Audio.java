package audio;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;

public class Audio extends JFrame 
{
    private static final long serialVersionUID = 1L;
    ImageIcon startIcon;
    ImageIcon stopIcon;
    ImageIcon restartIcon;
    ImageIcon closeIcon;

    JLabel startLabel;
    JLabel restartLabel;
    JLabel closeLabel;

    int xMouse, yMouse, x, y;
    String music;
    Boolean startBoolean = false;

    File file;
    AudioInputStream audioStream;
    Clip clip;

    public Audio(String music)
    {
        try
        {
        if (music.toLowerCase().contains("una mattina"))
        {
            file = new File("src\\audio\\Music\\Una mattina - Ludovico Einaudi.wav");
            audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            new Frame(clip);
        }
        else if (music.toLowerCase().contains("kanon"))
        {
            file = new File("src\\audio\\Music\\George Winston -  Pachelbel's Canon on Piano.wav");
            audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            new Frame(clip);
        }
        else if (music.toLowerCase().contains("experience"))
        {
            file = new File("src\\audio\\Music\\Ludovico Einaudi - Experience.wav");
            audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            new Frame(clip);
        }
        else if (music.toLowerCase().contains("in un altra vita"))
        {
            file = new File("src\\audio\\Music\\Ludovico Einaudi - in un altra vita.wav");   
            audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            new Frame(clip);
        }
        else if (music.toLowerCase().contains("nuvole bianche"))
        {
            file = new File("src\\audio\\Music\\Nuvole Bianche - Ludovico Einaudi.wav");   
            audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            new Frame(clip);
        }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
