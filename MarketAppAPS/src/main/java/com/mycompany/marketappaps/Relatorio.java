/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marketappaps;

//PDF library
import com.itextpdf.layout.Document;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Table;
import java.io.*;

import java.time.LocalDate;
import java.sql.*;

/**
 *
 * @author luis
 */
public class Relatorio {

    private final LocalDate date;
    private int previousMonth;
    private int currentMonth;
    private int currentYear;
    private ResultSet set;
    private final Connection con;

    public Relatorio(Connection con, int previousMonth) {
        //Salva a data atual
        this.set = null;
        this.con = con;
        this.date = LocalDate.now();
        this.previousMonth = previousMonth;
        currentMonth = date.getMonth().getValue();
        currentYear = date.getYear();
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

    public String updateGanhoProdEst() {

        try {

            PreparedStatement ptmt = con.prepareStatement("SELECT \n"
                    + "    SUM(quantidade) AS q\n"
                    + "FROM\n"
                    + "    produtos\n"
                    + "WHERE\n"
                    + "    MONTH(data_cadastramento) <= ?\n"
                    + "        AND YEAR(data_cadastramento) <= ?");

            ptmt.setInt(1, previousMonth);
            ptmt.setInt(2, currentYear);
            set = ptmt.executeQuery();
            set.next();

            if (set == null)
                return "Sem dados.";
            
            String stg = set.getString("q");
            
            if (stg == null)
                return "Sem dados.";
            
            float mesAnterior = Float.parseFloat(set.getString("q"));
            float mesAtual = Float.parseFloat(updateQntdProdEst());

            if (mesAnterior == 0)
                return "Sem dados.";
                
            return String.valueOf(((mesAtual - mesAnterior) / mesAnterior) * 100) + " %";

        } catch (SQLException err) {
            err.printStackTrace();
        }

        return "error";

    }

    public String updateQntdVendas() {
        try {
            PreparedStatement ptmt = con.prepareStatement(
                    "select count(venda_id) as q"
                    + " from vendas where MONTH(data) = ? and YEAR(data) = ?"
            );

            ptmt.setInt(1, currentMonth);
            ptmt.setInt(2, currentYear);
            set = ptmt.executeQuery();
            set.next();
            return set.getString("q");

        } catch (SQLException err) {
            err.printStackTrace();
        }
        return "error";
    }

    public String updateGanhoQntdVendas() {
        try {
            PreparedStatement ptmt = con.prepareStatement(
                    "select count(venda_id) as q"
                    + " from vendas where MONTH(data) = ? and YEAR(data) = ?"
            );

            ptmt.setInt(1, previousMonth);
            ptmt.setInt(2, currentYear);
            set = ptmt.executeQuery();
            set.next();

            if (set == null)
                return "Sem dados.";
            
            String stg = set.getString("q");
            
            if (stg == null)
                return "Sem dados.";
            
            float mesAnterior = Float.parseFloat(set.getString("q"));
            float mesAtual = Float.parseFloat(updateQntdVendas());

            if (mesAnterior == 0)
                return "Sem dados.";
            
            return String.valueOf(((mesAtual - mesAnterior) / mesAnterior) * 100) + " %";

        } catch (SQLException err) {
            err.printStackTrace();
        }
        return "error";
    }

    public String valorTotalVendasMes(int mes) {
        
        try {
            PreparedStatement ptmt = con.prepareStatement(
                    "SELECT \n"
                    + "    SUM(valortotalvenda) AS q\n"
                    + "FROM\n"
                    + "    (SELECT \n"
                    + "        venda_id, preco_venda * vendas.quantidade AS valortotalvenda\n"
                    + "    FROM\n"
                    + "        produtos\n"
                    + "    JOIN vendas USING (prod_id)\n"
                    + "    where month(data) = ? and year(data) = ?\n"
                    + "    GROUP BY venda_id) derived"
            );

            ptmt.setInt(1, mes);
            ptmt.setInt(2, currentYear);
            set = ptmt.executeQuery();
            set.next();
            return set.getString("q");

        } catch (SQLException err) {
            err.printStackTrace();
        }

        return "error";
        
    }
    
    public String updateValorTotalVendas() {

        
        String total = valorTotalVendasMes(currentMonth);
        return total;
             
    }

    public String updateGanhoValorTotalVendas() {
            
        String mesAnteriorS = valorTotalVendasMes(previousMonth);
        String mesAtualS = valorTotalVendasMes(currentMonth);

        if (mesAnteriorS == null || mesAtualS == null)
            return "Sem dados.";

        float mesAnterior = Float.parseFloat(mesAnteriorS);
        float mesAtual = Float.parseFloat(mesAtualS);

        if (mesAnterior == 0 || mesAtual == 0)
            return "Sem dados.";

        return String.valueOf(((mesAtual - mesAnterior) / mesAnterior) * 100) + " %";

    }

    public String updateGastosEntregas() {

        try {

            PreparedStatement ptmt = con.prepareStatement(
                    "select sum(custo_entrega) as q"
                    + " from vendas where MONTH(data) = ? and YEAR(data) = ?"
            );

            ptmt.setInt(1, currentMonth);
            ptmt.setInt(2, currentYear);
            set = ptmt.executeQuery();
            set.next();
            return set.getString("q");

        } catch (SQLException sqle1) {
            sqle1.printStackTrace();
        }

        return "error";
    }

    public String updateGanhoGastosEntregas() {

        try {

            PreparedStatement ptmt = con.prepareStatement(
                    "select sum(custo_entrega) as q"
                    + " from vendas where MONTH(data) = ? and YEAR(data) = ?"
            );

            ptmt.setInt(1, previousMonth);
            ptmt.setInt(2, currentYear);
            set = ptmt.executeQuery();
            set.next();

            if (set == null)
                return "Sem dados.";
            
            String stg = set.getString("q");
            
            if (stg == null)
                return "Sem dados.";
            
            float mesAnterior = Float.parseFloat(set.getString("q"));
            float mesAtual = Float.parseFloat(updateGastosEntregas());

            if (mesAnterior == 0)
                return "Sem dados.";
            
            return String.valueOf(((mesAtual - mesAnterior) / mesAnterior) * 100) + " %";

        } catch (SQLException sqle1) {
            sqle1.printStackTrace();
        }

        return "error";

    }

    public String updateGastoProdutos() {

        try {

            PreparedStatement ptmt = con.prepareStatement("SELECT \n"
                    + "    SUM(custo) AS q\n"
                    + "FROM\n"
                    + "    (SELECT \n"
                    + "        preco * quantidade AS custo\n"
                    + "    FROM\n"
                    + "        produtos\n"
                    + "    WHERE\n"
                    + "        MONTH(data_cadastramento) = ?\n"
                    + "            AND YEAR(data_cadastramento) = ?\n"
                    + "    GROUP BY prod_id) derived");

            ptmt.setInt(1, currentMonth);
            ptmt.setInt(2, currentYear);
            set = ptmt.executeQuery();
            set.next();
            return set.getString("q");

        } catch (SQLException sqle1) {
            sqle1.printStackTrace();
        }

        return "error";

    }

    public String updateGanhoGastoProdutos() {
        try {

            PreparedStatement ptmt = con.prepareStatement("SELECT \n"
                    + "    SUM(custo) AS q\n"
                    + "FROM\n"
                    + "    (SELECT \n"
                    + "        preco * quantidade AS custo\n"
                    + "    FROM\n"
                    + "        produtos\n"
                    + "    WHERE\n"
                    + "        MONTH(data_cadastramento) = ?\n"
                    + "            AND YEAR(data_cadastramento) = ?\n"
                    + "    GROUP BY prod_id) derived");

            ptmt.setInt(1, previousMonth);
            ptmt.setInt(2, currentYear);
            set = ptmt.executeQuery();
            set.next();

            if (set == null)
                return "Sem dados.";
            
            String stg = set.getString("q");
            
            if (stg == null)
                return "Sem dados.";
            
            float mesAnterior = Float.parseFloat(set.getString("q"));
            float mesAtual = Float.parseFloat(updateGastoProdutos());

            if (mesAnterior == 0)
                return "Sem dados.";
            
            return String.valueOf(((mesAtual - mesAnterior) / mesAnterior) * 100) + " %";

        } catch (SQLException sqle1) {
            sqle1.printStackTrace();
        }

        return "error";
    }

    public String updateGastoTotal() {

        float gasto1 = Float.parseFloat(updateGastoProdutos());
        float gasto2 = Float.parseFloat(updateGastosEntregas());

        return String.valueOf(gasto1 + gasto2);

    }

    public String updateGanhoGastoTotal() {

        float gasto1Atual = Float.parseFloat(updateGastoProdutos());
        float gasto2Atual = Float.parseFloat(updateGastosEntregas());
        float gastoTotAtual = gasto1Atual + gasto2Atual;

        try {

            PreparedStatement ptmt = con.prepareStatement("SELECT \n"
                    + "    SUM(custo) AS q\n"
                    + "FROM\n"
                    + "    (SELECT \n"
                    + "        preco * quantidade AS custo\n"
                    + "    FROM\n"
                    + "        produtos\n"
                    + "    WHERE\n"
                    + "        MONTH(data_cadastramento) = ?\n"
                    + "            AND YEAR(data_cadastramento) = ?\n"
                    + "    GROUP BY prod_id) derived");

            ptmt.setInt(1, previousMonth);
            ptmt.setInt(2, currentYear);
            set = ptmt.executeQuery();
            set.next();

            if (set == null)
                return "Sem dados.";
            
            String stg = set.getString("q");
            
            if (stg == null)
                return "Sem dados.";
            
            float gasto1Anterior = Float.parseFloat(set.getString("q"));

            PreparedStatement ptmt2 = con.prepareStatement(
                    "select sum(custo_entrega) as q"
                    + " from vendas where MONTH(data) = ? and YEAR(data) = ?"
            );

            ptmt2.setInt(1, previousMonth);
            ptmt2.setInt(2, currentYear);
            set = ptmt2.executeQuery();
            set.next();
            
            if (set == null)
                return "Sem dados.";
            
            String stg2 = set.getString("q");
            
            if (stg2 == null)
                return "Sem dados.";
            
            float gasto2Anterior = Float.parseFloat(set.getString("q"));
            float gastoTotAnterior = gasto1Anterior + gasto2Anterior;

            if (gastoTotAnterior == 0)
                return "Sem dados.";
            
            return String.valueOf(((gastoTotAtual - gastoTotAnterior) / gastoTotAnterior) * 100) + " %";

        } catch (SQLException sqle1) {
            sqle1.printStackTrace();
        }

        return "error";
    }

    public String updateLucroTotal() {
        float gasto = Float.parseFloat(updateGastoTotal());
        float ganho = Float.parseFloat(updateValorTotalVendas());

        return String.valueOf(ganho - gasto);
    }

    public String updateGanhoLucroTotal() {
        float gastoAtual = Float.parseFloat(updateGastoTotal());
        float ganhoAtual = Float.parseFloat(updateValorTotalVendas());
        float lucroAtual = ganhoAtual - gastoAtual;

        try {

            PreparedStatement ptmt = con.prepareStatement("SELECT \n"
                    + "    SUM(custo) AS q\n"
                    + "FROM\n"
                    + "    (SELECT \n"
                    + "        preco * quantidade AS custo\n"
                    + "    FROM\n"
                    + "        produtos\n"
                    + "    WHERE\n"
                    + "        MONTH(data_cadastramento) = ?\n"
                    + "            AND YEAR(data_cadastramento) = ?\n"
                    + "    GROUP BY prod_id) derived");

            ptmt.setInt(1, previousMonth);
            ptmt.setInt(2, currentYear);
            set = ptmt.executeQuery();
            set.next();
            
            if (set == null)
                return "Sem dados.";
            
            String stg = set.getString("q");
            
            if (stg == null)
                return "Sem dados.";
            
            float gasto1Anterior = Float.parseFloat(set.getString("q"));

            PreparedStatement ptmt2 = con.prepareStatement(
                    "select sum(custo_entrega) as q"
                    + " from vendas where MONTH(data) = ? and YEAR(data) = ?"
            );

            ptmt2.setInt(1, previousMonth);
            ptmt2.setInt(2, currentYear);
            set = ptmt2.executeQuery();
            set.next();
            
            if (set == null)
                return "Sem dados.";
            
            String stg2 = set.getString("q");
            
            if (stg == null)
                return "Sem dados.";
            
            float gasto2Anterior = Float.parseFloat(set.getString("q"));
            float gastoTotAnterior = gasto1Anterior + gasto2Anterior;

            PreparedStatement ptmt3 = con.prepareStatement(
                    "SELECT \n"
                    + "    SUM(valortotalvenda) AS q\n"
                    + "FROM\n"
                    + "    (SELECT \n"
                    + "        venda_id, SUM(preco) * vendas.quantidade AS valortotalvenda\n"
                    + "    FROM\n"
                    + "        produtos\n"
                    + "    JOIN vendas USING (prod_id)\n"
                    + "    where month(data) = ? and year(data) = ?\n"
                    + "    GROUP BY venda_id) derived"
            );

            ptmt3.setInt(1, previousMonth);
            ptmt3.setInt(2, currentYear);
            set = ptmt3.executeQuery();
            set.next();
            
            if (set == null)
                return "Sem dados.";
            
            String stg3 = set.getString("q");
            
            if (stg == null)
                return "Sem dados.";
            
            float ganhoAnterior = Float.parseFloat(set.getString("q"));

            float lucroAnterior = ganhoAnterior - gastoTotAnterior;

            if (lucroAnterior == 0)
                return "Sem dados.";
            
            return String.valueOf(((lucroAtual - lucroAnterior) / lucroAnterior) * 100) + " %";

        } catch (SQLException sqle1) {
            sqle1.printStackTrace();
        }

        return "error";
    }

    public  boolean generateRelatorio(String filePath) {
        try {
            
            if (!filePath.toLowerCase().endsWith(".pdf")) {
                    filePath += ".pdf";
                }
            
            PdfDocument pdf = new PdfDocument(new PdfWriter(filePath));
            Document document = new Document(pdf);

            float columnWidth[] = {200f, 100f, 100f};
            Style s = new Style();
            s.setFontSize(10f);
            Table table = new Table(columnWidth).addStyle(s);

            table.addHeaderCell("");
            table.addHeaderCell("Dados");
            table.addHeaderCell("Ganho em Relação ao mês " + String.valueOf(previousMonth));

            table.addCell("Quantidade de produtos em estoque:");
            table.addCell(this.updateQntdProdEst());
            table.addCell(this.updateGanhoProdEst());
            table.addCell("Quantidade de vendas:");
            table.addCell(this.updateQntdVendas());
            table.addCell(this.updateGanhoQntdVendas());
            table.addCell("Valor total das vendas:");
            table.addCell(this.updateValorTotalVendas());
            table.addCell(this.updateGanhoValorTotalVendas());
            table.addCell("Gasto com entregas:");
            table.addCell(this.updateGastosEntregas());
            table.addCell(this.updateGanhoGastosEntregas());
            table.addCell("Gasto com produtos:");
            table.addCell(this.updateGastoProdutos());
            table.addCell(this.updateGanhoGastoProdutos());
            table.addCell("Gastos totais:");
            table.addCell(this.updateGastoTotal());
            table.addCell(this.updateGanhoGastoTotal());
            table.addCell("Lucros totais:");
            table.addCell(this.updateLucroTotal());
            table.addCell(this.updateGanhoLucroTotal());

            document.add(table);

            document.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
