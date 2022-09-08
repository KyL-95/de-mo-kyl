package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.GroupDTO;
import com.vti.entity.Group;
import com.vti.form.GroupFormForCreating;
import com.vti.form.GroupFromForUpdating;
import com.vti.service.IGroupService;

@RestController
@RequestMapping(value = "/api/v1/groups")
@CrossOrigin("*") // cho phép ajax bên frontend truy cập API của backend
public class GroupController {
	@Autowired
	private IGroupService service;

	@PostMapping()
	public List<GroupDTO> getAllGroups() {
		return service.getAllGroups();
	}

	@GetMapping(value = "/{id}")
	public GroupDTO getGroupByID(@PathVariable(name = "id") int id) {
		return service.getGroupByID(id);
	}
	
	// value = "/add"
	@PostMapping( value = "/add")
	public Group addGroup(@RequestBody GroupFormForCreating form) {
		return service.addGroup(form);
	}

	@PutMapping("/{id}")
	public void updateGroup(@PathVariable("id") int id, @RequestBody GroupFromForUpdating form) {
		service.updateGroup(id, form);
		
	}

	@DeleteMapping("/{id}")
	public boolean deleteGroup(@PathVariable("id") int id) {
		return service.deleteGroup(id);
	}
}
