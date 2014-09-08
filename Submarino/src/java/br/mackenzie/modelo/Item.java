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
    private int codItem;

    public Item() {
    }

    public Item(Produto produto, int quantidade, int codItem) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.codItem = codItem;
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

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }
    
}
