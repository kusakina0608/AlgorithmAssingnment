package com.vend.service;
import java.util.Scanner;

public class ChangeService {
    static final int ITEM_PRICE_1 = 3000;
    static final int ITEM_PRICE_2 = 4000;
    static final int ITEM_PRICE_3 = 1800;

    public static void main() {
        Scanner sc = new Scanner(System.in);
        //물건 수량은 랜덤으로 정의
        int first_item = (int)(Math.random()*10)+1;
        int second_item = (int)(Math.random()*10)+1;
        int third_item = (int)(Math.random()*10)+1;

        int all_price = (first_item * ITEM_PRICE_1) + (second_item * ITEM_PRICE_2) + (third_item * ITEM_PRICE_3);

        System.out.println("지불할금액을 입력하세요 : ");
        int put_money = sc.nextInt();

        int D_A;
        D_A = put_money - all_price;
        while(D_A<0){
            System.out.println("투입금액이 적습니다. 돈을 더 넣어주세요.");
            put_money=sc.nextInt();
        }

        int coin[]= new int[]{10000, 5000, 1000, 500, 100, 10, 1};
        int coin_[]= new int[]{10000, 5000, 1200, 1000, 500, 100, 10, 1};
        int coin_num=0;
        int bill_num=0;
        int rest_m=0;
        for(int i=0; i<coin.length;i++){
            if(rest_m>1000){
                bill_num += D_A/coin[i];
                rest_m=D_A%coin[i];
            }

            if(rest_m<1000){
                coin_num += D_A/coin[i];
                rest_m=D_A%coin[i];
            }
        }
        System.out.println("지폐 갯수는"+bill_num +"이며");
        System.out.println("동전 갯수는"+coin_num +"입니다.");
        for(int i=0; i<coin_.length;i++){
            if(rest_m>1000){
                bill_num += D_A/coin_[i];
                rest_m=D_A%coin_[i];
            }

            if(rest_m<1000){
                coin_num += D_A/coin_[i];
                rest_m=D_A%coin_[i];
            }
        }
        System.out.println("1200원짜리 지폐가 있다고 가정할 경우");
        System.out.println("지폐 갯수는"+bill_num +"이며");
        System.out.println("동전 갯수는"+coin_num +"입니다.");
        sc.close();
    }
}
