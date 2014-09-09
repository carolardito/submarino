/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.server;
import stateful.*;
import javax.ejb.Remote;

/**
 *
 * @author 1147171
 */
@Remote
public interface StatefulCartRemote {
    void adicionarProduto(String name);
    void talk(String phrase);
    void exit();
}
