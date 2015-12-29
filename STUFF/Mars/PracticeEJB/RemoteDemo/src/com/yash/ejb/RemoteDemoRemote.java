package com.yash.ejb;

import javax.ejb.Remote;

@Remote
public interface RemoteDemoRemote {
	
	public String echo(String s);

}
