package com.vti.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Group;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class GroupSpec {

	public static Specification<Group> buildWhere( String search){
		if(search.isBlank()) {
			return null;
		}
		search = search.trim();

		CustomSpec groupName = new CustomSpec("groupName",search);
		return Specification.where(groupName);
	}
}

	
	@SuppressWarnings("serial")
	@RequiredArgsConstructor
	class CustomSpec implements Specification<Group>{
		@NonNull
		private String field;
		@NonNull
		private Object value;

		@Override
		public Predicate toPredicate(Root<Group> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

			if(field.equalsIgnoreCase("groupName")) {
			return criteriaBuilder.like(root.get("groupName"), "%" + value.toString() + "%");
		}
		
				return null;
		}

	}
