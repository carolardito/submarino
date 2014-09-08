/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.modelo;

/**
 *
 * @author Ricardo
 */
public class Cep {
    private String cep;
    private double preco;

    public Cep() {
    }

    public Cep(String cep, double preco) {
        this.cep = cep;
        this.preco = preco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
