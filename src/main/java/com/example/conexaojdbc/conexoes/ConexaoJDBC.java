package com.example.conexaojdbc.conexoes;

import java.sql.Connection;

public interface ConexaoJDBC {
    public Connection criarConexao();
}
