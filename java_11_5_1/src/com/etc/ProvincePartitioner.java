package com.etc;

import java.util.HashMap;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class ProvincePartitioner extends Partitioner<Text, FlowBean>{

	private static HashMap<String,Integer> dict = new HashMap<>();
	
	static {
		dict.put("138", 0);
		dict.put("139", 1);
		dict.put("136", 2);
		dict.put("135", 3);
		dict.put("137", 4);
	}
	
	@Override
	public int getPartition(Text key, FlowBean value, int numPrtitions) {
		String phonebr = key.toString();
		String prefix = phonebr.substring(0, 3);
		//去外面的字典库中读取所属省份
		Integer provinceCode = dict.get(prefix);
		return provinceCode == null?5:provinceCode;
	}

}
