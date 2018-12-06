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

public class MR1 {
	
	static class MR1Mapper extends Mapper<LongWritable, Text, Text, IntWritable>{
		Text k = new Text();
		IntWritable v = new IntWritable();
		
		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();
			String[] str = line.split(" ");
			String name = str[0];
			String salary = str[1];
			k.set(name);
			v.set(Integer.parseInt(salary));
			context.write(k,v);
		}
	}
	
	static class MR1Reducer extends Reducer<Text, IntWritable, Text, IntWritable>{
		Text k = new Text();
		IntWritable v = new IntWritable();
		
		@Override
		protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
			int count=0;
			for (IntWritable value : values) {
				count += value.get();
			}
			k.set(key);
			v.set(count);
			context.write(k, v);
		}
	}
	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(MR1.class);
		job.setMapperClass(MR1Mapper.class);
		job.setReducerClass(MR1Reducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.setInputPaths(job, new Path("d:/flow/salary"));
		FileOutputFormat.setOutputPath(job, new Path("d:/flow/salary-out-1"));
		
		boolean res = job.waitForCompletion(true);
		System.exit(res?0:1);
	}
	
}
