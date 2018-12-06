package com.etc;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MR5 {

	static class MR5Mapper extends Mapper<LongWritable, Text, IntWritable, Text>{
		Text k = new Text();
		IntWritable v = new IntWritable();
		
		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();
			String[] str = line.split("\t");
			String name = str[0];
			String salary = str[1];
			k.set(name);
			v.set(Integer.parseInt(salary));
			context.write(v,k);
		}
	}
	
	static class MR5Reducer extends Reducer<IntWritable, Text, Text, Text>{
		Text k = new Text("最高工资的员工：");
		Text v = new Text();
		boolean flag = true;
		@Override
		protected void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
			
		
			
			for (Text value : values) {
				v.set(value);
			}
			if(flag) {
				
				context.write(k, v);
				flag=false;
			}
			
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(MR5.class);
		job.setMapperClass(MR5Mapper.class);
		job.setReducerClass(MR5Reducer.class);
		
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(Text.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		FileInputFormat.setInputPaths(job, new Path("d:/flow/salary-out-1"));
		FileOutputFormat.setOutputPath(job, new Path("d:/flow/salary-out-5"));
		
		boolean res = job.waitForCompletion(true);
		System.exit(res?0:1);
	}
	
}
