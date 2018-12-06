package com.etc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class JobClientProvince {
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(JobClientProvince.class);
		job.setMapperClass(FlowSumMapper.class);
		job.setReducerClass(FlowSumReduce.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FlowBean.class);
		
		//��֪��ܣ�����Ҫ���Լ������partitioner��
		job.setPartitionerClass(ProvincePartitioner.class);
		
		//Ĭ��Ϊ1���򲻽���Partitioner����
		//����������ڵ�����Ҫ��������
		job.setNumReduceTasks(6);
		
		
		FileInputFormat.setInputPaths(job, new Path("d:/flow/input"));
		
		//FileOutputFormat.setOutputPath(job, new Path("d:/flow/output"));
		//�ж�ɾ��output�ļ���
		Path dest = new Path("d:/flow/output");
		FileSystem fs = FileSystem.get(conf);
		if(fs.exists(dest)) {
			fs.delete(dest,true);
		}
		FileOutputFormat.setOutputPath(job, dest);
		
		boolean res = job.waitForCompletion(true);
		System.exit(res?0:1);
	}
}
