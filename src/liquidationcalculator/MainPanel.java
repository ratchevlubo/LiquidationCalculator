package liquidationcalculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainPanel extends JPanel implements ActionListener
{
    private int width;
    private int height;
    
    private Color background = new Color(240, 240, 240);
    
    private String modesList[] = {"Liquidation Price", "Balance", "Quantity", "Entry Price"};
    
    private JComboBox modeComboBox;
    private JLabel comboBoxLabel;
    private SubPanel subPanel;
    
    public MainPanel (int x, int y, int width, int height)
    {
        this.width = width;
        this.height = height;
        
        setLayout(null);
        setLocation(x, y);
        setSize(width, height);
        setBackground(background);
        
        initComponents();
    }
    
    private void initComponents ()
    {
        comboBoxLabel = new JLabel("What to calculate");
        comboBoxLabel.setSize(140, 20);
        comboBoxLabel.setLocation(width/8*3-60-5, 28);
        add(comboBoxLabel);
        
        modeComboBox = new JComboBox(modesList);
        modeComboBox.setSize(140, 20);
        modeComboBox.setLocation(width/8*5-60+5, 30);
        modeComboBox.setFocusable(false);
        modeComboBox.addActionListener(this);
        add(modeComboBox);
        
        subPanel = new SubPanel(0, 80, width, height-80);
        subPanel.setMode(0);
        add(subPanel);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == modeComboBox)
        {
            int modeIndex = modeComboBox.getSelectedIndex();
            subPanel.setMode(modeIndex);
        }
    }
}
