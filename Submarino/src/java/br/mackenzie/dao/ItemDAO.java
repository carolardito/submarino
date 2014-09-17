/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dao;


import br.mackenzie.jdbc.ConnectionFactory;
import br.mackenzie.modelo.Item;
import br.mackenzie.modelo.Produto;
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
public class ItemDAO {
    private static Connection connection = null;
    
    public void inserir(Item item) throws SQLException, ClassNotFoundException{
        connection = ConnectionFactory.getInstance().getConnection();
        
        String sql = "INSERT INTO ITEM (COD_ITEM , COD_PRODUTO , QUANTIDADE) "
                + "VALUES (? , ? , ?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setInt(1, item.getCodItem());
        preparedStatement.setInt(2, item.getProduto().getCodProduto());
        preparedStatement.setInt(3, item.getQuantidade());        
        
        preparedStatement.executeUpdate();
        
        preparedStatement.close();
        connection.close();       
    } 
    
    public List<Item> listar() throws SQLException {
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "SELECT * FROM ITEM";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Item> items = new ArrayList<Item>();
        items.clear();
        while (resultSet.next()){
            ProdutoDAO produtoDAO = new ProdutoDAO();
            Item item = new Item();
            item.setCodItem(resultSet.getInt("COD_ITEM"));
            item.setProduto(produtoDAO.buscarPorCodigo(resultSet.getInt("COD_PRODUTO")));
            item.setQuantidade(resultSet.getInt("QUANTIDADE"));                    
            items.add(item);                
        } 
        
        preparedStatement.close();
        resultSet.close();
        connection.close();
        return items;
    }    
}
