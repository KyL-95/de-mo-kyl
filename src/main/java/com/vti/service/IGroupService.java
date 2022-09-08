package com.vti.service;

import java.util.List;

import com.vti.dto.GroupDTO;
import com.vti.entity.Group;
import com.vti.form.GroupFormForCreating;
import com.vti.form.GroupFromForUpdating;

public interface IGroupService {

	public List<GroupDTO> getAllGroups();

	public GroupDTO getGroupByID(int id);
	
	public Group addGroup(GroupFormForCreating form);
	
	public void updateGroup(int id, GroupFromForUpdating form);
	
	public boolean deleteGroup(int id);

}
