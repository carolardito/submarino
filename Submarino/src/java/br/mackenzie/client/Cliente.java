/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.client;

import br.mackenzie.modelo.Item;
import br.mackenzie.modelo.Produto;
import br.mackenzie.util.JNDIUtil;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;
import javax.naming.Context;
import br.mackenzie.server.StatefulCartRemote;

/**
 *
 * @author 41285247
 */

public class Cliente {
    public static void main(String[] args) {
        //teste        
        List<Produto> lista = new ArrayList<Produto>();
        lista = listarProdutos();        
        String msg = "";
        
        int i=1;
        
        for(Produto aux : lista)
        {
            msg = msg+ Integer.toString(i)+". "+aux.getNomeProduto()+"/n"+
                    aux.getDescricao()+"/n"+
                    Double.toString(aux.getPreco())+"/n/n";
            i++;
        }
        
        msg = msg + "0. Sair/n/n";
        
        System.out.println(msg);
        
        System.out.println(msg);
        
        
        
        
        
            
            
            
                //começa listando todos os produtos, aí o usuário digita o código do produto que ele vai querer e quantidade
        //se ele digitar 0 no código
        String input = "0";
        do {
            //receber o input e decidir o que vai fazer
            // L listar, I inserir, R remover, C  comprar etc
            //lista todos os produtos
            
        } while(input.equals("0"));
        
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
