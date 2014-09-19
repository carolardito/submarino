/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dao;


import br.mackenzie.jdbc.ConnectionFactory;
import br.mackenzie.modelo.Carrinho;
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
    
    public Item buscarPorCodigo(int codItem) throws SQLException {
        connection = ConnectionFactory.getInstance().getConnection();
        Item item = new Item();
        String sql = "SELECT * FROM ITEM WHERE COD_ITEM = ?";
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();        
        resultSet.next();
        
        item.setCodItem(resultSet.getInt("COD_ITEM"));
        item.setQuantidade(resultSet.getInt("QUANTIDADE"));
        item.setProduto(produtoDAO.buscarPorCodigo(resultSet.getInt("COD_ITEM")));       
        
        preparedStatement.close();
        resultSet.close();
        connection.close();
        
        return item;
    }
    
    public void excluir(int codItem) throws SQLException {
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "DELETE FROM ITEM WHERE COD_ITEM = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, codItem);
        preparedStatement.executeUpdate();            
        
        preparedStatement.close();        
        connection.close();        
    }
    
    public void atualizar(Item item) throws SQLException {
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "UPDATE ITEM SET QUANTIDADE = ? WHERE COD_ITEM = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, item.getQuantidade());
        preparedStatement.setInt(2, item.getCodItem());            
        preparedStatement.executeUpdate();            
        
        preparedStatement.close();        
        connection.close();                
    }
}
