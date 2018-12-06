package com.etc;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FlowSumReduce extends Reducer<Text, FlowBean, Text, FlowBean>{

		FlowBean flowBean = new FlowBean();
		@Override
		protected void reduce(Text key, Iterable<FlowBean> values, Context context)throws IOException, InterruptedException {
			//只需对该手机号的所有数据进行上下行分别累加
			long upflowCount=0;
			long dflowCount=0;
			
			for(FlowBean value : values) {
				upflowCount = value.getUpflow();
				dflowCount = value.getDflow();
			}
			
			//写法一，缺点是数据量大的时候执行次数多
			/*FlowBean flowBean = new FlowBean();
			flowBean.setUpflow(upflowCount);
			flowBean.setDflow(dflowCount);
			flowBean.setSumflow(dflowCount+upflowCount);
			context.write(key, flowBean);*/
			
			//写法二
			/*FlowBean flowBean = new FlowBean(upflowCount,dflowCount);
			context.write(key, flowBean);*/
			
			//写法三
			flowBean.set(upflowCount, dflowCount);
			context.write(key, flowBean);
		}
}
