package com.etc;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FlowSumMapper extends Mapper<LongWritable, Text, Text, FlowBean>{
	//д����
	Text k = new Text();
	FlowBean v = new FlowBean();
	
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String line = value.toString();
		String[] fields = StringUtils.split(line,"\t");
		String phonebr = fields[1];
		long upflow = Long.parseLong(fields[fields.length-3]);
		long dflow = Long.parseLong(fields[fields.length-2]);
		
		
		//д��һ��ȱ�������������ʱ��ִ�д�����
		/*FlowBean flowBean = new FlowBean();
		flowBean.setUpflow(upflow);
		flowBean.setDflow(dflow);
		context.write(new Text(phonebr), flowBean);*/
		
		//д���������췽�����Ż�
		/*FlowBean flowBean = new FlowBean(upflow,dflow);
		context.write(new Text(phonebr), flowBean);*/
		
		//д����������ÿ�α�����new����
		//��Ϊ���map�����ᱻmaptask��Ƶ����������ݣ����Բ�Ҫÿ�ζ������µĶ��������������������
		v.set(upflow, dflow);
		k.set(phonebr);
		context.write(k, v);
		
		
	}
}
