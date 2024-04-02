package liquidationcalculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SubPanel extends JPanel implements ActionListener
{
    private int width;
    private int height;
    
    private Color background = new Color(240, 240, 240);
    private Color disabledTxtBackgroud = new Color(125, 125, 125);
    private Color enabledTxtBackground = new Color(255, 255, 255);
    
    private String leveragesList[] = {"x50", "x75", "x100", "x125"};
    private double marginRatesList[] = {0.01, 0.0065, 0.005, 0.004};
    private double marginRate = 0.01;
    private int side;
    private int mode = 0;
    
    private JRadioButton btnBuy;
    private JRadioButton btnSell;
    private ButtonGroup radioGroup;
    private JComboBox maxLeverageComboBox;
    
    private JTextArea txtWalletBalance;
    private JTextArea txtEntryPrice;
    private JTextArea txtPositionSize;
    private JTextArea txtLiquidationPrice;
    
    private JLabel lblWalletBalance;
    private JLabel lblEntryPrice;
    private JLabel lblPositionSize;
    private JLabel lblLiquidationPrice;
    
    private JLabel lblPercent;
    
    private JButton btnClear;
    private JButton btnCalc;
    
    public SubPanel (int x, int y, int width, int height)
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
        btnBuy = new JRadioButton();
        btnBuy.setText("BUY");
        btnBuy.setSize(60, 20);
        btnBuy.setLocation(width/8*2-30-10, 10);
        btnBuy.setFocusable(false);
        btnBuy.setBackground(background);
        btnBuy.addActionListener(this);
        add(btnBuy);
        
        btnSell = new JRadioButton();
        btnSell.setText("SELL");
        btnSell.setSize(60, 20);
        btnSell.setLocation(width/8*4 - 30, 10);
        btnSell.setFocusable(false);
        btnSell.setBackground(background);
        btnSell.addActionListener(this);
        add(btnSell);
        
        radioGroup = new ButtonGroup(); 
        radioGroup.add(btnBuy);
        radioGroup.add(btnSell);
        
        maxLeverageComboBox = new JComboBox(leveragesList);
        maxLeverageComboBox.setSize(60, 20);
        maxLeverageComboBox.setLocation(width/8*6-30+10, 10);
        maxLeverageComboBox.setFocusable(false);
        maxLeverageComboBox.addActionListener(this);
        add(maxLeverageComboBox);
        
        
        lblWalletBalance = new JLabel("Isolated Margin Balance");
        lblWalletBalance.setSize(180, 20);
        lblWalletBalance.setLocation(width/8*3-90, 78);
        add(lblWalletBalance);
        
        txtWalletBalance = new JTextArea();
        txtWalletBalance.setSize(60, 20);
        txtWalletBalance.setLocation(width/8*5-30, 80);
        add(txtWalletBalance);
        
        
        lblEntryPrice = new JLabel("Position Entry Price");
        lblEntryPrice.setSize(180, 20);
        lblEntryPrice.setLocation(width/8*3-90, 138);
        add(lblEntryPrice);
        
        txtEntryPrice = new JTextArea();
        txtEntryPrice.setSize(60, 20);
        txtEntryPrice.setLocation(width/8*5-30, 140);
        add(txtEntryPrice);
        
        
        lblPositionSize = new JLabel("Position Quantity");
        lblPositionSize.setSize(180, 20);
        lblPositionSize.setLocation(width/8*3-90, 198);
        add(lblPositionSize);
        
        txtPositionSize = new JTextArea();
        txtPositionSize.setSize(60, 20);
        txtPositionSize.setLocation(width/8*5-30, 200);
        add(txtPositionSize);
        
        
        lblLiquidationPrice = new JLabel("Liquidation Price");
        lblLiquidationPrice.setSize(180, 20);
        lblLiquidationPrice.setLocation(width/8*3-90, 258);
        add(lblLiquidationPrice);
        
        txtLiquidationPrice = new JTextArea();
        txtLiquidationPrice.setSize(60, 20);
        txtLiquidationPrice.setLocation(width/8*5-30, 260);
        add(txtLiquidationPrice);
        
        lblPercent = new JLabel("opa");
        lblPercent.setSize(60, 20);
        lblPercent.setLocation(10, 10);
        add(lblPercent);
        
        
        btnClear = new JButton("CLEAR");
        btnClear.setSize(100, 50);
        btnClear.setLocation(width/3-50, 320);
        btnClear.setFocusable(false);
        btnClear.addActionListener(this);
        add(btnClear);
        
        btnCalc = new JButton("CALC");
        btnCalc.setSize(100, 50);
        btnCalc.setLocation(width/3*2-50, 320);
        btnCalc.setFocusable(false);
        btnCalc.addActionListener(this);
        add(btnCalc);
        
        setMode(0);
    }
    
    public void setMode (int index)
    {
        mode = index;
        clear();
        
        if (mode == 0)
        {
            txtWalletBalance.enable();
            txtWalletBalance.setBackground(enabledTxtBackground);
            txtEntryPrice.enable();
            txtEntryPrice.setBackground(enabledTxtBackground);
            txtPositionSize.enable();
            txtPositionSize.setBackground(enabledTxtBackground);
            txtLiquidationPrice.disable();
            txtLiquidationPrice.setBackground(disabledTxtBackgroud);
        }
        else if (mode == 1)
        {
            txtWalletBalance.disable();
            txtWalletBalance.setBackground(disabledTxtBackgroud);
            txtEntryPrice.enable();
            txtEntryPrice.setBackground(enabledTxtBackground);
            txtPositionSize.enable();
            txtPositionSize.setBackground(enabledTxtBackground);
            txtLiquidationPrice.enable();
            txtLiquidationPrice.setBackground(enabledTxtBackground);
        }
        else if (mode == 2)
        {
            txtWalletBalance.enable();
            txtWalletBalance.setBackground(enabledTxtBackground);
            txtEntryPrice.enable();
            txtEntryPrice.setBackground(enabledTxtBackground);
            txtPositionSize.disable();
            txtPositionSize.setBackground(disabledTxtBackgroud);
            txtLiquidationPrice.enable();
            txtLiquidationPrice.setBackground(enabledTxtBackground);
        }
        else if (mode == 3)
        {
            txtWalletBalance.enable();
            txtWalletBalance.setBackground(enabledTxtBackground);
            txtEntryPrice.disable();
            txtEntryPrice.setBackground(disabledTxtBackgroud);
            txtPositionSize.enable();
            txtPositionSize.setBackground(enabledTxtBackground);
            txtLiquidationPrice.enable();
            txtLiquidationPrice.setBackground(enabledTxtBackground);
        }
    }

    public void clear ()
    {
        txtWalletBalance.setText("");
        txtEntryPrice.setText("");
        txtPositionSize.setText("");
        txtLiquidationPrice.setText("");
    }
    
    @Override
    public void actionPerformed (ActionEvent e)
    {
        if (e.getSource() == btnBuy)
        {
            side = 1;
            System.out.println(side);
        }
        else if (e.getSource() == btnSell)
        {
            side = -1;
            System.out.println(side);
        }
        else if (e.getSource() == maxLeverageComboBox)
        {
            int marginIndex = maxLeverageComboBox.getSelectedIndex();
            marginRate = marginRatesList[marginIndex];
            System.out.println(marginRate);
        }
        else if (e.getSource() == btnClear)
        {
            clear();
        }
        else if (e.getSource() == btnCalc)
        {
            double balance;
            double entryPrice;
            double positionSize;
            double liquidationPrice;
            
            switch (mode)
            {
                case 0:
                    balance = Double.parseDouble(txtWalletBalance.getText());
                    entryPrice = Double.parseDouble(txtEntryPrice.getText());
                    positionSize = Double.parseDouble(txtPositionSize.getText());
                    System.out.println(balance + ", " + entryPrice + ", " + positionSize);
                    System.out.println(side + ", " + marginRate);
                    
                    liquidationPrice = (balance - side*positionSize*entryPrice) / (positionSize*(marginRate - side));
                    txtLiquidationPrice.setText(Double.toString(liquidationPrice));
                    break;
                case 1:
                    entryPrice = Double.parseDouble(txtEntryPrice.getText());
                    positionSize = Double.parseDouble(txtPositionSize.getText());
                    liquidationPrice = Double.parseDouble(txtLiquidationPrice.getText());
                    
                    balance = liquidationPrice*positionSize*(marginRate - side) + side*positionSize*entryPrice;
                    txtWalletBalance.setText(Double.toString(balance));
                    break;
                case 2:
                    balance = Double.parseDouble(txtWalletBalance.getText());
                    entryPrice = Double.parseDouble(txtEntryPrice.getText());
                    liquidationPrice = Double.parseDouble(txtLiquidationPrice.getText());
                    
                    positionSize = balance / (liquidationPrice*(marginRate - side) + side*entryPrice);
                    txtPositionSize.setText(Double.toString(positionSize));
                    break;
                case 3:
                    balance = Double.parseDouble(txtWalletBalance.getText());
                    positionSize = Double.parseDouble(txtPositionSize.getText());
                    liquidationPrice = Double.parseDouble(txtLiquidationPrice.getText());
                    
                    System.out.println(balance + ", " + liquidationPrice + ", " + positionSize);
                    System.out.println(side + ", " + marginRate);
                    
                    System.out.println(balance - (liquidationPrice*positionSize*(marginRate - side)));
                    System.out.println(side*positionSize);
                    entryPrice = (balance - liquidationPrice*positionSize*(marginRate - side)) / (side*positionSize);
                    txtEntryPrice.setText(Double.toString(entryPrice));
                    break;
                default:
                    break;
            }
            
            entryPrice = Double.parseDouble(txtEntryPrice.getText());
            liquidationPrice = Double.parseDouble(txtLiquidationPrice.getText());
            double percent = 100 - (liquidationPrice*100)/entryPrice;
            lblPercent.setText(Double.toString(percent));
        }
    }
}
