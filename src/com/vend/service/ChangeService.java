package com.vend.service;
import java.util.Scanner;

public class ChangeService {
    static final int ITEM_PRICE_1 = 3225;
    static final int ITEM_PRICE_2 = 4184;
    static final int ITEM_PRICE_3 = 1836;

    public static void main() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("상품 수량 1,2,3번을 빈칸으로 분리하여 입력해주세요 :" );

        int item_number_1 = scanner.nextInt();
        int item_number_2 = scanner.nextInt();
        int item_number_3 = scanner.nextInt();

        System.out.println("지불할금액을 입력하세요 : ");
        int put_money = scanner.nextInt();

        scanner.close();

        int change;

        int all_price = (item_number_1 * ITEM_PRICE_1) + (item_number_2 * ITEM_PRICE_2) + (item_number_3 * ITEM_PRICE_3);
        change = put_money - all_price;

        int coin[10000,1000,500,100,10,1];
        int count[6];

        int coin_num;

        while(true){
            if(change>0){
                coin_num++;
	else if()


                    break;}
        }


        System.out.println("최소 동전 갯수는"+coin_num +"입니다");
    }




}



}
        }