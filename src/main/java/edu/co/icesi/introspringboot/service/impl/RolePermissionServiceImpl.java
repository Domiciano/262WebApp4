package edu.co.icesi.introspringboot.service.impl;

import edu.co.icesi.introspringboot.entity.RolePermission;
import edu.co.icesi.introspringboot.entity.keys.RolePermissionId;
import edu.co.icesi.introspringboot.repo.RolePermissionRepository;
import edu.co.icesi.introspringboot.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Override
    public List<RolePermission> findAll() {
        return rolePermissionRepository.findAll();
    }

    @Override
    public Optional<RolePermission> findById(RolePermissionId id) {
        return rolePermissionRepository.findById(id);
    }

    @Override
    @Transactional
    public RolePermission save(RolePermission rolePermission) {
        return rolePermissionRepository.save(rolePermission);
    }

    @Override
    @Transactional
    public void deleteById(RolePermissionId id) {
        rolePermissionRepository.deleteById(id);
    }
}
