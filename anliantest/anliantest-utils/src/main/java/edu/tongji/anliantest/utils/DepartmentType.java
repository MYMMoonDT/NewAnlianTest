package edu.tongji.anliantest.utils;

public enum DepartmentType {
	MARKET(1,"市场部"),EVALUATE(2,"评价部"),DETECT(3,"检测部"),
	ADMIN(4,"行政部"),QUALITY(5,"质控部"),GENERAL_MANAGER(6,"总经理"),
	TECH_DIRECTOR(7,"技术负责人");
	
	private int departmentId;
	private String departmentName;
	
	private DepartmentType(int departmentId, String departmentName){
		this.setDepartmentId(departmentId);
		this.setDepartmentName(departmentName);
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String toString(){
		return departmentName;
	}
}
