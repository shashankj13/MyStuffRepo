package com.yash.ejb;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class RemoteDemo
 */
@Stateless
public class RemoteDemo implements RemoteDemoRemote {

    /**
     * Default constructor. 
     */
    public RemoteDemo() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String echo(String s) {
		
		return "Hello" +s;
	}

}
