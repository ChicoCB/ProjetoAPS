/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.marketappaps;

import java.sql.*;

/**
 *
 * @author luis
 */
public class MarketAppAPS {

    public static void main(String[] args) {
        Connection con;
        ResultSet rs;
        
        String url = "jdbc:mysql://localhost/projetoaps";
        String user = "root";
        String password = "fran3828";
        try {
          con = DriverManager.getConnection(url, user, password);
        } catch (SQLException sqle1) {
            sqle1.printStackTrace();
            con = null;
        }
        
        System.out.println("Hello World!");

        // Define principal window
        MainFrame mfrm = new MainFrame(con);
        
        //Create and display the GUI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mfrm.setVisible(true);
            }
        });

    }
}
