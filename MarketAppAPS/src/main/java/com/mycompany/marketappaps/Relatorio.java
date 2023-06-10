/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marketappaps;

import java.time.LocalDate;
import java.sql.*;

/**
 *
 * @author luis
 */
public class Relatorio {

    private final LocalDate date;
    private ResultSet set;
    private final Connection con;

    public Relatorio(Connection con) {
        //Salva a data atual
        this.set = null;
        this.con = con;
        this.date = LocalDate.now();

    }

    public String updateQntdProdEst() {
        try {

            PreparedStatement ptmt = con.prepareStatement(
                    "select sum(quantidade) as q "
                    + "from produtos");

            set = ptmt.executeQuery();
            set.next();
            return set.getString("q");

        } catch (SQLException err) {
            err.printStackTrace();
        }

        return "error";
    }

    public String updateQntdVendas() {
        try {
            PreparedStatement ptmt = con.prepareStatement(
                    "select count(venda_id) as q"
                    + " from vendas"
            );

            set = ptmt.executeQuery();
            set.next();
            return set.getString("q");

        } catch (SQLException err) {
            err.printStackTrace();
        }
        return "error";
    }

    public String updateValorTotalVendas() {

        try {
            PreparedStatement ptmt = con.prepareStatement(
                    "select sum(valortotalvenda) as q from (select venda_id, sum(preco)*vendas.quantidade as valortotalvenda from produtos join vendas using(prod_id)\n" +
"group by venda_id) derived"
            );

            set = ptmt.executeQuery();
            set.next();
            return set.getString("q");

        } catch (SQLException err) {
            err.printStackTrace();
        }

        return "error";
    }

    public String updateClientesNovos() {
        return "error";
    }

    public String updateGastosEntregas() {
        return "error";
    }

    public String updateGastoProdutos() {
        return "erro";
    }

    public String updateGastoTotal() {
        return "erro";
    }

    public String updateLucroTotal() {
        return "erro";
    }

}
