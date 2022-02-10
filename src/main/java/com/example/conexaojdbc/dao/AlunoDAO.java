package com.example.conexaojdbc.dao;

import com.example.conexaojdbc.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDAO {
    Connection con;
    public List<Aluno> buscarAlunos() {
        try {
            //comando sql
            String sql = "select * from tb_alunos";
            PreparedStatement ps = con.prepareStatement(sql);
            //ResultSet, representa o resultado do comando SQL
            ResultSet rs = ps.executeQuery();
            //cria uma lista de pessoas para retornar
            List<Aluno> alunos = new ArrayList<>();
            //laço para buscar todas as pessoas do banco
            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setMatricula(rs.getString("matricula"));
                //add pessoa na lista
                alunos.add(a);
                Logger.getLogger("Alunos: " + a.getId() + " - " + a.getNome() + a.getMatricula()).log(Level.WARNING, null, a);
            }
            //retorna a lista de pessoas
            return alunos;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
