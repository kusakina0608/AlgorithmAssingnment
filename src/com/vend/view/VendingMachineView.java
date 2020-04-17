package com.vend.view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.concurrent.Flow;
import javax.imageio.ImageIO;
import javax.swing.*;

public class VendingMachineView {
    private JPanel panel;
    private JPanel northPanel;
    private JPanel southPanel;

    private JButton button1;
    private JButton button2;

    private JFrame frame;
    private JLabel img_1;
    private JLabel img_2;
    private JLabel img_3;

    private JLabel title;

    public VendingMachineView(){
        frame = new JFrame("자판기");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.white);
        panel.setPreferredSize(new Dimension(600, 600));


        button1 = new JButton("구매하기");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO("총액계산, 거스름돈 계산, 결과 출력")
                System.out.println("Button Clicked!!");
            }
        });

        button2 = new JButton("취소하기");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO("입력 값 전부 초기화")
                System.out.println("Button2 Clicked!!");
            }
        });

        LoadImages();
        InitNorthPanel();
        InitSouthPanel();
        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(southPanel, BorderLayout.SOUTH);

        frame.setResizable(false);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void LoadImages(){
        img_1 = new JLabel();
        img_2 = new JLabel();
        img_3 = new JLabel();
        Image img1 = null;
        Image img2 = null;
        Image img3 = null;
        try {
            img1 = ImageIO.read(new File("img/item_01.png"));
            img2 = ImageIO.read(new File("img/item_02.png"));
            img3 = ImageIO.read(new File("img/item_03.png"));

        } catch (Exception ex) {
            System.out.print("exception in Vending MachineView while load images");
        }
        img1 = img1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        img2 = img2.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        img3 = img3.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        img_1.setIcon(new ImageIcon(img1));
        img_2.setIcon(new ImageIcon(img2));
        img_3.setIcon(new ImageIcon(img3));
    }

    private void InitNorthPanel(){
        northPanel = new JPanel(new FlowLayout());
        northPanel.setBackground(Color.white);
        northPanel.add(img_1);
        northPanel.add(img_2);
        northPanel.add(img_3);
        northPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        northPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
    }

    private void InitSouthPanel(){
        southPanel = new JPanel(new FlowLayout());
        southPanel.add(button1);
        southPanel.add(button2);
    }

}
