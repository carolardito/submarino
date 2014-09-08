/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stateful;
import javax.ejb.Remote;

/**
 *
 * @author 1147171
 */
@Remote
public interface StatefulChatRemote {
    void enter(String name);
    void talk(String phrase);
    void exit();
}
