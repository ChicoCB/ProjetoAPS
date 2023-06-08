/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.marketappaps;

import java.io.*;
import java.sql.*;

/**
 *
 * @author luis
 */
public class MarketAppAPS {

    private static String db_url;
    private static String db_pass;

    public MarketAppAPS() throws Exception {
        
        File file = new File("src/main/java/com/mycompany/marketappaps/DB.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String[] url = br.readLine().split("=");
        String[] pass = br.readLine().split("=");

        MarketAppAPS.db_url = url[1];
        MarketAppAPS.db_pass = pass[1];
        
    }

    public static void main(String[] args)throws Exception {
        
        MarketAppAPS marketAppAPS = new MarketAppAPS();
        Connection con;
        String url = db_url;
        String user = "root";
        String password = db_pass;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException sqle1) {
            sqle1.printStackTrace();
            con = null;
        }

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
