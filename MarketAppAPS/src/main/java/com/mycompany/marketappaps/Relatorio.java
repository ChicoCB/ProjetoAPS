/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marketappaps;

//PDF library
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.layout.Document;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.kernel.pdf.tagging.StandardRoles;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.TabAlignment;
import com.itextpdf.layout.element.TabStop;
import com.itextpdf.layout.element.Tab;



import java.io.*;
import java.net.MalformedURLException;

import java.time.LocalDate;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Relatorio(Connection con, int currentMonth, int previousMonth) {
        //Salva a data atual
        this.set = null;
        this.con = con;
        this.date = LocalDate.now();
        this.previousMonth = previousMonth;
        this.currentMonth = currentMonth;
        currentYear = date.getYear();
    }

    public String produtosNovosMes(int mes) {

        try {
            PreparedStatement ptmt = con.prepareStatement("SELECT \n"
                    + "    SUM(quantidade) AS q\n"
                    + "FROM\n"
                    + "    produtos\n"
                    + "WHERE\n"
                    + "    MONTH(data_cadastramento) = ?\n"
                    + "        AND YEAR(data_cadastramento) = ?");

            ptmt.setInt(1, mes);
            ptmt.setInt(2, currentYear);
            set = ptmt.executeQuery();

            if (set.next()) {
                return set.getString("q");
            }
            return "0";

        } catch (SQLException err) {
            err.printStackTrace();
        }

        return "error";

    }

    public String updateProdutosNovos() {

        String total = produtosNovosMes(currentMonth);
        if (total == null) {
            total = "0";
        }

        return total;

    }

    public String updateGanhoProdutosNovos() {

        String mesAnteriorS = produtosNovosMes(previousMonth);
        String mesAtualS = produtosNovosMes(currentMonth);

        if (mesAnteriorS == null) {
            mesAnteriorS = "0";
        }
        if (mesAtualS == null) {
            mesAtualS = "0";
        }

        float mesAnterior = Float.parseFloat(mesAnteriorS);
        float mesAtual = Float.parseFloat(mesAtualS);

        if (mesAnterior == 0) {
            return "Sem dados do mês.";
        }

        return String.valueOf(((mesAtual - mesAnterior) / mesAnterior) * 100) + " %";

    }

    public String qntdVendasMes(int mes) {

        try {
            PreparedStatement ptmt = con.prepareStatement(
                    "select count(venda_id) as q"
                    + " from vendas where MONTH(data) = ? and YEAR(data) = ?"
            );

            ptmt.setInt(1, mes);
            ptmt.setInt(2, currentYear);
            set = ptmt.executeQuery();
            if (set.next()) {
                return set.getString("q");
            }
            return "0";

        } catch (SQLException err) {
            err.printStackTrace();
        }
        return "error";

    }

    public String updateQntdVendas() {
        String total = qntdVendasMes(currentMonth);
        if (total == null) {
            total = "0";
        }
        return total;
    }

    public String updateGanhoQntdVendas() {

        String mesAnteriorS = qntdVendasMes(previousMonth);
        String mesAtualS = qntdVendasMes(currentMonth);

        if (mesAnteriorS == null) {
            mesAnteriorS = "0";
        }
        if (mesAtualS == null) {
            mesAtualS = "0";
        }

        float mesAnterior = Float.parseFloat(mesAnteriorS);
        float mesAtual = Float.parseFloat(mesAtualS);

        if (mesAnterior == 0) {
            return "Sem dados do mês.";
        }

        return String.valueOf(((mesAtual - mesAnterior) / mesAnterior) * 100) + " %";
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
            if (set.next()) {
                return set.getString("q");
            }

            return "0";

        } catch (SQLException err) {
            err.printStackTrace();
        }

        return "error";

    }

    public String updateValorTotalVendas() {

        String total = valorTotalVendasMes(currentMonth);
        if (total == null) {
            total = "0";
        }
        return total;

    }

    public String updateGanhoValorTotalVendas() {

        String mesAnteriorS = valorTotalVendasMes(previousMonth);
        String mesAtualS = valorTotalVendasMes(currentMonth);

        if (mesAnteriorS == null) {
            mesAnteriorS = "0";
        }
        if (mesAtualS == null) {
            mesAtualS = "0";
        }

        float mesAnterior = Float.parseFloat(mesAnteriorS);
        float mesAtual = Float.parseFloat(mesAtualS);

        if (mesAnterior == 0) {
            return "Sem dados do mês.";
        }

        return String.valueOf(((mesAtual - mesAnterior) / mesAnterior) * 100) + " %";

    }

    public String gastoEntregaMes(int mes) {

        try {

            PreparedStatement ptmt = con.prepareStatement(
                    "select sum(custo_entrega) as q"
                    + " from vendas where MONTH(data) = ? and YEAR(data) = ?"
            );

            ptmt.setInt(1, mes);
            ptmt.setInt(2, currentYear);
            set = ptmt.executeQuery();
            if (set.next()) {
                return set.getString("q");
            }

            return "0";

        } catch (SQLException sqle1) {
            sqle1.printStackTrace();
        }

        return "error";

    }

    public String updateGastosEntregas() {

        String total = gastoEntregaMes(currentMonth);
        if (total == null) {
            total = "0";
        }
        return total;

    }

    public String updateGanhoGastosEntregas() {

        String mesAnteriorS = gastoEntregaMes(previousMonth);
        String mesAtualS = gastoEntregaMes(currentMonth);

        if (mesAnteriorS == null) {
            mesAnteriorS = "0";
        }
        if (mesAtualS == null) {
            mesAtualS = "0";
        }

        float mesAnterior = Float.parseFloat(mesAnteriorS);
        float mesAtual = Float.parseFloat(mesAtualS);

        if (mesAnterior == 0) {
            return "Sem dados do mês.";
        }

        return String.valueOf(((mesAtual - mesAnterior) / mesAnterior) * 100) + " %";

    }

    public String gastoProdutosMes(int mes) {

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

            ptmt.setInt(1, mes);
            ptmt.setInt(2, currentYear);
            set = ptmt.executeQuery();
            if (set.next()) {
                return set.getString("q");
            }

            return "0";

        } catch (SQLException sqle1) {
            sqle1.printStackTrace();
        }

        return "error";

    }

    public String updateGastoProdutos() {

        String total = gastoProdutosMes(currentMonth);
        if (total == null) {
            total = "0";
        }
        return total;

    }

    public String updateGanhoGastoProdutos() {
        String mesAnteriorS = gastoProdutosMes(previousMonth);
        String mesAtualS = gastoProdutosMes(currentMonth);

        if (mesAnteriorS == null) {
            mesAnteriorS = "0";
        }
        if (mesAtualS == null) {
            mesAtualS = "0";
        }

        float mesAnterior = Float.parseFloat(mesAnteriorS);
        float mesAtual = Float.parseFloat(mesAtualS);

        if (mesAnterior == 0) {
            return "Sem dados do mês.";
        }

        return String.valueOf(((mesAtual - mesAnterior) / mesAnterior) * 100) + " %";
    }

    public String gastoTotalMes(int mes) {

        String gastoProdS = gastoProdutosMes(mes);
        String gastoEntregaS = gastoEntregaMes(mes);

        if (gastoProdS == null) {
            gastoProdS = "0";
        }
        if (gastoEntregaS == null) {
            gastoEntregaS = "0";
        }

        float gastoProd = Float.parseFloat(gastoProdS);
        float gastoEntrega = Float.parseFloat(gastoEntregaS);

        return String.valueOf(gastoProd + gastoEntrega);

    }

    public String updateGastoTotal() {

        String total = gastoTotalMes(currentMonth);
        if (total == null) {
            total = "0";
        }
        return total;
    }

    public String updateGanhoGastoTotal() {

        String mesAnteriorS = gastoTotalMes(previousMonth);
        String mesAtualS = gastoTotalMes(currentMonth);

        if (mesAnteriorS == null) {
            mesAnteriorS = "0";
        }
        if (mesAtualS == null) {
            mesAtualS = "0";
        }

        float mesAnterior = Float.parseFloat(mesAnteriorS);
        float mesAtual = Float.parseFloat(mesAtualS);

        if (mesAnterior == 0) {
            return "Sem dados do mês.";
        }

        return String.valueOf(((mesAtual - mesAnterior) / mesAnterior) * 100) + " %";

    }

    public String lucroTotalMes(int mes) {

        String gastoTotalS = gastoTotalMes(mes);
        String ganhoS = valorTotalVendasMes(mes);

        if (gastoTotalS == null) {
            gastoTotalS = "0";
        }
        if (ganhoS == null) {
            ganhoS = "0";
        }

        float gastoTotal = Float.parseFloat(gastoTotalS);
        float ganho = Float.parseFloat(ganhoS);

        return String.valueOf(ganho - gastoTotal);

    }

    public String updateLucroTotal() {
        String total = lucroTotalMes(currentMonth);
        if (total == null) {
            total = "0";
        }
        return total;
    }

    public String updateGanhoLucroTotal() {
        String mesAnteriorS = lucroTotalMes(previousMonth);
        String mesAtualS = lucroTotalMes(currentMonth);

        if (mesAnteriorS == null) {
            mesAnteriorS = "0";
        }
        if (mesAtualS == null) {
            mesAtualS = "0";
        }

        float mesAnterior = Float.parseFloat(mesAnteriorS);
        float mesAtual = Float.parseFloat(mesAtualS);

        if (mesAnterior == 0) {
            return "Sem dados do mês.";
        }

        if (mesAtual > mesAnterior) {
            return String.valueOf(Math.abs((mesAtual - mesAnterior) / mesAnterior) * 100) + " %";
        }

        return String.valueOf(((mesAtual - mesAnterior) / mesAnterior) * 100) + " %";
    }

    public boolean generateRelatorio(String filePath) {
        try {

            if (!filePath.toLowerCase().endsWith(".pdf")) {
                filePath += ".pdf";
            }

            PdfDocument pdf = new PdfDocument(new PdfWriter(filePath));
            Document document = new Document(pdf);

            String Title = "Chico é Gay & CIA";
           Paragraph p = new Paragraph();
           p.setFontColor(new DeviceRgb(8, 73, 117))
              .setFontSize(20f);
           p.getAccessibilityProperties().setRole(StandardRoles.H1);

           document.add(p);
 
            addParagraphCentered(pdf,document,p,Title);

            float columnWidth[] = {200f, 100f, 100f};
            Style s = new Style();
            s.setFontSize(10f);
            Table table = new Table(columnWidth).addStyle(s)
                    .setFixedPosition(50f, 500f, 500f);
                    

            table.addHeaderCell("");
            table.addHeaderCell("Dados do mês: " + String.valueOf(currentMonth));
            table.addHeaderCell("Ganho em Relação ao mês: " + String.valueOf(previousMonth));

            table.addCell("Quantidade de produtos em estoque:");
            table.addCell(this.updateProdutosNovos());
            table.addCell(this.updateGanhoProdutosNovos());
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

            String imageFile = new File("src/main/java/com/mycompany/marketappaps/assets/monkey.png")
                    .getAbsolutePath();
            try {

                ImageData data = ImageDataFactory.create(imageFile);
                Image img = new Image(data)
                        .setFixedPosition(500f, 10f)
                        .scaleAbsolute(100f, 100f);
                Paragraph p3 = new Paragraph();
                p3.add(img);
                document.add(p3);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
            }

            document.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    private void addParagraphCentered(PdfDocument pdf, Document doc, Paragraph p, String s) {
        PageSize pageSize = pdf.getDefaultPageSize();
        float width = pageSize.getWidth() - doc.getLeftMargin() - doc.getRightMargin();
        List<TabStop> tabStops = new ArrayList<>();
        // Create a TabStop at the middle of the page
        SolidLine line = new SolidLine();
        tabStops.add(new TabStop(width / 2, TabAlignment.CENTER, line));

        // Create a TabStop at the end of the page
        tabStops.add(new TabStop(width, TabAlignment.LEFT, line));

        p.addTabStops(tabStops);
        p
                .add(new Tab())
                .add(s)
                .add(new Tab());
        doc.add(p);

    }

}
