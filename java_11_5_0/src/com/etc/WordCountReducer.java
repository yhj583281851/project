package com.etc;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/***
 * 
 * KEYIN:��Ӧmap�׶�������ݵ�key���ͣ�stirng
 * KEYOUT:��Ӧmap�׶������value���ͣ�intwritable
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
		
		//�����context��
		context.write(key,new IntWritable(count));
	}
}
