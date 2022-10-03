package com.vti.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
// Khánh vừa sửa xong
// Đã update


// Hôm sau làm
// merge into main

@RestController
@RequestMapping(value = "/api/v1/groups")
@CrossOrigin("*") // cho phép ajax bên frontend truy cập API của backend
public class GroupController {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private IGroupService service;

	@GetMapping()
	public ResponseEntity<?> getAllGroups(Pageable pageable) {
		Page<Group> grPages = service.getAllGroups(pageable);
		if (grPages.isEmpty() || grPages == null) {
		return new ResponseEntity<>(new ResponseObj("Not found", "Cannot find data", grPages),
				HttpStatus.NOT_FOUND);
	}
		// get List<Entity> from Page<Entity>
		List<Group> grList = grPages.getContent();
		// convert List<Entity> ---> List <DTO>
		List<GroupDTO> dtoList = modelMapper.map(grList, new TypeToken<List<GroupDTO>>() {}.getType());
		// convert Page<Entity> ---> Page<DTO>
		Page<GroupDTO> dtoPages = new PageImpl<>(dtoList, pageable, grPages.getTotalElements());
		return new ResponseEntity<>(dtoPages, HttpStatus.OK);
	}
	
	@GetMapping("/v2")
	public Page<GroupDTO> getAllGroupsV2(
			Pageable pageable,
			@RequestParam(value = "search", required = false) String search){

		Page<Group> grPages = service.getAllGroupsV2(pageable, search);
		// get List<Entity> from Page<Entity>
		List<Group> grList = grPages.getContent();
		// convert List<Entity> ---> List <DTO>
		List<GroupDTO> dtoList = modelMapper.map(grList, new TypeToken<List<GroupDTO>>() {}.getType());
		// convert Page<Entity> ---> Page<DTO>
		Page<GroupDTO> dtoPages = new PageImpl<>(dtoList, pageable, grPages.getTotalElements());
		return dtoPages;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getGroupByID(@PathVariable(name = "id") int id) {
		Group groupEntity = service.getGroupByID(id);
		// convert entity --> dto
		GroupDTO dto = modelMapper.map(groupEntity, GroupDTO.class);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}

//	@GetMapping("/{id}")
//	public ResponseEntity<List<GroupDTO>> getGroupByIdOrderBy(@PathVariable(name = "id") Integer id) {
//
//		List<GroupDTO> groupFinds = service.findByIdGreaterThanEqual(id);
//		if (groupFinds.size() == 0) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//		}
//
//		return ResponseEntity.status(200).body(groupFinds);
//
//	}

	@GetMapping("/name-member")
	public ResponseEntity<?> getGroupByGroupNameAndMember(	@RequestParam("name") String groupName,
															@RequestParam("member") Integer member){


		Group groupEntity = service.getGroupByGroupNameAndMember(groupName, member);
		// convert entity --> dto
		GroupDTO dto = modelMapper.map(groupEntity, GroupDTO.class);
				return new ResponseEntity<>(dto,HttpStatus.OK);
		
	}
	// value = "/add"
	@PostMapping(value = "/add")
	public String addGroup(@RequestBody GroupFormForCreating form) {
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
