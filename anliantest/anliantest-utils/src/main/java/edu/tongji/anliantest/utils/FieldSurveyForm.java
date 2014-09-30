package edu.tongji.anliantest.utils;

import java.util.ArrayList;
import java.util.List;


public class FieldSurveyForm {
	public final static String FIELD_SURVEY_TABLE_NUM = "ALJC/JL32-13";
	
	private String companyType;
    private String companyIndustry;
    private Integer companyManagerNum;
    private Integer companyEmployeeNum;
    
    private Boolean companySanitationIsExist;
    private String companySanitationName;
    private Integer companySanitationNum;
    
    private String companyProvideResource;
    
    private List<FieldSurveyFormProductItem> fieldSurveyProductItems = new ArrayList<FieldSurveyFormProductItem>();
    private List<FieldSurveyFormContactItem> fieldSurveyContactItems = new ArrayList<FieldSurveyFormContactItem>();
    
    
    
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getCompanyIndustry() {
		return companyIndustry;
	}
	public void setCompanyIndustry(String companyIndustry) {
		this.companyIndustry = companyIndustry;
	}
}
