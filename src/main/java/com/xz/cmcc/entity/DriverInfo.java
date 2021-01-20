package com.xz.cmcc.entity;

import java.util.Date;

public class DriverInfo {

	private Integer dirver_id;

	private String driver_name1;

	private String driver_name2;

	private String store_path;

	private Date create_date;

	private ComputerInfo computerinfo;

	private OperationSystemInfo osinfo;

	public Integer getDirver_id() {
		return dirver_id;
	}

	public void setDirver_id(Integer dirver_id) {
		this.dirver_id = dirver_id;
	}

	public String getDriver_name1() {
		return driver_name1;
	}

	public void setDriver_name1(String driver_name1) {
		this.driver_name1 = driver_name1;
	}

	public String getDriver_name2() {
		return driver_name2;
	}

	public void setDriver_name2(String driver_name2) {
		this.driver_name2 = driver_name2;
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

	public ComputerInfo getComputerinfo() {
		return computerinfo;
	}

	public void setComputerinfo(ComputerInfo computerinfo) {
		this.computerinfo = computerinfo;
	}

	public OperationSystemInfo getOsinfo() {
		return osinfo;
	}

	public void setOsinfo(OperationSystemInfo osinfo) {
		this.osinfo = osinfo;
	}

}
