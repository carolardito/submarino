/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.modelo;

/**
 *
 * @author Ricardo
 */
public class Produto {
    private int codProduto;
    private String nomeProduto;
    private double preco;
    private String descricao;

    public Produto() {
    }

    public Produto(int codProduto, String nomeProduto, double preco, String descricao) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.descricao = descricao;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    } 
}
