/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.DAO.RoupaDAO;
import model.Roupa;

/**
 *
 * @author gilma
 */
public class RoupaController {
     public void cadastrarJogo(int Codigo,String Cor,String Categoria, Double preco) throws SQLException{
        System.out.println(Cor);
        System.out.println(Codigo);
        System.out.println(Categoria);
        System.out.println(preco);
        
        Roupa m1 = new Roupa(Cor, Codigo,Categoria,preco);
        
        RoupaDAO md = new RoupaDAO();
        md.inserirRoupa(m1);
    }
    
    public void excluirRoupa(int Codigo) throws SQLException {
        RoupaDAO md = new RoupaDAO();       
        md.excluirRoupa(Codigo);
        System.out.println("LLLLL");
    }
    /*Especifico*/
    public ArrayList<Roupa> buscarRoupasController(String Nome) throws SQLException {
        RoupaDAO jDAO = new RoupaDAO();
        return (jDAO.buscarRoupasespe(Nome));
    }
    /*BuscarTodos*/
    public ArrayList<Roupa> buscarRoupastodosController() throws SQLException{
        RoupaDAO fDAO = new RoupaDAO();
        return (fDAO.buscarRoupas());
    }
}
