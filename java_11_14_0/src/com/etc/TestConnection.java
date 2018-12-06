package com.etc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class TestConnection {
	
	
		ZooKeeper zk = null;
		
		@Before
		public void init() throws Exception{
			zk = new ZooKeeper("192.168.204.130:2181,192.168.204.131",2000,null);
		}
		
		/***
		 * 
		 * ���ӽ��
		 */
		@Test
		public void createNode() throws Exception{
			//�������ýڵ�
			//String create1 = zk.create("/eclipse", "aaa001".getBytes("utf-8"), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			
			//������ʱ�ڵ�
			//String create2 = zk.create("/eclipse/aa", "aaa002".getBytes("utf-8"), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
			//System.out.println(create2);
			//Thread.sleep(10000);
			
			//������ʱ�Ҵ���ŵĽڵ�
			//String create3 = zk.create("/eclipse/bb", "aaa003".getBytes("utf-8"), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
			//System.out.println(create3);
			//Thread.sleep(10000);
			
			//���������Ҵ���ŵĽڵ�
			String create4 = zk.create("/eclipse/cc", "aaa004".getBytes("utf-8"), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
			System.out.println(create4);
			Thread.sleep(10000);
			
			zk.close();
			
		}
		
		/***
		 * 
		 * ɾ�����
		 */
		@Test
		public void testDeleteNode() throws InterruptedException, KeeperException {
			//-1��ʾɾ���������а汾
			zk.delete("/eclipse/cc000005", -1);
			zk.close();
		}
		
		/***
		 * 
		 * �޸Ľ��
		 * @throws InterruptedException 
		 * @throws KeeperException 
		 * @throws UnsupportedEncodingException 
		 */
		@Test
		public void testSetData() throws UnsupportedEncodingException, KeeperException, InterruptedException {
			zk.setData("/eclipse", "bbb002".getBytes("utf-8"), -1);
			zk.close();
		}
		
		/***
		 * 
		 * �жϽ���Ƿ����
		 */
		@Test
		public void testExist() throws KeeperException, InterruptedException {
			Stat stat = zk.exists("/eclipse", false);
			System.out.println(stat==null?"������":"����");
			zk.close();
		}
		
		/***
		 * 
		 * ������
		 * @throws InterruptedException 
		 * @throws KeeperException 
		 * @throws UnsupportedEncodingException 
		 */
		@Test
		public void testPutObjectIntoZookeeper() throws UnsupportedEncodingException, KeeperException, InterruptedException {
			People people = new People();
			people.setName("zhangsan");
			people.setSong("lige");
			
			Gson gson = new Gson();
			String json = gson.toJson(people);

			zk.create("zhangsan", json.getBytes("utf-8"), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			
			//byte[] data = zk.getData("/zhangsan",false,null);
			//String jsonResult = new String(data);
			
			//People people = json.format(jsonResult, People.class);
			
			zk.close();
		}
		
		/***
		 * ����watch����
		 */
		@Test
		public void testWatch() throws KeeperException, InterruptedException {
			byte[] data = zk.getData("/eclipse", new MyWatch(), null);
			Thread.sleep(Long.MAX_VALUE);
			zk.close();
		}
		
		
		
		public static void main(String[] args) throws Exception {	
		
		ZooKeeper zk = new ZooKeeper("192.168.204.130:2181,192.168.204.131",2000,null);
	
	}
}
