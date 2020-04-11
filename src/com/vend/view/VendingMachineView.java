package com.vend.view;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class VendingMachineView {
    private JFrame frame;
    private JLabel img_1;
    private JLabel img_2;
    private JLabel img_3;

    public VendingMachineView(){
        frame = new JFrame("자판기");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.white);
        panel.setPreferredSize(new Dimension(600, 600));

        JPanel northPanel = new JPanel(new FlowLayout());
        northPanel.setBackground(Color.white);
        img_1 = new JLabel();
        img_2 = new JLabel();
        img_3 = new JLabel();

        northPanel.add(img_1);
        northPanel.add(img_2);
        northPanel.add(img_3);
        northPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        northPanel.setAlignmentY(Component.CENTER_ALIGNMENT);


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

        panel.add(northPanel, BorderLayout.NORTH);

        frame.setResizable(false);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
