package dao;

import com.example.conexaojdbc.Aluno;
import com.example.conexaojdbc.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AlunoDAO {

    public static void main(String[] args) {
        AlunoDAO dao = new AlunoDAO();
        System.out.println(dao.buscarAlunos().get(0).getNome());

    }

    public List<Aluno> buscarAlunos() {
        try {
            //criar um objeto Connection para receber a conexão
            Connection con = Conexao.criarConexao();
            //comando sql
            String sql = "select * from tb_aluno";
            PreparedStatement ps = con.prepareStatement(sql);
            //ResultSet, representa o resultado do comando SQL
            ResultSet rs = ps.executeQuery();
            //cria uma lista de alunos para retornar
            List<Aluno> alunos = new ArrayList();
            //laço para buscar todas os alunos do banco
            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setMatricula(rs.getString("matricula"));
                //add pessoa na lista
                alunos.add(a);
            }
            //retorna a lista de alunos
            return alunos;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
