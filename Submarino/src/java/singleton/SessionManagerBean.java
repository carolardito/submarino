/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author 1147171
 */
@Singleton //Define que um EJB Singleton //trocar o singleton por 
@LocalBean //Não possui interface local
@WebListener //Define um listener de sessão.
@Startup //Inicializar quando o server subir


public class SessionManagerBean implements HttpSessionListener{
    private int counter;
    
    public SessionManagerBean(){
        System.out.println("Construído");
    }
    public void sessionCreated(HttpSessionEvent hse) {
        counter++;
        System.out.println("Usuários Ativos: "+counter);
    }
    public void sessionDestroyed(HttpSessionEvent hse) {
        counter--;
        System.out.println("Usuários Ativos: "+counter);
    }   
    @PostConstruct
    public void init(){
        System.out.println("Depois de Construido");
        counter=0;
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Antes de Destruir");
    }

}
