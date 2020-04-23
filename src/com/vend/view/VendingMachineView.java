package com.vend.view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.Flow;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import com.vend.service.ChangeService;
import com.vend.view.Menu;
import com.vend.Constant.Const;

public class VendingMachineView implements MouseListener {
    private JPanel panel;
    private JPanel subPanel1;
    private JPanel subPanel2;
    private JPanel subPanel3;
    private JPanel subPanel4;

    private JLabel TotalPrice;
    private JButton buttonCancel;
    private JLabel PaidLabel;
    private JTextField Paid;
    private JButton buttonSubmit;

    private JFrame frame;

    private Menu menu[];

    private JLabel title;

    public VendingMachineView(){
        frame = new JFrame("자판기");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(600, 600));

        InitSubPanel1();
        InitSubPanel2();
        InitSubPanel3();
        InitSubPanel4();
        panel.addMouseListener(this);
        frame.setResizable(false);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    private void InitSubPanel1(){
        subPanel1 = new JPanel(new GridBagLayout());
        subPanel1.setBackground(Color.WHITE);
        title = new JLabel("상품주문");
        title.setFont(new Font("SansSerif", Font.PLAIN, 30));
        title.setHorizontalAlignment(JLabel.CENTER);
        gbAdd(subPanel1,title, 0, 0, 1, 1, GridBagConstraints.BOTH);
        gbAdd(panel, subPanel1, 0, 0, 1, 1, GridBagConstraints.BOTH);
    }
    private void InitSubPanel2(){
        subPanel2 = new JPanel(new GridBagLayout());
        subPanel2.setBackground(Color.WHITE);
        menu = new Menu[3];
        for(int i=0; i<3; i++){
            menu[i] = new Menu(i+1, Const.ProductName[i], Const.Price[i]);
            menu[i].addMouseListener(this);
            menu[i].ButtonMinus.addMouseListener(this);
            menu[i].ButtonPlus.addMouseListener(this);
            gbAdd(subPanel2, menu[i], i%3, i/3, 1, 1, GridBagConstraints.BOTH);
        }
        gbAdd(panel, subPanel2, 0, 1, 1, 8, GridBagConstraints.BOTH);
    }
    private void InitSubPanel3(){
        subPanel3 = new JPanel(new GridLayout(1, 3));
        subPanel3.setBackground(Color.WHITE);
        TotalPrice = new JLabel("0원");
        TotalPrice.setFont(new Font("SansSerif", Font.PLAIN, 24));
        TotalPrice.setHorizontalAlignment(JLabel.CENTER);
        buttonCancel = new JButton("취소하기");
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0; i<3; i++){
                    menu[i].ResetSelected();
                }
                TotalPrice.setText("0원");
                System.out.println("Button2 Clicked!!");
            }
        });
        buttonCancel.setFont(new Font("SansSerif", Font.PLAIN, 21));
        buttonCancel.setPreferredSize(new Dimension(100, 100));
        subPanel3.add(TotalPrice);
        subPanel3.add(new JLabel(" "));
        subPanel3.add(buttonCancel);
        gbAdd(panel, subPanel3, 0, 9, 1, 1, GridBagConstraints.BOTH);
    }
    private void InitSubPanel4(){
        subPanel4 = new JPanel(new GridLayout(1, 3));
        subPanel4.setBackground(Color.WHITE);
        PaidLabel = new JLabel("지불할 금액");
        PaidLabel.setFont(new Font("SansSerif", Font.PLAIN, 24));
        PaidLabel.setHorizontalAlignment(JLabel.CENTER);
        Paid = new JTextField(7){
            public void setBorder(Border border){ }
        };
        Paid.setHorizontalAlignment(JTextField.CENTER);
        IntegerDocument  id = new IntegerDocument (); // 숫자만
        Paid.setDocument(id);
        Paid.setFont(new Font("SansSerif", Font.BOLD, 20));
        buttonSubmit = new JButton("구매하기");
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int totalPrice = 0;
                for(int i=0; i<3; i++){
                    totalPrice += menu[i].getTotalPrice();
                }
                Paid.getText();
                ChangeService.calcChange(totalPrice, Integer.parseInt(Paid.getText()));
            }
        });
        buttonSubmit.setFont(new Font("SansSerif", Font.PLAIN, 21));
        buttonSubmit.setPreferredSize(new Dimension(100, 100));
        subPanel4.add(PaidLabel);
        subPanel4.add(Paid);
        subPanel4.add(buttonSubmit);
        gbAdd(panel, subPanel4, 0, 10, 1, 1, GridBagConstraints.BOTH);
    }

    private void gbAdd(JPanel jPanel, JComponent c, int x, int y, int w, int h, int fill){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = fill;
        gbc.insets = new Insets(2, 2, 2, 2);
        jPanel.add(c, gbc);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        refreshTotalPrice();
    }
    @Override
    public void mousePressed(MouseEvent e) {
        refreshTotalPrice();
    }
    @Override
    public void mouseReleased(MouseEvent e)  {
        refreshTotalPrice();
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        refreshTotalPrice();
    }
    @Override
    public void mouseExited(MouseEvent e)  {
        refreshTotalPrice();
    }
    private void refreshTotalPrice(){
        int totalPrice = 0;
        for(int i=0; i<3; i++){
            totalPrice += menu[i].getTotalPrice();
        }
        TotalPrice.setText(totalPrice + "원");
        TotalPrice.updateUI();
    }
}
