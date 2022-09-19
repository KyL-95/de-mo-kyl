package com.vti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.dto.GroupDTO;
import com.vti.entity.Group;
import com.vti.form.GroupFormForCreating;
import com.vti.form.GroupFromForUpdating;
import com.vti.repository.IGroupRepository;
import com.vti.specification.GroupSpec;

@Service
@Primary
public class GroupService implements IGroupService {

	@Autowired
	private IGroupRepository repository;

	@Override
	public Page<Group> getAllGroups(Pageable pageable) { // convert group --> groupDTO
		
		return repository.findAll(pageable);
	}
	
	public Page<Group> getAllGroupsV2(Pageable pageable, String search) { // convert group --> groupDTO
		
		Specification<Group> where = GroupSpec.buildWhere(search);
		return repository.findAll(where,pageable);
	}

	@Override
	public Group getGroupByID(int id) {
		return repository.findById(id).get();
	}

	@Override
	public String addGroup(GroupFormForCreating form) {
			if(repository.existsByGroupName(form.getGroupName())) {
				return "This group is alredy exists, cannot create...";
			}
			// convert form --> entity:
			Group group = new Group(form.getGroupName(), form.getMember(), form.getCreator(), form.getCreateDate());
			 repository.save(group);
		
		return "Create Success!";
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

	@Override
	public List<Group> findByIdGreaterThanEqual(int id) {

		List<Group> groups = repository.findByIdGreaterThanEqual(id);
		if (groups.size() > 0) {
			return repository.findByIdGreaterThanEqual(id);
		}
		return null;
	}

	@Override
	public Group getGroupByGroupNameAndMember(String groupName, Integer member) {
		return repository.getGroupByGroupNameAndMember(groupName,member);
	}

}
