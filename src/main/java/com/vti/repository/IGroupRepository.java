package com.vti.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.vti.entity.Group;
//@Repository
public interface IGroupRepository extends JpaRepository<Group, Integer>, JpaSpecificationExecutor<Group>{

//	Page<Group> findByGroupName(String groupName, Pageable pageable);
	
	public Group findByGroupName(String groupName);
	
	public boolean existsByGroupName(String groupName);
	
	public List<Group> findByIdGreaterThanEqual(int id);

	public Group getGroupByGroupNameAndMember(String groupName, Integer member);
}
