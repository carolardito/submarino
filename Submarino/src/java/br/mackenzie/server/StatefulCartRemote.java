/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.server;
import javax.ejb.Remote;

/**
 *
 * @author 1147171
 */
@Remote
public interface StatefulCartRemote {
    void adicionarProduto(int id, int qtde);
    void removerProduto(int id);
    String calcularFrete(String cep);
    String calcularTotal();
    void finalizarCompra();
    String listarProdutos();
    String exibirCarrinho();

}
