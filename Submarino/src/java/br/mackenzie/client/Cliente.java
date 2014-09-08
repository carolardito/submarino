/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.client;

import br.mackenzie.util.JNDIUtil;
import javax.ejb.Remote;
import javax.naming.Context;
import stateful.StatefulChatRemote;

/**
 *
 * @author 41285247
 */

public class Cliente {
    public static void main(String[] args) {
        //todo testar o carrinho
   /*     try{
            Context context=JNDIUtil.getIIOPInitialContext();
            StatefulChatRemote chat=(StatefulChatRemote)context.lookup("StatefulChat") ;
            chat.talk("Bom dia!");
            chat.enter("Viviane");
            chat.talk("Olá");
        }catch(Exception e){
            e.printStackTrace();
        }
    */
    }
}
