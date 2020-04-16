
package com.vend.service;

public class ChangeService {
    static final int ITEM_PRICE_1 = 3000;
    static final int ITEM_PRICE_2 = 5000;
    static final int ITEM_PRICE_3 = 1000;

    public void change(int item_number_1,int item_number_2,int item_number_3,int put_money){

        int d;
        int c;

        d = item_number_1 * ITEM_PRICE_1 + item_number_2*ITEM_PRICE_2 + item_number_3*ITEM_PRICE_3;
        c = put_money - d;

        System.out.println("총금액 : " + d);
        System.out.println("잔돈은 : " + c);

    }
}