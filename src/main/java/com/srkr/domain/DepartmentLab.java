package com.srkr.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="DepartmentLab")
//department_lab ?
public class DepartmentLab {
	
	
	/*This class is probably not needed */
	private Long departmentID;
	
	private Long labID;

	public Long getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(Long departmentID) {
		this.departmentID = departmentID;
	}

	public Long getLabID() {
		return labID;
	}

	public void setLabID(Long labID) {
		this.labID = labID;
	}
	
	

}
