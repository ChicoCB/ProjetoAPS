package Teste;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.pdf.*;
import static com.itextpdf.kernel.pdf.PdfName.Color;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import java.io.*;

public class Teste {

    public static void main(String[] args) {
        generateRelatorio();
    }

      private static boolean generateRelatorio() {
        try {

            File new_dir = new File("Relatorio");

            if (!new_dir.exists()) {
                new_dir.mkdir();
            }

            String path_to_relatorio = new_dir.getAbsolutePath();
            String file_name = path_to_relatorio + "/ Relatorio.pdf";
            PdfDocument pdf = new PdfDocument(new PdfWriter(file_name));
            Document document = new Document(pdf);

            float columnWidth[] = {200f, 100f, 100f};
             Style s = new Style();
             s.setFontSize(10f);
             Table table = new Table(columnWidth).addStyle(s);
            
           
            table.addHeaderCell("");
            table.addHeaderCell("Dados");
            table.addHeaderCell("Ganho em Relação ao mês anterior");
            
            table.addCell("Quantidade de produtos em estoque:");
            table.addCell("");
            table.addCell("");
            table.addCell("Quantidade de vendas:");
            table.addCell("");
            table.addCell("");
            table.addCell("Valor total das vendas:");
            table.addCell("");
            table.addCell("");
            table.addCell("Gasto com entregas:");
            table.addCell("");
            table.addCell("");
            table.addCell("Gasto com produtos:");
            table.addCell("");
            table.addCell("");
            table.addCell("Gastos totais:");
            table.addCell("");
            table.addCell("");
            table.addCell("Lucros totais:");
            table.addCell("");
            table.addCell("");

            document.add(table);

            document.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return false;
    }
}
