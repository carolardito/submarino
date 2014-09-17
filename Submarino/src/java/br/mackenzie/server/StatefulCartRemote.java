/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.server;
import br.mackenzie.modelo.Produto;
import javax.ejb.Remote;

/**
 *
 * @author 1147171
 */
@Remote
public interface StatefulCartRemote {
    void adicionarProduto(int id, int qtde);
    void removerProduto(int id);
    void calcularFrete(String cep);
    void calcularTotal();
    void finalizarCompra();
    void listarProdutos();
    void exibirCarrinho();

}
