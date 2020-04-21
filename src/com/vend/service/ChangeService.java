package com.vend.service;
import java.util.Scanner;

public class ChangeService {

    public ChangeService(String a,String b) {
        String [] Total_price=a.split("원");
        int ITEM_PRICE_1 = 3000;
        int ITEM_PRICE_2 = 4000;
        int ITEM_PRICE_3 = 1800;
        Scanner sc = new Scanner(System.in);
        int Int_total_price = Integer.parseInt(Total_price[0]);
        int money = Integer.parseInt(b);

        //물건 수량은 랜덤으로 정의
        int first_item = (int)(Math.random()*10)+1;
        int second_item = (int)(Math.random()*10)+1;
        int third_item = (int)(Math.random()*10)+1;

        for(int i=0; i<2;i++) {
            int D_A = money - Int_total_price;
            while (D_A < 0) {
                //TODO 소지금이 총비용을 넘어가는 경우를 입력하면 멈춤.
                System.out.println("투입금액이 적습니다. 돈을 더 넣어주세요.");
                money = sc.nextInt();
            }

            int Cmoney[][] = new int[][]{
                    {10000, 5000, 1000, 500, 100, 10, 1},      //일반적인 상황
                    {10000, 5000, 1200, 1000, 500, 100, 10, 1} //그리디??
            };

            int coin_num = 0;
            int bill_num = 0;
            for (int j = 0; j < Cmoney[i].length; j++) {
                if (D_A >= 1000) {
                    bill_num += D_A / Cmoney[i][j];
                    D_A = D_A % Cmoney[i][j];
                }

                if (D_A < 1000) {
                    coin_num += D_A / Cmoney[i][j];
                    D_A = D_A % Cmoney[i][j];
                }
            }
            if(i==1)
                System.out.println("1200원짜리 지폐가 있다고하면");
            System.out.println("지폐 갯수는" + bill_num + "장이며");
            System.out.println("동전 갯수는" + coin_num + "개 입니다.");
            System.out.println("");

            sc.close();
        }
    }
}
