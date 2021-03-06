package com.etc;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



/***
 * 
 * job提交器是yarn的一个客户端，他负责将我们mr程序需要的信息全部封装成配置文件然后联同我们mr程序锁在的java包
 * 一起提交给yarn，yarn去启动我们mr程序中的mrappmaster
 *
 */

public class JobClient {
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.set("yarn.resourcemanager.hostname", "centos01");
		
		//创建一个job提交对象
		Job job = Job.getInstance();
		
		//告知客户端提交器，我们的mr程序所有jar包
		job.setJarByClass(JobClient.class);
		
		//告知mrappmaster，我们这个程序要用mapper业务实现和reducer业务实现类
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);
		
		//告知mrappmaster，map阶段和reducer阶段输出的数据类型
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		//告知mrappmaster我们要启动的reduce task数量
		job.setNumReduceTasks(1);
		
		//告知mrappmaster我们要处理的数据在哪，以及处理后存储在哪里
		FileInputFormat.setInputPaths(job, new Path("hdfs://centos01:9000/flow/wc/input"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://centos01:9000/flow/wc/output"));
		
		//提交job
		boolean res = job.waitForCompletion(true);
		System.exit(res?0:1);
		
	}
}
