package com.vend.service;

import com.vend.Constant.Const;
import com.vend.view.Coin;

public class ChangeService{
    public static int[][] Changes;

    public static int calcChange(int totalPrice, int paid) {
        int change = paid - totalPrice;
        if (change<0) {
            return change;
        }
        else if(change==0){
            return 0;
        }
        else {
            int num = Const.Coin.length;
            Changes = new int[num][change+1];

            for(int j=1; j<change+1; j++){
                Changes[num-1][j]=j;
            }

            for(int i=num-2; i>=0; i--){
                for(int j=1; j<change+1; j++){ // j: 거스름돈
                    if(Const.Coin[i]<=j) {
                        int totalCoins1 = 0; // 이전 방법 사용
                        for(int k=i+1; k<num; k++){
                            totalCoins1 += Changes[k][j];
                        }

                        int totalCoins2 = 0; // 큰 단위 동전 사
                        int remainder = j - Const.Coin[i];
                        int tmp = 0;
                        for(int k=i+1; k<num; k++){
                            tmp += Changes[k][remainder];
                        }
                        totalCoins2 += 1 + tmp;
                        if(i<num-1 && totalCoins1>totalCoins2){ // 큰 단위 동전을 쓰는게 나을 경우에만 갱신
                            remainder = j - Const.Coin[i];
                            Changes[i][j] = 1 + Changes[i][remainder];
                            for(int k=i+1; k<num; k++){
                                Changes[k][j] = Changes[k][remainder];
                            }
                        }
                    }
                }
            }
            /* debug */
            /*System.out.printf("%5d : ", 0);
            for(int i=0; i<change+1; i++){
                System.out.printf("%3d ", i);
            }
            System.out.println();
            for(int i=0; i<num; i++) {
                System.out.printf("%5d : ", Const.Coin[i]);
                for (int j=0; j<change+1; j++) {
                    System.out.printf("%3d ", Changes[i][j]);
                }
                System.out.println();
            }*/
        }
        return 1;
    }
}
