/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dao;


import br.mackenzie.jdbc.ConnectionFactory;
import br.mackenzie.modelo.Carrinho;
import br.mackenzie.modelo.Cep;
import br.mackenzie.modelo.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Ricardo
 */
public class CarrinhoDAO {
    private static Connection connection = null;
    
    public void inserir(Carrinho carrinho) throws SQLException, ClassNotFoundException{        
        connection = ConnectionFactory.getInstance().getConnection();        
                
        String sql = "INSERT INTO CARRINHO (COD_CARRINHO , CEP) "
                + "VALUES (? , ?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setInt(1, carrinho.getCodCarrinho());
        preparedStatement.setString(2, carrinho.getCep().getCep()); 
        
        for (Item  item : carrinho.getItems()) {
            item.
            
        }
        
        
        
        preparedStatement.executeUpdate();
        
        preparedStatement.close();
        connection.close();       
    } 
    
    public List<Cep> listar() throws SQLException {
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "SELECT * FROM CEPS";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Cep> ceps = new ArrayList<Cep>();
        ceps.clear();
        while (resultSet.next()){
            Cep cep = new Cep();
            cep.setCep(resultSet.getString("CEP"));
            cep.setPreco(resultSet.getDouble("PRECO"));
            
            ceps.add(cep);                
        } 
        
        preparedStatement.close();
        resultSet.close();
        connection.close();
        return ceps;
    }    
}
