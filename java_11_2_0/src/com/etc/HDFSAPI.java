package com.etc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

public class HDFSAPI {
	
	private FileSystem fileSystem = null;
	
	@Before
	public void init() throws IOException{
		Configuration conf = new Configuration();
		//����ϴ�Ȩ�޵�����
		System.setProperty("HADOOP_USER_NAME","root");
		conf.set("fs.defaultFS", "hdfs://10.42.3.250:9000");
		fileSystem = FileSystem.get(conf);
	}
	
	
	@Test
	public void testUpload() throws Exception{
		//ͨ��init����hdfs����
		//�򿪱����ļ���Ϊ������
		InputStream in = new FileInputStream("d://a.txt");
		
		//ʹ��HDFS��fileSystem��һ�������
		FSDataOutputStream out = fileSystem.create(new Path("/a.txt"));
		//in - > out
		IOUtils.copyBytes(in, out, 1024,true);
		fileSystem.close();
	}
	
	@Test
	public void testDel() throws Exception{
		boolean flag = fileSystem.delete(new Path("/a.txt"),true);
		System.out.println(flag);
	}
	
	@Test
	public void testMKdir() throws Exception{
		fileSystem.mkdirs(new Path("/a/b"));
		fileSystem.close();
	}
	
	
	
	/*public static void main(String[] args) throws IOException {
		//��hdfs�������ӣ�Ҫ֪��NameNode�ĵ�ַ
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://10.42.3.250:9000");
		FileSystem fileSystem = FileSystem.get(conf);

		//��������
		InputStream in = fileSystem.open(new Path("/a.txt"));
		
		//�򿪱��ص������
		OutputStream out = new FileOutputStream("e://out123.txt");
		
		//����IN->OUT
		IOUtils.copyBytes(in,out,1024,true);
		
		out.close();
		in.close();
		fileSystem.close();
	}*/
}
