package edu.co.icesi.introspringboot.repo;

import edu.co.icesi.introspringboot.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    List<Permission> findDistinctByRolePermissions_Role_UserRoles_User_Username(String username);
}
