/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.server;

import stateful.*;
import javax.ejb.Stateful;

/**
 *
 * @author 1147171
 */
@Stateful(mappedName = "StatefulChat")
public class StatefulCart implements StatefulChatRemote{
    private String nome="Guest";

    @Override
    public void enter(String name) {
        nome=name;
        System.out.println(nome+" entrou na sala");
    
    }

    @Override
    public void exit() {
        System.out.println(nome+" saiu da sala");
    }
    
            
    @Override
    public void talk(String phrase){
        System.out.println(nome +": "+ phrase);
    }
}
