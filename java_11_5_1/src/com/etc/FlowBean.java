package com.etc;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

public class FlowBean implements WritableComparable<FlowBean>{

	private long upflow;
	private long dflow;
	private long sumflow;
	
	//写法二
	/*public FlowBean() {
		
	}
	public FlowBean(long upflow, long dflow) {
		super();
		this.upflow = upflow;
		this.dflow = dflow;
		this.sumflow = upflow + dflow;
	}*/
	
	//写法三
	public void set(long upflow,long dflow) {
		this.upflow = upflow;
		this.dflow = dflow;
		this.sumflow = upflow + dflow;
	}
	
	public long getUpflow() {
		return upflow;
	}
	public void setUpflow(long upflow) {
		this.upflow = upflow;
	}
	public long getDflow() {
		return dflow;
	}
	public void setDflow(long dflow) {
		this.dflow = dflow;
	}
	public long getSumflow() {
		return sumflow;
	}
	public void setSumflow(long sumflow) {
		this.sumflow = sumflow;
	}
	@Override
	public String toString() {
		return "FlowBean [upflow=" + upflow + ", dflow=" + dflow + ", sumflow=" + sumflow + "]";
	}
	
	/***
	 * 反序列化方法：hadoop在反序列化时要用的方法
	 * 功能是：从字节流中恢复出一个一个成品数据
	 */
	@Override
	public void readFields(DataInput in) throws IOException {
		upflow = in.readLong();
		dflow = in.readLong();
		sumflow = in.readLong();
		
	}
	
	/***
	 * 序列化方法：吧我们想象中的数据写入二进制字节流
	 */
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeLong(upflow);
		out.writeLong(dflow);
		out.writeLong(sumflow);
	}

	@Override
	public int compareTo(FlowBean o) {
		//从大到小排序
		return (int)(o.getSumflow() - this.sumflow);
		//从小到大排序
		//return (int)(this.sumflow - o.getSumflow());
	}
	
	
}
