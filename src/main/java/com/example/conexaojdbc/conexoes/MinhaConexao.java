package com.example.conexaojdbc.conexoes;

import java.sql.Connection;

public class MinhaConexao {
    public static Connection conexao(){
        ConexaoJDBC conexao = new ConexaoPostgre();
        return conexao.criarConexao();
    }
}
