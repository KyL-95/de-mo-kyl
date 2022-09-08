package com.vti.dto;

import java.util.Date;

public class GroupDTO {

	private int id;
	private String groupName;
	private int member;
	private String creator;
	private Date createDate;

	public GroupDTO() {
		// TODO Auto-generated constructor stub
	}

	public GroupDTO(int id, String groupName, int member, String creator, Date createDate) {
		this.id = id;
		this.groupName = groupName;
		this.member = member;
		this.creator = creator;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
