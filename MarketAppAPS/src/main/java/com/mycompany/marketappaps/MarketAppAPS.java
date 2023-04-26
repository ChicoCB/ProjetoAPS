/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.marketappaps;
/**
 *
 * @author luis
 */
public class MarketAppAPS {

    public static void main(String[] args) {
        
        System.out.println("Hello World!");
        
        // Creates principal window
        MainFrame mfrm = new MainFrame();
        
        mfrm.setSize(400, 300);
        mfrm.setVisible(true);
        
        mfrm.switchPanel("login panel"); // show panel 1 by defaul
        
    }
}
