/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.modelo;

/**
 *
 * @author Ricardo
 */
public class Item {
    private Produto produto;
    private int quantidade;
    private int codCarrinho;

    public Item() {
    }

    public Item(Produto produto, int quantidade, int codCarrinho) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.codCarrinho = codCarrinho;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCodCarrinho() {
        return codCarrinho;
    }

    public void setCodCarrinho(int codCarrinho) {
        this.codCarrinho = codCarrinho;
    }    

    @Override
    public String toString() {
        return produto + "  ||  " + quantidade + "\n";
    }
    
}
