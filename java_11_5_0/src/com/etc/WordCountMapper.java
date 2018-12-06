package com.etc;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;




/***
 * 
 * KEYIN:��ܶ�����һ�����ݵ�ƫ������long
 * VALUEIN:������ʵ�����ݣ�string
 * KEYOUT:ҵ����Ҫ���������key���ͣ��ڴ������Ǹ����ʣ�string
 * VALUEUOT:ҵ����Ҫ�����value�����ͣ��ڴ������Ǹ�������inwritable
 * 
 * 
 * hadoopʵ�����Լ���һ�����⻯���������л���jdk��servizable���л�֮������ݸ����򣬴Ӷ�������紫��Ч��
 *
 *Long  --- >> LongWritable
 *String  --- >> Text
 *Integer  --- >> IntWritable
 *Null  --- >> NullWritable
 *
 */

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
	
		String line = value.toString();
		String[] lineWords = line.split(" ");
		
		for (String string : lineWords) {
			context.write(new Text(string), new IntWritable(1));
		}
		
		
	}
}
