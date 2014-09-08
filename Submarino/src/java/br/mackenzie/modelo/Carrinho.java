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
    private double precoTotal;

    public Carrinho() {
    }

    public Carrinho(ArrayList<Item> items, Cep cep, double precoTotal) {
        this.items = items;
        this.cep = cep;
        this.precoTotal = precoTotal;
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

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
