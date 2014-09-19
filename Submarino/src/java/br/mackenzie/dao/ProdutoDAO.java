/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dao;


import br.mackenzie.jdbc.ConnectionFactory;
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
public class ProdutoDAO {
    private static Connection connection = null;
    
    public void inserir(Produto produto ) throws SQLException, ClassNotFoundException{
        connection = ConnectionFactory.getInstance().getConnection();
        
        String sql = "INSERT INTO PRODUTO ( NOME_PRODUTO ,PRECO , "
                + "DESCRICAO) "
                + "VALUES (? , ? , ?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        //preparedStatement.setInt(1, produto.getCodProduto());
        preparedStatement.setString(1, produto.getNomeProduto());
        preparedStatement.setDouble(2, produto.getPreco());
        preparedStatement.setString(3, produto.getDescricao());
        
        preparedStatement.executeUpdate();
        
        preparedStatement.close();
        connection.close();       
    } 
    
    public List<Produto> listar() throws SQLException {
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "SELECT * FROM PRODUTO";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Produto> produtos = new ArrayList<Produto>();
        produtos.clear();
        while (resultSet.next()){
            Produto produto = new Produto();
            produto.setCodProduto(resultSet.getInt("COD_PRODUTO"));
            produto.setNomeProduto(resultSet.getString("NOME_PRODUTO"));
            produto.setPreco(resultSet.getDouble("PRECO"));
            produto.setDescricao(resultSet.getString("DESCRICAO"));
            produtos.add(produto);                
        } 
        
        preparedStatement.close();
        resultSet.close();
        connection.close();
        return produtos;
    }    
    
    public Produto buscarPorCodigo(int codProduto) throws SQLException {
        connection = ConnectionFactory.getInstance().getConnection();
        Produto produto = new Produto();
        String sql = "SELECT * FROM PRODUTO WHERE COD_PRODUTO = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, codProduto);
        ResultSet resultSet = preparedStatement.executeQuery();        
        resultSet.next();
        
        produto.setCodProduto(resultSet.getInt("COD_PRODUTO"));
        produto.setNomeProduto(resultSet.getString("NOME_PRODUTO"));
        produto.setPreco(resultSet.getDouble("PRECO"));
        produto.setDescricao(resultSet.getString("DESCRICAO"));
        
        preparedStatement.close();
        resultSet.close();
        connection.close();
        
        return produto;
    }
    
    public void excluir(int codProduto) throws SQLException {
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "DELETE FROM PRODUTO WHERE COD_PRODUTO = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, codProduto);
        preparedStatement.executeUpdate();            
        
        preparedStatement.close();        
        connection.close();
        
    }
}
