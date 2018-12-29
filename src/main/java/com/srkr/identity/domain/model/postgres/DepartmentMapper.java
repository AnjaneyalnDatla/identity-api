package com.srkr.identity.domain.model.postgres;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

	public Department toPostgresObject(com.srkr.identity.domain.model.Department department) {

		Department pgDepartment = new Department();
		pgDepartment.setId(department.id());
		pgDepartment.setName(department.name());
		pgDepartment.setDescription(department.description());
		return pgDepartment;
	}

	public com.srkr.identity.domain.model.Department toDomainObject(Department pgDepartment) {

		return new com.srkr.identity.domain.model.Department(pgDepartment.getId(), pgDepartment.getName(),
				pgDepartment.getDescription());
	}
	
	public Set<Department> toListPostgresObject(Set<com.srkr.identity.domain.model.Department> departments){
		Set<Department> pgDepartments = new HashSet<>();
		departments.forEach(dpt -> {
			pgDepartments.add(toPostgresObject(dpt));
		});
		return pgDepartments;
	}
	
	public Set<com.srkr.identity.domain.model.Department> toListDomainObjects(Set<Department> pgDepartments){
		Set<com.srkr.identity.domain.model.Department> departments = new HashSet<>();
		pgDepartments.forEach(dpt -> {
			departments.add(toDomainObject(dpt));
		});
		return departments;
	}

}
