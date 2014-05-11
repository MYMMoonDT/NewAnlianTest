package edu.tongji.anliantest.utils;

import java.util.ArrayList;
import java.util.List;

public class ConsumerResourceForm {
	public final static String CONSUMER_RESOURCE_TABLE_NUM = "ALJC/JL32-02";
	
	public enum TableType{
		PREVIEW_EVAL("预评"),CONTROL_EVAL("控评");
		private String tableType;
		private TableType(String tableType){
			this.tableType = tableType;
		}
		public String toString(){
			return tableType;
		}
	}
	
	private List<ConsumerResourceFormItem> consumerResourceList = new ArrayList<ConsumerResourceFormItem>();

	public List<ConsumerResourceFormItem> getConsumerResourceList() {
		return consumerResourceList;
	}

	public void setConsumerResourceList(List<ConsumerResourceFormItem> consumerResourceList) {
		this.consumerResourceList = consumerResourceList;
	}
}
