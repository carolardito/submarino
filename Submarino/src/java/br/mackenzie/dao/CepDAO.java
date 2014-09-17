/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dao;


import br.mackenzie.jdbc.ConnectionFactory;
import br.mackenzie.modelo.Cep;
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
public class CepDAO {
    private static Connection connection = null;
    
    public void inserir(Cep cep) throws SQLException, ClassNotFoundException{
        connection = ConnectionFactory.getInstance().getConnection();
        
        String sql = "INSERT INTO CEPS (CEP , PRECO) "
                + "VALUES (? , ?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setString(1, cep.getCep());
        preparedStatement.setDouble(2, cep.getPreco());        
        
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
