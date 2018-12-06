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
		//解决上传权限的问题
		System.setProperty("HADOOP_USER_NAME","root");
		conf.set("fs.defaultFS", "hdfs://10.42.3.250:9000");
		fileSystem = FileSystem.get(conf);
	}
	
	
	@Test
	public void testUpload() throws Exception{
		//通过init建立hdfs连接
		//打开本地文件作为输入流
		InputStream in = new FileInputStream("d://a.txt");
		
		//使用HDFS的fileSystem打开一个输出流
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
		//与hdfs建立连接，要知道NameNode的地址
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://10.42.3.250:9000");
		FileSystem fileSystem = FileSystem.get(conf);

		//打开输入流
		InputStream in = fileSystem.open(new Path("/a.txt"));
		
		//打开本地的输出流
		OutputStream out = new FileOutputStream("e://out123.txt");
		
		//拷贝IN->OUT
		IOUtils.copyBytes(in,out,1024,true);
		
		out.close();
		in.close();
		fileSystem.close();
	}*/
}
