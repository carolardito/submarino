/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dao;


import br.mackenzie.jdbc.ConnectionFactory;
import br.mackenzie.modelo.Carrinho;
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
        
        String sql = "INSERT INTO ITEM (COD_PRODUTO, COD_CARRINHO, QUANTIDADE) "
                + "VALUES (? , ? , ?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        //preparedStatement.setInt(1, item.getCodItem());
        preparedStatement.setInt(1, item.getProduto().getCodProduto());
        preparedStatement.setInt(2, item.getProduto().getCodProduto());
        preparedStatement.setInt(3, item.getQuantidade());        
        
        preparedStatement.executeUpdate();
        
        preparedStatement.close();
        connection.close();       
    } 
    
    public List<Item> listar() throws SQLException {
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "SELECT * FROM ITEM "
                + "INNER JOIN PRODUTO "
                + "ON ITEM.COD_PRODUTO = PRODUTO.COD_PRDUTO ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Item> items = new ArrayList<Item>();
        items.clear();
        while (resultSet.next()){
            Produto produto = new Produto();            
            produto.setCodProduto(resultSet.getInt("COD_PRODUTO"));
            produto.setDescricao(resultSet.getString("DESCRICAO"));
            produto.setNomeProduto(resultSet.getString("NOME_PRODUTO"));
            produto.setPreco(resultSet.getDouble("PRECO"));
            
            Item item = new Item();         
            item.setProduto(produto);
            item.setCodCarrinho(resultSet.getInt("COD_CARRINHO"));            
            item.setQuantidade(resultSet.getInt("QUANTIDADE"));                    
            
            items.add(item);                
        } 
        
        preparedStatement.close();
        resultSet.close();
        connection.close();
        return items;
    }    
    
    public List<Item> listarPorCarrinho(Carrinho carrinho) throws SQLException {
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "SELECT * FROM ITEM "
                + "INNER JOIN PRODUTO "
                + "ON ITEM.COD_PRODUTO = PRODUTO.COD_PRDUTO "
                + "WHERE COD_CARRINHO = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, carrinho.getCodCarrinho());
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Item> items = new ArrayList<Item>();
        items.clear();        
            
        while (resultSet.next()){
               
            Produto produto = new Produto();            
            produto.setCodProduto(resultSet.getInt("COD_PRODUTO"));
            produto.setDescricao(resultSet.getString("DESCRICAO"));
            produto.setNomeProduto(resultSet.getString("NOME_PRODUTO"));
            produto.setPreco(resultSet.getDouble("PRECO"));
            
            Item item = new Item();         
            item.setProduto(produto);
            item.setCodCarrinho(resultSet.getInt("COD_CARRINHO"));            
            item.setQuantidade(resultSet.getInt("QUANTIDADE"));                    
            
            items.add(item);                
        } 
        
        preparedStatement.close();
        resultSet.close();
        connection.close();
        return items;
    }    
    
    public Item buscarPorCodigo(Item item) throws SQLException {
        connection = ConnectionFactory.getInstance().getConnection();        
        String sql = "SELECT QUANTIDADE FROM ITEM WHERE COD_PRODUTO = ? AND COD_CARRINHO = ?";
                      
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, item.getProduto().getCodProduto());        
        preparedStatement.setInt(2, item.getCodCarrinho());        
        
        ResultSet resultSet = preparedStatement.executeQuery();        
        resultSet.next();        
        
        item.setQuantidade(resultSet.getInt("QUANTIDADE"));                
        
        preparedStatement.close();
        resultSet.close();
        connection.close();
        
        return item;
    }
    
    public void excluir(Item item) throws SQLException {
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "DELETE FROM ITEM WHERE COD_CARRINHO = ? AND COD_PRODUTO = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, item.getCodCarrinho());
        preparedStatement.setInt(2, item.getProduto().getCodProduto());
        preparedStatement.executeUpdate();            
        
        preparedStatement.close();        
        connection.close();        
    }
    
    public void atualizar(Item item) throws SQLException {
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "UPDATE ITEM SET QUANTIDADE = ? "
                + "WHERE COD_PRODUTO = ? AND COD_CARRINHO = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, item.getQuantidade());
        preparedStatement.setInt(2, item.getProduto().getCodProduto());            
        preparedStatement.setInt(3, item.getCodCarrinho());            
        preparedStatement.executeUpdate();            
        
        preparedStatement.close();        
        connection.close();                
    }
}
