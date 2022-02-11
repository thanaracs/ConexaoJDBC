package com.example.conexaojdbc.conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoPostgre implements ConexaoJDBC{
    public static void main(String[] args) {

        //testar conexão
        System.out.println(new ConexaoPostgre().criarConexao());

    }

    @Override
    public Connection criarConexao() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/alunosBD";
            String usuario = "postgres";
            String senha = "admin";

            return DriverManager.getConnection(url, usuario, senha);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexaoPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
