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
	
	//д����
	/*public FlowBean() {
		
	}
	public FlowBean(long upflow, long dflow) {
		super();
		this.upflow = upflow;
		this.dflow = dflow;
		this.sumflow = upflow + dflow;
	}*/
	
	//д����
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
	 * �����л�������hadoop�ڷ����л�ʱҪ�õķ���
	 * �����ǣ����ֽ����лָ���һ��һ����Ʒ����
	 */
	@Override
	public void readFields(DataInput in) throws IOException {
		upflow = in.readLong();
		dflow = in.readLong();
		sumflow = in.readLong();
		
	}
	
	/***
	 * ���л������������������е�����д��������ֽ���
	 */
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeLong(upflow);
		out.writeLong(dflow);
		out.writeLong(sumflow);
	}

	@Override
	public int compareTo(FlowBean o) {
		//�Ӵ�С����
		return (int)(o.getSumflow() - this.sumflow);
		//��С��������
		//return (int)(this.sumflow - o.getSumflow());
	}
	
	
}
