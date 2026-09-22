package edu.co.icesi.introspringboot.repo;

import edu.co.icesi.introspringboot.entity.RolePermission;
import edu.co.icesi.introspringboot.entity.keys.RolePermissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, RolePermissionId> {

    @Transactional
    void deleteByRole_Id(Integer roleId);

    @Transactional
    void deleteByPermission_Id(Integer permissionId);
}
