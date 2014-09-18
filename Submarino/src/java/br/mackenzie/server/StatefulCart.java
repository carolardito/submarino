/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.server;

import br.mackenzie.dao.CarrinhoDAO;
import br.mackenzie.dao.ItemDAO;
import br.mackenzie.dao.ProdutoDAO;
import br.mackenzie.modelo.Carrinho;
import br.mackenzie.modelo.Item;
import br.mackenzie.modelo.Produto;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;

/**
 *
 * @author 1147171
 */
@Stateful(mappedName = "StatefulCart")
public class StatefulCart implements StatefulCartRemote{
    private Carrinho carrinho = new Carrinho();

    @Override
    public void adicionarProduto(int id, int qtde) {
        carrinho.adicionaItem(null);
    }
    
    public void adicionaProdutoLista(int id, int quantidade){
        try {
            Produto produto = new ProdutoDAO().buscarPorCodigo(id);
            Item item = new Item(produto, quantidade, id);
            carrinho.adicionaItem(item);
        } catch (SQLException ex) {
            Logger.getLogger(StatefulCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removerProduto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String calcularFrete(String cep) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String calcularTotal() {
        carrinho.calculPreco();
        String preco = "Total: " + carrinho.calculPreco();
        return preco;
    }

    @Override
    public void finalizarCompra() {
        try {
            CarrinhoDAO cdao = new CarrinhoDAO();
            cdao.inserir(carrinho);
        } catch (Exception ex) {
            System.out.println("Erro na finalização da compra.");
        }
    }

    @Override
    public String listarProdutos() {
        try {
        ProdutoDAO pdao = new ProdutoDAO();
        String lista = "";
        for(Produto produto : pdao.listar()){
            lista += produto.toString();
        }
        return lista;
        } catch (Exception ex) {
            System.out.println("Erro ao listar produtos.");
        }
        return "";
    }

    @Override
    public String exibirCarrinho() {
        String lista = "";
        for(Item item : carrinho.getItems()){
            lista += item.toString();
        }
        return lista;        
    }

    
}
