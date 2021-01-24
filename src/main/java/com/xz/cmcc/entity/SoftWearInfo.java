package com.xz.cmcc.entity;

import java.util.Date;

public class SoftWearInfo {

	private Integer softwear_id;

	private String softwear_name1;

	private String softwear_name2;

	private SoftWearTypeInfo softWearTypeInfo;

	private String store_path;

	private Date create_date;

	public Integer getSoftwear_id() {
		return softwear_id;
	}

	public void setSoftwear_id(Integer softwear_id) {
		this.softwear_id = softwear_id;
	}

	public String getSoftwear_name1() {
		return softwear_name1;
	}

	public void setSoftwear_name1(String softwear_name1) {
		this.softwear_name1 = softwear_name1;
	}

	public String getSoftwear_name2() {
		return softwear_name2;
	}

	public void setSoftwear_name2(String softwear_name2) {
		this.softwear_name2 = softwear_name2;
	}

	public SoftWearTypeInfo getSoftWearTypeInfo() {
		return softWearTypeInfo;
	}

	public void setSoftWearTypeInfo(SoftWearTypeInfo softWearTypeInfo) {
		this.softWearTypeInfo = softWearTypeInfo;
	}

	public String getStore_path() {
		return store_path;
	}

	public void setStore_path(String store_path) {
		this.store_path = store_path;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

}
