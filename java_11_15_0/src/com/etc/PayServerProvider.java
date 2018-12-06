package com.etc;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;

/***
 * 
 * �����
 *
 */
public class PayServerProvider {

	ZooKeeper zk = null;
	
	//��ȡ�����
	public void connectZK() throws Exception {
		zk = new ZooKeeper("192.168.204.130:2181,192.168.204.131:2181", 20000, null);
		
	}
	
	//ҵ����
	public void handleService() throws Exception {
		System.out.println("��������ʼ����ҵ������");
		Thread.sleep(Long.MAX_VALUE);
	}
	
	public static void main(String[] args) throws Exception {
		
		PayServerProvider psp = new PayServerProvider();
		
		//��ȡ�ͻ���
		psp.connectZK();
		
		//ע����Ϣ
		Stat stat = psp.zk.exists("/servers", false);
		if(stat==null) {
			psp.zk.create("/servers", null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}
		
		//����������
		psp.zk.create("/servers/server", args[0].getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
		
		//ҵ����
		psp.handleService();
	}
	
}
