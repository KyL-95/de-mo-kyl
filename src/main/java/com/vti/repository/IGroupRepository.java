package com.vti.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vti.entity.Group;
@Repository
public interface IGroupRepository extends JpaRepository<Group, Integer>{

//	Page<Group> findByGroupName(String groupName, Pageable pageable);
	
	public Group findByGroupName(String groupName);
	
	public boolean existsByGroupName(String groupName);
}
