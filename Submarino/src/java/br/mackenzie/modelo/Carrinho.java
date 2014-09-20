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
    private ArrayList<Item> items = new ArrayList<Item>();
    private Cep cep;
    private int codCarrinho;    

    public Carrinho() {
        this.items.clear();
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
        boolean ItemNaLista = false;
        for (int i = 0; i < items.size() && ItemNaLista == false; i++) {
            if (items.get(i).getProduto().getCodProduto() == (item.getProduto().getCodProduto())){
                items.get(i).setQuantidade(items.get(i).getQuantidade() + item.getQuantidade());
                ItemNaLista = true;
            }
        }        
        if (ItemNaLista == false){                    
            items.add(item);
        }      
        
    }
    
    public void removeItem(Item item){
        boolean ItemNaLista = false;
        for (int i = 0; i < items.size() && ItemNaLista == false; i++) {
            if (items.get(i).getProduto().getCodProduto() == (item.getProduto().getCodProduto())){               
                if ((items.get(i).getQuantidade() - item.getQuantidade()) <= 1)
                    items.remove(i); 
                else
                    items.get(i).setQuantidade(items.get(i).getQuantidade() - item.getQuantidade());
                ItemNaLista = true;
            }
        }    
    }   
    
    public double calculPreco(){
        double preco = 0;
        for (Item item : items) 
            preco += item.getProduto().getPreco() * item.getQuantidade();        
        return preco;          
    }
    
    public double calculaPrecoTotal(){
        return this.calculPreco() + cep.getPreco();
    }
}
