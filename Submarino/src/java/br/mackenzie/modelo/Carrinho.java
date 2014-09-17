/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.modelo;

import java.util.ArrayList;

/**
 *
 * @author Ricardo
 */
public class Carrinho {
    private ArrayList<Item> items;
    private Cep cep;
    private int codCarrinho;    

    public Carrinho() {
    }

    public Carrinho(ArrayList<Item> items, Cep cep, int codCarrinho) {
        this.items = items;
        this.cep = cep;
        this.codCarrinho = codCarrinho;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    public int getCodCarrinho() {
        return codCarrinho;
    }

    public void setCodCarrinho(int codCarrinho) {
        this.codCarrinho = codCarrinho;
    }
    
    public void adicionaItem(Item item){
        items.add(item);
    }
    
    public void removeItem(Item item){
        items.remove(item);
    }
    
    public double calculPreco(){
        double preco = 0;
        for (Item item : items) 
            preco += item.getProduto().getPreco() * item.getQuantidade();
        return preco;          
    }
}
