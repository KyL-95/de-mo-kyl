package com.vti.form;

import java.util.Date;

public class GroupFormForCreating { // Khi chỉ thao tác vs các property cần thiết của Entity Group

	private String groupName;
	
	private int member;
	
	private String creator;
	
	private Date createDate;
	
	public GroupFormForCreating() {
		// TODO Auto-generated constructor stub
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getMember() {
		return member;
	}

	public void setMember(int member) {
		this.member = member;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
