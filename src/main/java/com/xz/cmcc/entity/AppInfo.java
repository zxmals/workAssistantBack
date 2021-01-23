package com.xz.cmcc.entity;

public class AppInfo {

	private Integer app_id;

	private String app_name;

	private String app_href;

	private AppTypeInfo apptypeInfo;

	private String img_store_path;

	public Integer getApp_id() {
		return app_id;
	}

	public void setApp_id(Integer app_id) {
		this.app_id = app_id;
	}

	public String getApp_name() {
		return app_name;
	}

	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}

	public String getApp_href() {
		return app_href;
	}

	public void setApp_href(String app_href) {
		this.app_href = app_href;
	}

	public AppTypeInfo getApptypeInfo() {
		return apptypeInfo;
	}

	public void setApptypeInfo(AppTypeInfo apptypeInfo) {
		this.apptypeInfo = apptypeInfo;
	}

	public String getImg_store_path() {
		return img_store_path;
	}

	public void setImg_store_path(String img_store_path) {
		this.img_store_path = img_store_path;
	}

}
