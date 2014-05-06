package edu.tongji.anliantest.utils;

public enum EmployeeTitle {
	GENERAL_MANAGER("总经理"), TECH_DIRECTOR("技术负责人"),
	MARKET_MANAGER("市场部主管"),EVALUATE_MANAGER("评价部主管"),
	DETECT_MANAGER("检测部主管"),QUALITY_MANAGER("质控部主管"),
	ADMIN_MANAGER("行政部主管");
	
	private String title;
	
	private EmployeeTitle(String title){
		this.setTitle(title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String toString(){
		return title;
	}
}
