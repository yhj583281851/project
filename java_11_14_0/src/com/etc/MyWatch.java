package com.etc;

import javax.rmi.ssl.SslRMIClientSocketFactory;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class MyWatch implements Watcher{

	@Override
	public void process(WatchedEvent event) {
		System.out.println(event.getPath());
		System.out.println(event.getState());
		System.out.println(event.getType());
		
	}

}
