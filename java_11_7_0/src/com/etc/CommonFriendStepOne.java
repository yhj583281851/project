package com.etc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class CommonFriendStepOne {
	
	static class CommonFriendStepOneMapper extends Mapper<LongWritable,Text,Text,Text>{
		
		Text k = new Text();
		Text v = new Text();
		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();
			String[] split = line.split(":");
			String user = split[0];
			String friendStr = split[1];
			String[] friends = friendStr.split(",");
			
			for (String friend : friends) {
				k.set(new Text(friend));
				v.set(new Text(user));
				
				context.write(k, v);
			}

		}
	}
	
	static class CommonFriendStepOneReducer extends Reducer<Text, Text, Text, Text>{
		
		Text k = new Text();
		
		@Override
		protected void reduce(Text friend, Iterable<Text> users, Context context) throws IOException, InterruptedException {
			ArrayList<Text> list = new ArrayList<>();
			for (Text user : users) {
				Text u = new Text(user.toString());
				list.add(u);
			}
			
			Collections.sort(list);
			
			for(int i=0;i<list.size()-1;i++) {
				for(int j=i+1;j<list.size();j++) {
					context.write(new Text(list.get(i)+"-"+list.get(j)), friend);
				}
			}
		}
		
		public static void main(String[] args) throws Exception {
			Configuration conf = new Configuration();
			
			Job job = Job.getInstance(conf);
			
			job.setJarByClass(CommonFriendStepOne.class);
			job.setMapperClass(CommonFriendStepOneMapper.class);
			job.setReducerClass(CommonFriendStepOneReducer.class);
			
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(Text.class);
			
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);
			
			FileInputFormat.setInputPaths(job, new Path("d:/flow/friend"));
			FileOutputFormat.setOutputPath(job, new Path("d:/flow/friend-out-1"));
			
			boolean res = job.waitForCompletion(true);
			System.exit(res?0:1);
		}
		
	}
	
	
	
	
	
	
	
	
	
}
