/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.infox.dal;

import java.sql.*;
/**
 *
 * @author Matheus Alves
 */
public class ModuloConexao {

    //método responsável por estabelecer a conexão com o banco
    public static Connection conector() {
        java.sql.Connection conexao = null;
        // a linha abaixo chama o driver
        String Driver = "com.mysql.jdbc.Driver";
        //armazenando informações referente ao banco
        String url = "jdbc:mysql://192.168.0.30:3306/dbinfox";
        String user = "dba";
        String password = "123@Senac";
        //estabelecendo a conexao com o banco
        try {
            Class.forName(Driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            return null;
        }
    }
}
