package com.vti.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.dto.GroupDTO;
import com.vti.entity.Group;
import com.vti.form.GroupFormForCreating;
import com.vti.form.GroupFromForUpdating;
import com.vti.repository.IGroupRepository;

@Service
public class GroupService implements IGroupService {

	@Autowired
	private IGroupRepository repository;
	@Override
	public List<GroupDTO> getAllGroups() { // convert group --> groupDTO
		List<Group> groups = repository.findAll();
		List<GroupDTO> grDTOs = new ArrayList<>();
		
		List<String> a = Collections.EMPTY_LIST;
		
		for (String a1 : a) {
			System.out.println(a1);
		}
		
		for (Group group : groups) {
			GroupDTO grDTO = new GroupDTO();
			grDTO.setId(group.getId());
			grDTO.setGroupName(group.getGroupName());
			grDTO.setMember(group.getMember());
			grDTO.setCreator(group.getCreator());
			grDTO.setCreateDate(group.getCreateDate());
			
			grDTOs.add(grDTO);
		}
		return grDTOs;
	}
	@Override
	public GroupDTO getGroupByID(int id) {
		Group group = repository.findById(id).get();
		GroupDTO grDTO = new GroupDTO();
		
		grDTO.setId(group.getId());
		grDTO.setGroupName(group.getGroupName());
		grDTO.setMember(group.getMember());
		grDTO.setCreator(group.getCreator());
		
		
		return grDTO;
	}

	@Override
	public Group addGroup(GroupFormForCreating form) {
		if (form != null) {  
			// convert form --> entity:  
			Group group = new Group(form.getGroupName(), form.getMember(),form.getCreator(),form.getCreateDate());
			return repository.save(group);
		}
		return null;
	}

	@Override
	public void updateGroup(int id, GroupFromForUpdating form) {
		if (form != null) {
//			GroupDTO groupUpdate = getGroupByID(id);
			
			Group groupUpdate = repository.findById(id).get();
			
			
			if (groupUpdate != null) {
				groupUpdate.setGroupName(form.getGroupName());
				groupUpdate.setMember(form.getMember());
				 repository.save(groupUpdate);
				 System.out.println("Update Succsess");
			}

		}
	}

	@Override
	public boolean deleteGroup(int id) {
		if (id > 0) {
			Group groupDelete = repository.findById(id).get();
			if (groupDelete != null) {
				repository.delete(groupDelete);
				return true;
			}
		}

		return false;
	}

}
