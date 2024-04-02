package liquidationcalculator;

import javax.swing.JFrame;

public class Frame extends JFrame
{
    public Frame(int width, int height, String title)
    {
        setTitle(title);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(width, height);
        setLocationRelativeTo(null);
        setVisible(true);
        
        MainPanel p = new MainPanel(0, 0, width, height);
        add(p);
        
        revalidate();
        repaint();
    }
}
