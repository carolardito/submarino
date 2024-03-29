/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.teste;

import br.mackenzie.dao.CepDAO;
import br.mackenzie.dao.ProdutoDAO;
import br.mackenzie.modelo.Carrinho;
import br.mackenzie.modelo.Item;
import java.sql.SQLException;

/**
 *
 * @author Ricardo
 */
public class Teste {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       
        //testando produto
        //inserindo
        /*
        Scanner scanner = new Scanner(System.in);
        
        Produto produto = new Produto();
        System.out.print("Digite nome do produto: ");
        produto.setNomeProduto(scanner.next());
        System.out.print("Digite Preço do produto: ");
        produto.setPreco(scanner.nextInt());
        System.out.print("Digite Descrição do produto: ");
        produto.setDescricao(scanner.next());
        ProdutoDAO produtoDAO = new ProdutoDAO();      
        produtoDAO.inserir(produto);
         
        //listar
        System.out.println("Listar");
        for (Produto produto1 : produtoDAO.listar()) {
            System.out.println(produto1.toString());   
            produto.setCodProduto(produto1.getCodProduto());
        }        
        //buscar
        System.out.println("Buscar");
        System.out.println(produtoDAO.buscarPorCodigo(produto.getCodProduto()).toString());
        //excluir
        System.out.println("Excluir");
        produtoDAO.excluir(produto.getCodProduto());
        //listar
        System.out.println("Listar");
        for (Produto produto1 : produtoDAO.listar()) {
            System.out.println(produto1.toString());            
        }
        
        //testando cep
        //inserindo
        Cep cep = new Cep("4824040", 10);
        CepDAO cepDAO= new CepDAO();
        System.out.println("Inserir cep");
        cepDAO.inserir(cep);
        //listando
        System.out.println("Listar cep");
        for (Cep cep1 : cepDAO.listar()) {
            System.out.println(cep1.getCep() + " - " + cep1.getPreco());
            cep.setCep(cep1.getCep());
        }
        //buscando
        System.out.println("Buscar cep");
        System.out.println(cepDAO.buscarPorCep(cep.getCep()).getCep());
        //excluir
        System.out.println("Excluir cep");
        cepDAO.excluir(cep.getCep());
        //listando
        System.out.println("listar cep");
        for (Cep cep1 : cepDAO.listar()) {
            System.out.println(cep1.getCep());
            cep.setCep(cep1.getCep());
        }
        
        //testando item
        //inserindo
        Item item = new Item();
        produto.setNomeProduto("Arroz");
        produto.setPreco(15);
        produto.setDescricao("Arroz b");        
        System.out.println("inserir produto");
        produtoDAO.inserir(produto);            
        item.setProduto(produtoDAO.buscarPorCodigo(produtoDAO.listar().get(0).getCodProduto()));
        item.setQuantidade(10);
        ItemDAO itemDAO = new ItemDAO();
        System.out.println("inserir item");
        itemDAO.inserir(item);
        //listando
        System.out.println("listar item");
        for (Item item1 : itemDAO.listar()) {
            System.out.println(item1.getProduto().getNomeProduto() + " - " + item1.getQuantidade());            
        //    item.setCodItem(item1.getCodItem());
        }
        //buscando
        System.out.println("buscar item");
        //System.out.println(itemDAO.buscarPorCodigo(item.getCodItem()).getCodItem());
        //excluir
        System.out.println("Excluir item");
        //itemDAO.excluir(itemDAO.buscarPorCodigo(itemDAO.listar().get(0).getCodItem()).getCodItem());
        //listando
        System.out.println("listar item");
        for (Item item1 : itemDAO.listar()) {
            System.out.println(item1.getProduto().getNomeProduto() + " - " + item1.getQuantidade());            
        }
        //testando carrinho
        //inserindo
        //Scanner scanner = new Scanner(System.in);
        Carrinho carrinho = new Carrinho();        
        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
        carrinhoDAO.inserir(carrinho);
        //carrinho = 
        //System.out.println("Digite o cep: ");
        cep.setCep("1234");
        cep.setPreco(200);
        cepDAO.inserir(cep);
        cep = cepDAO.buscarPorCep("1234");
        carrinho.setCep(cep);        
        //cepDAO.excluir(cep.getCep());
        //System.out.println("Digite o codigo do produto: ");
        
        produto.setNomeProduto("TV");
        produto.setPreco(300);
        produto.setDescricao("29");
        produtoDAO.inserir(produto);
        produto = produtoDAO.buscarPorNome("TV");
        item.setProduto(produto);
        
        //System.out.println("Digite a quantidade do produto: ");
        item.setQuantidade(20);
        itemDAO.inserir(item);
        //itemDAO.buscarPorCodigo(item.)
        
        //item = itemDAO.buscarPorCodigo();
        carrinho.adicionaItem(item);
        /*
        System.out.println("Digite o codigo do produto: ");
        produto.setCodProduto(scanner.nextInt());
        item.setProduto(produto);
        System.out.println("Digite a quantidade do produto: ");
        item.setQuantidade(scanner.nextInt());
        carrinho.adicionaItem(item);
        
        
        //item = itemDAO.buscarPorCodigo(item.getCodItem());
        carrinho.removeItem(item);                
        
        carrinhoDAO.inserir(carrinho);
        
        */
        
        Carrinho carrinho = new Carrinho();           
        carrinho.setCep(new CepDAO().calcularFrete("04824040"));       
        carrinho.adicionaItem(new Item(new ProdutoDAO().buscarPorNome("Feijão"), 3));
        carrinho.adicionaItem(new Item(new ProdutoDAO().buscarPorNome("Feijão"), 4));
        carrinho.adicionaItem(new Item(new ProdutoDAO().buscarPorNome("Feijão")));
        carrinho.removeItem(new Item(new ProdutoDAO().buscarPorNome("Feijão")));
        carrinho.removeItem(new Item(new ProdutoDAO().buscarPorNome("Feijão"), 12));
        carrinho.adicionaItem(new Item(new ProdutoDAO().buscarPorNome("Feijão")));
        carrinho.removeItem(new Item(new ProdutoDAO().buscarPorNome("Feijão")));   
        carrinho.adicionaItem(new Item(new ProdutoDAO().buscarPorNome("Arroz")));
        carrinho.adicionaItem(new Item(new ProdutoDAO().buscarPorNome("Feijão")));
        carrinho.adicionaItem(new Item(new ProdutoDAO().buscarPorNome("Feijão"), 4));
        for (Item item : carrinho.getItems()) {
            System.out.println("Nome = " + item.getProduto().getNomeProduto());
            System.out.println("Preco produto = " + item.getProduto().getPreco());
            System.out.println("Quantidade = " + item.getQuantidade());
            System.out.println("Total Item = " + item.getProduto().getPreco() * item.getQuantidade());   
        }        
        System.out.println("Quantidade itens = " + carrinho.getItems().size()); 
        System.out.println("Preço frete = " + carrinho.getCep().getPreco()); 
        System.out.println("Total = " + carrinho.calculaPrecoTotal());
    }
}
