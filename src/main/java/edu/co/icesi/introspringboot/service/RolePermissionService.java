package edu.co.icesi.introspringboot.service;

import edu.co.icesi.introspringboot.entity.RolePermission;
import edu.co.icesi.introspringboot.entity.keys.RolePermissionId;

import java.util.List;
import java.util.Optional;

public interface RolePermissionService {

    List<RolePermission> findAll();

    Optional<RolePermission> findById(RolePermissionId id);

    RolePermission save(RolePermission rolePermission);

    void deleteById(RolePermissionId id);

}
