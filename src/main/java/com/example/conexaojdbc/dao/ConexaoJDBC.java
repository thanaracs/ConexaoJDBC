package com.example.conexaojdbc.dao;

import java.sql.Connection;

public interface ConexaoJDBC {
    public Connection criarConexao();
}
