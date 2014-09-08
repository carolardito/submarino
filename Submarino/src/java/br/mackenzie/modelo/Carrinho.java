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
    private String codCarrinho;    

    public Carrinho() {
    }

    public Carrinho(ArrayList<Item> items, Cep cep, String codCarrinho) {
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

    public String getCodCarrinho() {
        return codCarrinho;
    }

    public void setCodCarrinho(String codCarrinho) {
        this.codCarrinho = codCarrinho;
    }
    
    

    
}
