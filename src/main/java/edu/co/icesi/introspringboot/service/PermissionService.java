package edu.co.icesi.introspringboot.service;

import edu.co.icesi.introspringboot.entity.Permission;
import edu.co.icesi.introspringboot.repo.PermissionRepository;
import edu.co.icesi.introspringboot.repo.RolePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    public Optional<Permission> findById(Integer id) {
        return permissionRepository.findById(id);
    }

    @Transactional
    public Permission save(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Transactional
    public void deleteById(Integer id) {
        permissionRepository.deleteById(id);
        rolePermissionRepository.deleteByPermission_Id(id);
    }
}
