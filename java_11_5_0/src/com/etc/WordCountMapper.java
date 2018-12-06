package com.etc;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;




/***
 * 
 * KEYIN:框架读到的一行数据的偏移量，long
 * VALUEIN:读到的实际数据，string
 * KEYOUT:业务中要输出的数据key类型，在此例中是个单词，string
 * VALUEUOT:业务中要输出的value的类型，在此例中是个整数，inwritable
 * 
 * 
 * hadoop实现了自己的一套虚拟化，他的序列化比jdk的servizable序列化之后的数据更精简，从而提高网络传输效率
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
