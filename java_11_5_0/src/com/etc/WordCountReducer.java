package com.etc;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/***
 * 
 * KEYIN:对应map阶段输出数据的key类型，stirng
 * KEYOUT:对应map阶段输出的value类型，intwritable
 *
 */

public class WordCountReducer extends Reducer<Text,IntWritable,Text,IntWritable>{
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException {
		int count = 0;
		
		for (IntWritable value : values) {
			count += value.get();
			//System.out.println(key + "----" + value + "----" + count);
		}
		
		//输出到context中
		context.write(key,new IntWritable(count));
	}
}
