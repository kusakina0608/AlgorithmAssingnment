package com.vend.view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.concurrent.Flow;
import javax.imageio.ImageIO;
import javax.swing.*;
import com.vend.view.Menu;
import com.vend.Constant.Const;

public class VendingMachineView {
    private JPanel panel;
    private JPanel subPanel1;
    private JPanel subPanel2;
    private JPanel subPanel3;
    private JPanel subPanel4;

    private JButton buttonSubmit;
    private JButton buttonCancel;

    private JFrame frame;

    //private JLabel img_1;
    //private JLabel img_2;
    //private JLabel img_3;
    private Menu menu[];

    private JLabel title;

    public VendingMachineView(){
        frame = new JFrame("자판기");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.white);
        panel.setPreferredSize(new Dimension(600, 600));

        InitSubPanel1();
        InitSubPanel2();
        InitSubPanel3();
        InitSubPanel4();

        frame.setResizable(false);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    /*private void LoadImages(){
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
    }*/

    private void InitSubPanel1(){
        subPanel1 = new JPanel(new FlowLayout());
        subPanel1.setBackground(Color.red);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(subPanel1, gbc);
    }
    private void InitSubPanel2(){
        subPanel2 = new JPanel(new FlowLayout());
        subPanel2.setBackground(Color.blue);

        /*LoadImages();
        subPanel2.add(img_1);
        subPanel2.add(img_2);
        subPanel2.add(img_3);*/

        menu = new Menu[3];
        for(int i=0; i<3; i++){
            menu[i] = new Menu(i+1, Const.ProductName[i], Const.Price[i]);
            subPanel2.add(menu[i]);
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 8;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(subPanel2, gbc);
    }
    private void InitSubPanel3(){
        subPanel3 = new JPanel(new FlowLayout());
        subPanel3.setBackground(Color.green);
        GridBagConstraints gbc = new GridBagConstraints();

        buttonSubmit = new JButton("구매하기");
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO("총액계산, 거스름돈 계산, 결과 출력")
                System.out.println("Button Clicked!!");
            }
        });
        subPanel3.add(buttonSubmit);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(subPanel3, gbc);
    }
    private void InitSubPanel4(){
        subPanel4 = new JPanel(new FlowLayout());
        subPanel4.setBackground(Color.pink);
        GridBagConstraints gbc = new GridBagConstraints();

        buttonCancel = new JButton("취소하기");
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO("입력 값 전부 초기화")
                System.out.println("Button2 Clicked!!");
            }
        });
        subPanel4.add(buttonCancel);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 2;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(subPanel4, gbc);
    }
}
