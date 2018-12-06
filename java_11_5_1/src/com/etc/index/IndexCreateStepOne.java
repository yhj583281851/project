package com.etc.index;

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
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.etc.FlowBean;

public class IndexCreateStepOne {

	static class IndexCreateStepOneMapper extends Mapper<LongWritable,Text,Text,IntWritable>{
		Text k = new Text();
		IntWritable v = new IntWritable(1);
		
		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			//获取当前调用我们这个map方法的maptask进程所负责的切片信息
			FileSplit inputSplit = (FileSplit)context.getInputSplit();
			String fileName = inputSplit.getPath().getName();
			
			String line = value.toString();
			String[] words = line.split(" ");
			for (String word : words) {
				k.set(word + "-->" + fileName);
				context.write(k, v);
			}
			
		}
	}
	
	static class IndexCreateStepOneReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
		
		IntWritable v = new IntWritable(1);
		
		
		@Override
		protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
			int count = 0;
			for (IntWritable value : values) {
				count += value.get();
			}
			v.set(count);
			context.write(key, v);
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(IndexCreateStepOne.class);
		job.setMapperClass(IndexCreateStepOneMapper.class);
		job.setReducerClass(IndexCreateStepOneReducer.class);
		
		job.setMapOutputKeyClass(FlowBean.class);
		job.setMapOutputValueClass(Text.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.setInputPaths(job, new Path("d:/flow/index"));
		FileOutputFormat.setOutputPath(job, new Path("d:/flow/index-out-1"));
		
		boolean res = job.waitForCompletion(true);
		System.exit(res?0:1);
	}
	
}
