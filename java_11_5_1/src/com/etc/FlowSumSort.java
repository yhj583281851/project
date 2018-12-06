package com.etc;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

public class FlowSumSort {
	
	static class FlowSumSortMapper extends Mapper<LongWritable,Text,FlowBean,Text>{
		
		FlowBean k = new FlowBean();
		Text v = new Text();
		
		
		@Override
		protected void map(LongWritable key, Text value,Context context) throws IOException, InterruptedException {
			String line = value.toString();
			String[] token = line.split("\t");
			
			k.set(Long.parseLong(token[1]), Long.parseLong(token[2]));
			v.set(token[0]);
			
			//FlowBean要设置为key才可以进入compareTo进行排序
			context.write(k, v);
		}
	}
	
	static class FlowSumSortReducer extends Reducer<FlowBean, Text, Text, FlowBean>{
		@Override
		protected void reduce(FlowBean key, Iterable<Text> values,Context context) throws IOException, InterruptedException {
			for (Text value : values) {
				context.write(value, key);
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
	
}
