package com.yash.client;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.yash.ejb.RemoteDemo;
import com.yash.ejb.RemoteDemoRemote;

public class RemoteEJBClient {
	public static void main(String[] args) throws Exception {
        testRemoteEJB();
 
    }
 
    private static void testRemoteEJB() throws NamingException {
 
        final RemoteDemoRemote ejb  = lookupRemoteEJB();
        String s = ejb.echo("Shashank");
        System.out.println(s);
    }
 
    private static RemoteDemoRemote lookupRemoteEJB() throws NamingException {
        final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
 
        final Context context = new InitialContext(jndiProperties);
 
 
        final String appName = "";
        final String moduleName = "RemoteDemo";
        final String distinctName = "";
        final String beanName = RemoteDemo.class.getSimpleName();
 
        final String viewClassName = RemoteDemoRemote.class.getName();
        System.out.println("Looking EJB via JNDI ");
        System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
 
        return (RemoteDemoRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
 
 
    }

}
