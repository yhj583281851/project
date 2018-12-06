package com.etc;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FlowSumMapper extends Mapper<LongWritable, Text, Text, FlowBean>{
	//写法三
	Text k = new Text();
	FlowBean v = new FlowBean();
	
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String line = value.toString();
		String[] fields = StringUtils.split(line,"\t");
		String phonebr = fields[1];
		long upflow = Long.parseLong(fields[fields.length-3]);
		long dflow = Long.parseLong(fields[fields.length-2]);
		
		
		//写法一，缺点是数据量大的时候执行次数多
		/*FlowBean flowBean = new FlowBean();
		flowBean.setUpflow(upflow);
		flowBean.setDflow(dflow);
		context.write(new Text(phonebr), flowBean);*/
		
		//写法二，构造方法的优化
		/*FlowBean flowBean = new FlowBean(upflow,dflow);
		context.write(new Text(phonebr), flowBean);*/
		
		//写法三，避免每次遍历都new对象
		//因为这个map方法会被maptask高频调用输出数据，所以不要每次都创建新的对象，以免产生大量的垃圾
		v.set(upflow, dflow);
		k.set(phonebr);
		context.write(k, v);
		
		
	}
}
