/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import connection.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Roupa;

/**
 *
 * @author aluno
 */
public class RoupaDAO {
    Connection con;
    
    public void inserirRoupa(Roupa m1) throws SQLException{
        con = new connection().getConnection();
        String sql = "Insert into CadastroJogos (Codigo,Cor,Categoria,preco) values (?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, m1.getCodigo());
        stmt.setString(2, m1.getCor());
        
        stmt.setString(3,m1.getCategoria());
        stmt.setDouble(4,m1.getPreco());
                
        stmt.execute();
        stmt.close();
        con.close();
    }
    public void excluirRoupa(int Codigo) throws SQLException{
        con = new connection().getConnection();
        String sql = "DELETE FROM CadastroRoupas WHERE codigo = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, Codigo);
        stmt.execute();
        stmt.close();
        con.close();
        System.out.println("PPPPPPP");
    }
    /*Todos*/
    public ArrayList<Roupa> buscarRoupas() throws SQLException {
        ArrayList<Roupa> listaRoupas = new ArrayList<Roupa>();
        ResultSet rs;
        con = new connection().getConnection();

        String sql = "SELECT * FROM CadastroRoupas";
        PreparedStatement stmt = con.prepareStatement(sql);
        rs = stmt.executeQuery();

        while (rs.next()) {
          
            String cor = rs.getString("cor");
            int codigo = rs.getInt("codigo");
            String categoria = rs.getString("categoria");
            double preco = rs.getDouble("preco");
            
          
            Roupa j = new Roupa(cor, codigo, categoria, preco);
            listaRoupas.add(j);
        }

        stmt.close();
        con.close();
        return listaRoupas;
    }
    
    /*Característica específica*/
    public ArrayList<Roupa> buscarRoupasespe(String corRoupa) throws SQLException {
        ResultSet rs;
        ArrayList<Roupa> RoupaBuscaTipo = new ArrayList<Roupa>();
        
        con = new connection().getConnection();
        String sql = "SELECT * FROM CadastroRoupas WHERE cor LIKE ?";
        PreparedStatement stmt = con.prepareStatement(sql); 
        stmt.setString(1, corRoupa + "%");
        rs = stmt.executeQuery();
        while (rs.next()) {
            String cor = rs.getString("cor");
            int codigo = rs.getInt("codigo");
            String categoria = rs.getString("categoria");
            double preco = rs.getDouble("preco");
            
          
            Roupa RoupasEncontrados = new Roupa(cor, codigo, categoria, preco);
            
            RoupaBuscaTipo.add(RoupasEncontrados);
        }
        stmt.close();
        con.close();
        return RoupaBuscaTipo;
        
    }
    
}
