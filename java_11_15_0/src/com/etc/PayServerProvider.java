package com.etc;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;

/***
 * 
 * 服务端
 *
 */
public class PayServerProvider {

	ZooKeeper zk = null;
	
	//获取服务端
	public void connectZK() throws Exception {
		zk = new ZooKeeper("192.168.204.130:2181,192.168.204.131:2181", 20000, null);
		
	}
	
	//业务处理
	public void handleService() throws Exception {
		System.out.println("服务器开始接受业务请求");
		Thread.sleep(Long.MAX_VALUE);
	}
	
	public static void main(String[] args) throws Exception {
		
		PayServerProvider psp = new PayServerProvider();
		
		//获取客户端
		psp.connectZK();
		
		//注册信息
		Stat stat = psp.zk.exists("/servers", false);
		if(stat==null) {
			psp.zk.create("/servers", null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}
		
		//创建服务器
		psp.zk.create("/servers/server", args[0].getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
		
		//业务处理
		psp.handleService();
	}
	
}
