package com.vti.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class GroupDTO {

	private int id;
	@JsonProperty("Name")
	private String groupName;
//	private int member;
	private String creator;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createDate;

	public GroupDTO() {
		// TODO Auto-generated constructor stub
	}

	public GroupDTO(int id, String groupName, int member, String creator, Date createDate) {
		this.id = id;
		this.groupName = groupName;
//		this.member = member;
		this.creator = creator;
		this.createDate = createDate;

}
}
