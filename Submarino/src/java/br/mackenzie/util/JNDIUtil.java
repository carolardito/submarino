/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.util;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author 1147171
 */
public class JNDIUtil {

    public static Context getIIOPInitialContext() throws NamingException {
        
        Properties jndiProps = new Properties();
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
        jndiProps.put(Context.PROVIDER_URL, "iiop://localhost:3920/");
        
        return new InitialContext(jndiProps);
    }
    public static Context getCORBAInitialContext() throws NamingException {
        Properties prop = new Properties();
        prop.put("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");   
        prop.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
        prop.put("java.naming.factory.state","com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        prop.put("org.omg.CORBA.ORBInitialHost","093045-p31s404");
        prop.put("org.omg.CORBA.ORBInitialPort","3700");
        return new InitialContext(prop);
    }
}
