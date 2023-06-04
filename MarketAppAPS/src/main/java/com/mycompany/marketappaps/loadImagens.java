/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.marketappaps;
import java.sql.*;
import java.io.*;

/**
 *
 * @author franc
 */
public class loadImagens {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost/projetoaps";
        String usuario = "root";
        String senha = "fran3828";
        Connection con;
        
        //Carregamento das capas
        String caminho = "D:\\User\\Desktop\\ProjetoAPS\\blobzin";
        try {
            con = DriverManager.getConnection(url, usuario, senha); 
             // Lista de arquivos no diretório de imagens
            File[] imagens = new File(caminho).listFiles();
            if (imagens != null) {
                 // Loop através dos arquivos e carregar as imagens no banco de dados
                for (File imagem : imagens) {
                    if (imagem.isFile()) {
                        FileInputStream fis = new FileInputStream(imagem);

                        // Preparar a declaração SQL
                        String sql = "UPDATE produtos SET imagem = ? WHERE prod_id = ?";
                        PreparedStatement pstmt = con.prepareStatement(sql);

                        // Definir o valor do marcador de posição como o FileInputStream lido
                        pstmt.setBinaryStream(1, fis, (int) imagem.length());
                        String nomeArquivo = imagem.getName();
                        int posicaoPonto = nomeArquivo.lastIndexOf(".");
                        if (posicaoPonto > 0) {
                            nomeArquivo = nomeArquivo.substring(0, posicaoPonto);
                        }
                        pstmt.setInt(2,Integer.parseInt(nomeArquivo));

                        // Executar a atualização do banco de dados
                        int resultado = pstmt.executeUpdate();

                        // Fechar os recursos abertos
                        pstmt.close();
                        fis.close();

                        System.out.println("Imagem " + imagem.getName() + " carregada para o campo BLOB com sucesso!");
                    }
                }
            }
            con.close();
        } catch (FileNotFoundException fnfe1) {
           fnfe1.printStackTrace();
           System.exit(0);
        } catch (SQLException sqle1) {
            sqle1.printStackTrace();
            System.exit(0);
        } catch (IOException ioe1) {
            ioe1.printStackTrace();
            System.exit(0);
        }   
    }
}
