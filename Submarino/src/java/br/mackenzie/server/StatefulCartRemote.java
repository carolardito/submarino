/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.server;
import br.mackenzie.modelo.Produto;
import stateful.*;
import javax.ejb.Remote;

/**
 *
 * @author 1147171
 */
@Remote
public interface StatefulCartRemote {
    void adicionarProduto(Produto produto, int qtde);
    void removerProduto(Produto produto);
    void calcularFrete(String cep);
    void calcularTotal();
    void exibircarrinho();
    void talk(String phrase);
    void exit();
}
