/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.teste;

import br.mackenzie.dao.CepDAO;
import br.mackenzie.dao.ProdutoDAO;
import br.mackenzie.modelo.Cep;
import br.mackenzie.modelo.Produto;
import java.sql.SQLException;

/**
 *
 * @author Ricardo
 */
public class Teste {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        //testando produto
        //inserindo
        Produto produto = new Produto();
        produto.setNomeProduto("Batata");
        produto.setPreco(13);
        produto.setDescricao("Batata c");
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.inserir(produto);
        //listar
        for (Produto produto1 : produtoDAO.listar()) {
            System.out.println(produto1.toString());   
            produto.setCodProduto(produto1.getCodProduto());
        }
        //buscar
        System.out.println(produtoDAO.buscarPorCodigo(produto.getCodProduto()).toString());
        //excluir
        produtoDAO.excluir(produto.getCodProduto());
        //listar
        for (Produto produto1 : produtoDAO.listar()) {
            System.out.println(produto1.toString());            
        }
        
        //testando cep
        //inserindo
        Cep cep = new Cep("4824040", 10);
        CepDAO cepDAO= new CepDAO();
        cepDAO.inserir(cep);
        //listando
        for (Cep cep1 : cepDAO.listar()) {
            System.out.println(cep1.getPreco());
            cep.setCep(cep1.getCep());
        }
        //buscando
        System.out.println(cepDAO.buscarPorCep(cep.getCep()).getCep());
        //excluir
        cepDAO.excluir(cep.getCep());
        //listando
        for (Cep cep1 : cepDAO.listar()) {
            System.out.println(cep1.getCep());
            cep.setCep(cep1.getCep());
        }
        
        

        
        
    }
    
}
