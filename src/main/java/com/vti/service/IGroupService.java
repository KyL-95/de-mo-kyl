package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.dto.GroupDTO;
import com.vti.entity.Group;
import com.vti.form.GroupFormForCreating;
import com.vti.form.GroupFromForUpdating;

public interface IGroupService {

	public Page<Group> getAllGroups(Pageable pageable);
	
	public Page<Group> getAllGroupsV2(Pageable pageable, String search);

	public Group getGroupByID(int id);
	
	public String addGroup(GroupFormForCreating form) ;
	
	public void updateGroup(int id, GroupFromForUpdating form);
	
	public boolean deleteGroup(int id);
	
	public List<Group> findByIdGreaterThanEqual(int id);

	public Group getGroupByGroupNameAndMember(String groupName, Integer member);


}
