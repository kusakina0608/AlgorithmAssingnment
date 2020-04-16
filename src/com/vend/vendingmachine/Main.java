package com.vend.vendingmachine;

import com.vend.service.ChangeService;
import com.vend.view.VendingMachineView;

public class Main {
    public static void main(String[] args) {
        //new VendingMachineView();
        new ChangeService().change(1,2,4,500000);
    }

}
