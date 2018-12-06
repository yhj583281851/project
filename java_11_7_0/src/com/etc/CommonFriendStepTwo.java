package com.etc;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class CommonFriendStepTwo {

	static class CommonFriendStepTwoMapper extends Mapper<LongWritable, Text, Text, Text>{
		
		Text k = new Text();
		Text v = new Text();
		
		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();
			String[] split = line.split("\t");
			String userPair = split[0];
			String friend = split[1];
			
			k.set(userPair);
			k.set(friend);
			
			context.write(k, v);
			
		}
	}
	
	static class CommonFriendStepTwoReducer extends Reducer<Text,Text,Text,Text>{
		Text v = new Text();
		
		@Override
		protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
			StringBuffer sb = new StringBuffer();
			for (Text friend : values) {
				sb.append(friend.toString()).append(",");
			}
			v.set(sb.toString());
			context.write(key,v);
		}
	}
	
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(CommonFriendStepTwo.class);
		job.setMapperClass(CommonFriendStepTwoMapper.class);
		job.setReducerClass(CommonFriendStepTwoReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		FileInputFormat.setInputPaths(job, new Path("d:/flow/friend-out-1"));
		FileOutputFormat.setOutputPath(job, new Path("d:/flow/friend-out-2"));
		
		boolean res = job.waitForCompletion(true);
		System.exit(res?0:1);
	}
	
}
