package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "`group`")
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "GroupID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "GroupName", length = 50, nullable = false, unique = true)
	private String groupName;

	@Column(name = "Member", length = 50, nullable = false)
	private int member;

	@Column(name = "Creator", length = 50, nullable = false, updatable = false)
	private String creator;

	@Column(name = "CreateDate", updatable = false)
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date createDate;

	public Group(String groupName, int member, String creator, Date createDate) {
		this.groupName = groupName;
		this.member = member;
		this.creator = creator;
		this.createDate = createDate;
	}

}
