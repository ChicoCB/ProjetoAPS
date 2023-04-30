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

        // Define principal window
        MainFrame mfrm = new MainFrame();
        
        //Create and display the GUI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mfrm.setVisible(true);
            }
        });

    }
}
