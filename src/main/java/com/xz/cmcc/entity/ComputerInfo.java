package com.xz.cmcc.entity;

public class ComputerInfo {

	private Integer computer_id;

	private String computer_name;

	private ComputerBrandInfo computerbrand;

	private ComputerModelInfo computermodel;

	public Integer getComputer_id() {
		return computer_id;
	}

	public void setComputer_id(Integer computer_id) {
		this.computer_id = computer_id;
	}

	public String getComputer_name() {
		return computer_name;
	}

	public void setComputer_name(String computer_name) {
		this.computer_name = computer_name;
	}

	public ComputerBrandInfo getComputerbrand() {
		return computerbrand;
	}

	public void setComputerbrand(ComputerBrandInfo computerbrand) {
		this.computerbrand = computerbrand;
	}

	public ComputerModelInfo getComputermodel() {
		return computermodel;
	}

	public void setComputermodel(ComputerModelInfo computermodel) {
		this.computermodel = computermodel;
	}

}
