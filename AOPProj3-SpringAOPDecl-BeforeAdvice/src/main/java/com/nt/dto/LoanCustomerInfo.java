package com.nt.dto;

public class LoanCustomerInfo {
	private  String custName;
	private  float  loanAmount;
	private  String purpose;
	private  String clerkName;
	private String managerName;
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public float getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(float loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getClerkName() {
		return clerkName;
	}
	public void setClerkName(String clerkName) {
		this.clerkName = clerkName;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	@Override
	public String toString() {
		return "LoanCustomerInfo [custName=" + custName + ", loanAmount=" + loanAmount + ", purpose=" + purpose
				+ ", clerkName=" + clerkName + ", managerName=" + managerName + "]";
	}
	
	

}
