package com.example.conexaojdbc.conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoPostgre implements ConexaoJDBC{
    @Override
    public Connection criarConexao() {
        try {
            //carregar o driver de conexão
            Class.forName("org.postgresql.Driver");
            //parâmetros
            String url = "jdbc:postgresql://localhost:5432/AlunosBD";
            String usuario = "postgres";
            String senha = "admin";
            //retorna a conexão com o banco de dados
            return DriverManager.getConnection(url, usuario, senha);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexaoPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
