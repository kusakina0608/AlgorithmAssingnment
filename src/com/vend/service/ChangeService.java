package com.vend.service;

import com.vend.Constant.Const;
import com.vend.view.Coin;

import javax.swing.*;

public class ChangeService{
    public static int calcChange(int totalPrice, int paid) {
        int change = paid - totalPrice;
        if (change<0) {
            return change;
        }
        else if(change==0){
            return 0;
        }
        else {
            for (int i = 0; i < Const.Coin.length; i++) {
                int num = change/Const.Coin[i];
                for(int j = 0; j<num; j++){
                    Coin coin = new Coin(Const.Coin[i]);
                    change -= Const.Coin[i];
                    Thread thread = new Thread(coin);
                    thread.start();
                }
            }
        }
        return 1;
    }
}
