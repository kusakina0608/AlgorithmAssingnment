package com.vend.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Menu extends JPanel {
    private JLabel ProductName;
    private JLabel Image;
    public JButton ButtonMinus;
    private JLabel LabelNum;
    public JButton ButtonPlus;
    private JLabel Price;
    private int num;
    private int price;
    public Menu(int i, String name, int price){
        this.price = price;
        this.num = 0;
        this.setLayout(new GridBagLayout());

        // 상품 이미지
        Image = new JLabel();
        Image img1 = null;
        try {
            img1 = ImageIO.read(new File(("img/item_0" + Integer.toString(i) + ".png").replaceAll(" ", "")));
        } catch (Exception ex) {
            System.out.print("exception in Vending MachineView while load images");
        }
        img1 = img1.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        Image.setIcon(new ImageIcon(img1));
        Image.setHorizontalAlignment(JLabel.CENTER);


        // - 버튼 생성
        ButtonMinus = new JButton("-");
        ButtonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(num>0) {
                    num--;
                    LabelNum.setText(Integer.toString(num));
                }else{
                    JOptionPane.showMessageDialog(null, "상품 수량은 0개보다 적어질 수 없습니다.");
                }
                System.out.println("- Button Clicked!!");
            }
        });
        ButtonMinus.setPreferredSize(new Dimension(40, 40));

        // + 버튼 생성
        ButtonPlus = new JButton("+");
        ButtonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(num<20) {
                    num++;
                    LabelNum.setText(Integer.toString(num));
                }else{
                    JOptionPane.showMessageDialog(null, "그만 먹어.");
                }
                System.out.println("+ Button Clicked!!");
            }
        });
        ButtonPlus.setPreferredSize(new Dimension(40, 40));

        // 상품명 레이블 생성
        ProductName = new JLabel(name);
        ProductName.setFont(new Font(ProductName.getFont().getName(), Font.PLAIN, 18));
        ProductName.setHorizontalAlignment(JLabel.CENTER);

        // 상품 수량 레이블 생성
        LabelNum = new JLabel(Integer.toString(this.num));
        LabelNum.setFont(new Font(LabelNum.getFont().getName(), Font.PLAIN, 18));
        LabelNum.setHorizontalAlignment(JLabel.CENTER);

        // 상품 가격 레이블 생성
        Price = new JLabel(Integer.toString(price) + "원");
        Price.setFont(new Font(Price.getFont().getName(), Font.PLAIN, 18));
        Price.setHorizontalAlignment(JLabel.CENTER);

        // 위치 지정
        GridBagConstraints gbc[] = new GridBagConstraints[6];
        // 상품명
        gbc[0] = new GridBagConstraints();
        gbc[0].gridx = 0;
        gbc[0].gridy = 0;
        gbc[0].gridwidth = 6;
        gbc[0].gridheight = 1;
        gbc[0].fill = GridBagConstraints.BOTH;
        // 상품 이미지
        gbc[1] = new GridBagConstraints();
        gbc[1].gridx = 0;
        gbc[1].gridy = 1;
        gbc[1].gridwidth = 6;
        gbc[1].gridheight = 6;
        gbc[1].fill = GridBagConstraints.BOTH;
        // - 버튼
        gbc[2] = new GridBagConstraints();
        gbc[2].gridx = 0;
        gbc[2].gridy = 7;
        gbc[2].gridwidth = 1;
        gbc[2].gridheight = 1;
        gbc[2].fill = GridBagConstraints.BOTH;
        // 물품 수량
        gbc[3] = new GridBagConstraints();
        gbc[3].gridx = 1;
        gbc[3].gridy = 7;
        gbc[3].gridwidth = 1;
        gbc[3].gridheight = 1;
        gbc[3].fill = GridBagConstraints.BOTH;
        // + 버튼
        gbc[4] = new GridBagConstraints();
        gbc[4].gridx = 2;
        gbc[4].gridy = 7;
        gbc[4].gridwidth = 1;
        gbc[4].gridheight = 1;
        gbc[4].fill = GridBagConstraints.BOTH;
        // 상품 가격
        gbc[5] = new GridBagConstraints();
        gbc[5].gridx = 3;
        gbc[5].gridy = 7;
        gbc[5].gridwidth = 3;
        gbc[5].gridheight = 1;
        gbc[5].fill = GridBagConstraints.BOTH;

        this.add(ProductName, gbc[0]);
        this.add(Image, gbc[1]);
        this.add(ButtonMinus, gbc[2]);
        this.add(LabelNum, gbc[3]);
        this.add(ButtonPlus, gbc[4]);
        this.add(Price, gbc[5]);
    }

    public int getTotalPrice(){
        return num*price;
    }
    public void ResetSelected(){
        num = 0;
        LabelNum.setText(Integer.toString(num));
    }
}
