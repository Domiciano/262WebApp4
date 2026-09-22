package edu.co.icesi.introspringboot.service;

import edu.co.icesi.introspringboot.entity.RolePermission;
import edu.co.icesi.introspringboot.entity.keys.RolePermissionId;
import edu.co.icesi.introspringboot.repo.RolePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RolePermissionService {

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    public List<RolePermission> findAll() {
        return rolePermissionRepository.findAll();
    }

    public Optional<RolePermission> findById(RolePermissionId id) {
        return rolePermissionRepository.findById(id);
    }

    @Transactional
    public RolePermission save(RolePermission rolePermission) {
        return rolePermissionRepository.save(rolePermission);
    }

    @Transactional
    public void deleteById(RolePermissionId id) {
        rolePermissionRepository.deleteById(id);
    }
}
