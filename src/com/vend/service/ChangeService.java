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

        int n10000 = 0;
        int n1000 = 0;
        int n500 = 0;
        int n150 = 0;
        int n100 = 0;
        int n50 = 0;
        int n10 = 0;
        int n1 = 0;

        while (change >= 10000) {
            change = change - 10000;
            n10000++;
        }
        while (change >= 1000) {
            change = change - 1000;
            n1000++;
        }
        while (change >= 500) {
            change = change - 500;
            n500++;
        }
        while (change >= 150) {
            change = change - 150;
            n150++;
        }
        while (change >= 100) {
            change = change - 100;
            n100++;
        }
        while (change >= 50) {
            change = change - 50;
            n50++;
        }
        while (change >= 1) {
            change = change - 1;
            n1++;
        }


        System.out.println("총금액 : " + all_price);
        System.out.println("잔돈은 : " + change);
        System.out.println("잔돈 계산 : 만원 " + n10000 + "장");
        System.out.println("잔돈 계산 : 천원 " + n1000 + "장");
        System.out.println("잔돈 계산 : 500원 " + n500 + "개");
        System.out.println("잔돈 계산 : 150원 " + n150 + "개");
        System.out.println("잔돈 계산 : 100원 " + n100 + "개");
        System.out.println("잔돈 계산 : 10원 " + n10 + "개");
        System.out.println("잔돈 계산 : 1원 " + n1 + "개");

    }
}