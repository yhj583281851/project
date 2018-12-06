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
import org.apache.hadoop.mapreduce.Reducer.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.etc.MR1.MR1Mapper;
import com.etc.MR1.MR1Reducer;

public class MR2 {

	static class MR2Mapper extends Mapper<LongWritable, Text, Text, IntWritable>{
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
	
	static class MR2Reducer extends Reducer<Text, IntWritable, Text, IntWritable>{
		Text k = new Text();
		IntWritable v = new IntWritable();
		
		@Override
		protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
			int count=0;
			int month = 0;
			for (IntWritable value : values) {
				month++;
				count += value.get();
			}
			k.set(key);
			v.set(count/month);
			context.write(k, v);
		}
	}
	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(MR2.class);
		job.setMapperClass(MR2Mapper.class);
		job.setReducerClass(MR2Reducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.setInputPaths(job, new Path("d:/flow/salary"));
		FileOutputFormat.setOutputPath(job, new Path("d:/flow/salary-out-2"));
		
		boolean res = job.waitForCompletion(true);
		System.exit(res?0:1);
	}
	
}
