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
import java.sql.SQLException;


    
/**
 *
 * @author Ricardo
 */
public class CarrinhoDAO {
    private static Connection connection = null;
    
    public void inserir(Carrinho carrinho) throws SQLException, ClassNotFoundException{        
        connection = ConnectionFactory.getInstance().getConnection();        
                
        String sql = "INSERT INTO CARRINHO (CEP) "
                + "VALUES (?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                
        preparedStatement.setString(1, carrinho.getCep().getCep()); 
        
        preparedStatement.executeUpdate();
        
        preparedStatement.close();
        connection.close();       
        
        ItemDAO itemDAO = new ItemDAO();
        for (Item  item : carrinho.getItems()) {
            itemDAO.inserir(item);            
        }
    }

    /*
    public void inserirItemLista(Item item, Carrinho carrinho) throws SQLException, ClassNotFoundException{
        connection = ConnectionFactory.getInstance().getConnection();
        
        String sql = "INSERT INTO LISTA_ITEM (COD_CARRINHO , COD_ITEM) "
                + "VALUES (? , ?)";                        
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setInt(1, carrinho.getCodCarrinho());
        preparedStatement.setInt(2, item.getCodItem());            
        
        preparedStatement.executeUpdate();
        
        preparedStatement.close();
        connection.close();       
    } 
    
    public List<Carrinho> listar() throws SQLException {
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "SELECT * FROM CARRINHO "                
                + "INNER JOIN CEPS "
                + "ON CEPS.CEP = CARRINHO.CEP ";                
        PreparedStatement preparedStatement = connection.prepareStatement(sql);        
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Carrinho> carrinhos = new ArrayList<Carrinho>();
        List<Item> items = new ArrayList<Item>();
        carrinhos.clear();
        while (resultSet.next()){
            Cep cep = new Cep();
            cep.setCep(resultSet.getString("CEP"));
            cep.setPreco(resultSet.getDouble("CEPS.PRECO"));
            
            for (Item item : items) {
                
            }
            
            Produto produto = new Produto();
            produto.setCodProduto(resultSet.getInt("COD_PRODUTO"));
            produto.setNomeProduto(resultSet.getString("NOME_PRODUTO"));
            produto.setPreco(resultSet.getDouble("PRODUTO.PRECO"));
            produto.setDescricao(resultSet.getString("DESCRICAO"));
            
            CepDAO cepDAO = new CepDAO();
            Carrinho carrinho = new Carrinho();
            carrinho.setCodCarrinho(resultSet.getInt("COD_CARRINHO"));
            carrinho.setCep(cepDAO.buscarPorCep(resultSet.getString("CEP")));
            carrinho.setItems((ArrayList<Item>) this.listarItemLista(carrinho));
            carrinhos.add(carrinho);                
        } 
        
        preparedStatement.close();
        resultSet.close();
        connection.close();
        return carrinhos;
    }    

    public List<Item> listarItemLista(Carrinho carrinho) throws SQLException {
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "SELECT * FROM LISTA_ITEM WHERE COD_CARRINHO = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setInt(1, carrinho.getCodCarrinho());
        
        ResultSet resultSet = preparedStatement.executeQuery();
        
        List<Item> items = new ArrayList<Item>();
        items.clear();
        while (resultSet.next()){
            ProdutoDAO produtoDAO = new ProdutoDAO();
            ItemDAO itemDAO = new  ItemDAO();
            Item item = new Item();            
            item.setCodItem(resultSet.getInt("COD_ITEM"));
            item.setQuantidade(resultSet.getInt("QUANTIDADE"));
            item.setProduto(produtoDAO.buscarPorCodigo(itemDAO.buscarPorCodigo(resultSet.getInt("COD_ITEM")).getProduto().getCodProduto()));                      
            items.add(item);                
        } 
        
        preparedStatement.close();
        resultSet.close();
        connection.close();
        return items;
    }*/
    
    public void excluir(int codCarrinho) throws SQLException {
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "DELETE FROM CARRINHO WHERE COD_CARRINHO = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, codCarrinho);
        preparedStatement.executeUpdate();            
        
        preparedStatement.close();        
        connection.close();        
    }
    /*
    public void excluirItemLista(Carrinho carrinho, Item item) throws SQLException {
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "DELETE FROM LISTA_ITEM WHERE COD_ITEM = ? AND COD_CARRINHO = ? ";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, item.getCodItem());
        preparedStatement.setInt(2, carrinho.getCodCarrinho());
        preparedStatement.executeUpdate();            
        
        preparedStatement.close();        
        connection.close();        
    }
    */
    
    public void atualizar(Carrinho carrinho) throws SQLException {
        connection = ConnectionFactory.getInstance().getConnection();
        String sql = "UPDATE CARRINHO SET CEP = ? WHERE COD_CARRINHO = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, carrinho.getCep().getCep());
        preparedStatement.setInt(2, carrinho.getCodCarrinho());            
        preparedStatement.executeUpdate();            
        
        preparedStatement.close();        
        connection.close();                
    }
    
    
    
}
