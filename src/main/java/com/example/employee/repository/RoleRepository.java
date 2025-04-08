package com.example.employee.repository;

import com.example.employee.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(exported = false)
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
