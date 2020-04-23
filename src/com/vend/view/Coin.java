package com.vend.view;

import java.awt.*;
import javax.swing.*;

public class Coin implements Runnable {
    int money;
    public Coin(int n){
        money = n;
    }
    @Override
    public void run() {
        Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
        JDialog jDialog = new JDialog();
        JOptionPane.showMessageDialog(jDialog,money+"원");
    }
}


