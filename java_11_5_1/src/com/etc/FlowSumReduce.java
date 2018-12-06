package com.etc;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FlowSumReduce extends Reducer<Text, FlowBean, Text, FlowBean>{

		FlowBean flowBean = new FlowBean();
		@Override
		protected void reduce(Text key, Iterable<FlowBean> values, Context context)throws IOException, InterruptedException {
			//ֻ��Ը��ֻ��ŵ��������ݽ��������зֱ��ۼ�
			long upflowCount=0;
			long dflowCount=0;
			
			for(FlowBean value : values) {
				upflowCount = value.getUpflow();
				dflowCount = value.getDflow();
			}
			
			//д��һ��ȱ�������������ʱ��ִ�д�����
			/*FlowBean flowBean = new FlowBean();
			flowBean.setUpflow(upflowCount);
			flowBean.setDflow(dflowCount);
			flowBean.setSumflow(dflowCount+upflowCount);
			context.write(key, flowBean);*/
			
			//д����
			/*FlowBean flowBean = new FlowBean(upflowCount,dflowCount);
			context.write(key, flowBean);*/
			
			//д����
			flowBean.set(upflowCount, dflowCount);
			context.write(key, flowBean);
		}
}
